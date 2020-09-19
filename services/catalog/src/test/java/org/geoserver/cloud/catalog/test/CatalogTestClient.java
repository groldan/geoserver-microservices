/*
 * (c) 2020 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.catalog.test;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import javax.annotation.Nullable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.geoserver.catalog.CatalogInfo;
import org.geoserver.catalog.impl.ClassMappings;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.RequestBodySpec;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

@RequiredArgsConstructor
public class CatalogTestClient<C extends CatalogInfo> {

    private final @NonNull WebTestClient client;

    protected final @NonNull Class<C> infoType;

    protected final @NonNull String baseUri;

    public ResponseSpec create(C info) {
        return doPost(info, baseUri);
    }

    public ResponseSpec update(C info) {
        return putAbsoluteURI(info, baseUri);
    }

    public ResponseSpec delete(C info) {
        return doDelete(info, baseUri + "/{id}", info.getId());
    }

    public ResponseSpec findById(@NonNull C expected) {
        Class<? extends C> type = ClassMappings.fromImpl(expected.getClass()).getInterface();
        return findById(expected.getId(), type);
    }

    public ResponseSpec findById(String id) {
        return findById(id, infoType);
    }

    /**
     * Calls {@link #findById(String, ClassMappings)} on the controller under test and for the
     * requested subtype, if provided.
     */
    public ResponseSpec findById(String id, @NonNull Class<? extends C> requestedType) {
        String uri = baseUri + "/{id}?subtype={subtype}";
        ClassMappings subType = null;
        if (!infoType.equals(requestedType)) {
            subType = ClassMappings.fromInterface(requestedType);
        }

        return getWithAbsolutePath(uri, id, subType);
    }

    public C getByName(String name) {
        return findByName(name, infoType)
                .expectStatus()
                .isOk()
                .expectBody(infoType)
                .returnResult()
                .getResponseBody();
    }

    public ResponseSpec findByName(String name) {
        return findByName(name, infoType);
    }

    public ResponseSpec findByName( //
            String name, //
            @NonNull Class<? extends C> requestedType) {
        return findByName(name, null, requestedType);
    }

    /**
     * Calls {@link #findByName(String, String, ClassMappings)} on the controller under test and for
     * the requested subtype, if provided.
     */
    public ResponseSpec findByName( //
            String localName, //
            @Nullable String namespaceContext, //
            @NonNull Class<? extends C> requestedType) {

        String uri = baseUri + "/name/{name}?namespace={namespace}&subtype={subtype}";
        ClassMappings subType = null;
        if (!infoType.equals(requestedType)) {
            subType = ClassMappings.fromInterface(requestedType);
        }

        return getWithAbsolutePath(uri, localName, namespaceContext, subType);
    }

    public <T extends CatalogInfo> ResponseSpec getRelative(String uri, Object... uriVariables) {
        uri = baseUri + uri;
        return client.get().uri(uri, uriVariables).exchange();
    }

    public <T extends CatalogInfo> ResponseSpec getWithAbsolutePath(
            String uri, Object... uriVariables) {
        return client.get().uri(uri, uriVariables).exchange();
    }

    public ResponseSpec doPost(
            @NonNull Object requestBody, //
            @NonNull String uri,
            Object... uriVariables) {

        return client.post()
                .uri(uri, uriVariables)
                .contentType(APPLICATION_JSON)
                .bodyValue(requestBody)
                .exchange();
    }

    public ResponseSpec put(@NonNull String uri, Object... uriVariables) {
        return putAbsoluteURI(null, baseUri + uri, uriVariables);
    }

    public ResponseSpec putWithBody(
            @NonNull Object requestBody, @NonNull String uri, Object... uriVariables) {
        return putAbsoluteURI(requestBody, baseUri + uri, uriVariables);
    }

    public ResponseSpec putAbsoluteURI(
            @Nullable Object requestBody, //
            @NonNull String uri,
            Object... uriVariables) {

        RequestBodySpec bodySpec =
                client.put().uri(uri, uriVariables).contentType(APPLICATION_JSON);
        if (requestBody != null) return bodySpec.bodyValue(requestBody).exchange();

        return bodySpec.exchange();
    }

    public ResponseSpec doDelete(
            @NonNull Object requestBody, //
            @NonNull String uri,
            Object... uriVariables) {

        return client.delete().uri(uri, uriVariables).accept(APPLICATION_JSON).exchange();
    }
}