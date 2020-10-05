/*
 * (c) 2020 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.catalog.service;

import java.nio.ByteBuffer;
import org.geoserver.platform.resource.Resource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** */
public interface ReactiveResourceStore {

    Mono<Resource> get(String path);

    Mono<ByteBuffer> getContents(String path);

    Mono<Boolean> remove(String path);

    Mono<Resource> move(String path, String target);

    Flux<Resource> list(Resource resource);

    Mono<Resource> setContents(String path, ByteBuffer contents);
}
