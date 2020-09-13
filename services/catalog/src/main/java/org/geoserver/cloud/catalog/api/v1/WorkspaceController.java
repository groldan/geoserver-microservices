/*
 * (c) 2020 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.catalog.api.v1;

import org.geoserver.catalog.WorkspaceInfo;
import org.geoserver.catalog.impl.WorkspaceInfoImpl;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Function;
import lombok.Getter;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(WorkspaceController.BASE_URI)
public class WorkspaceController extends AbstractCatalogInfoController<WorkspaceInfo> {

    public static final String BASE_URI = BASE_API_URI + "/workspaces";

    private final @Getter Class<WorkspaceInfo> infoType = WorkspaceInfo.class;


    @Nullable
    @GetMapping(path = "/default", produces = "application/xml")
    public Mono<WorkspaceInfo> getDefault() {
        WorkspaceInfoImpl fake = new WorkspaceInfoImpl();
        fake.setId("fake-ws-id");
        fake.setName("fakse-ws");
        return Mono.just(fake);
    }

    @Override
    protected Function<WorkspaceInfo, Object> getMapperFunction() {
        return mapper::map;
    }

    // @GetMapping(path = "/query/all")
    // public Flux<WorkspaceInfo> findAll(
    // @RequestParam(name = "subtype", required = false) ClassMappings type) {
    //
    // return Flux.fromStream(() -> {
    // System.err.println("getting workspaces in " + Thread.currentThread().getName());
    // return catalog.getWorkspaces().stream();}).publishOn(catalogScheduler);
    // }

}
