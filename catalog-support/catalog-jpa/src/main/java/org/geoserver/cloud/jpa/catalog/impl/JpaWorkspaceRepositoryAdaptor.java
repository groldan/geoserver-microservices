/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.jpa.catalog.impl;

import java.util.Optional;
import org.geoserver.catalog.WorkspaceInfo;
import org.geoserver.catalog.plugin.CatalogInfoRepository.WorkspaceRepository;
import org.geoserver.cloud.jpa.catalog.entity.Workspace;
import org.geoserver.cloud.jpa.catalog.repository.JpaWorkspaceRepository;
import org.geoserver.cloud.jpa.mapper.WorkspaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import lombok.Getter;
import lombok.NonNull;

/**
 * 
 */
public class JpaWorkspaceRepositoryAdaptor
        extends AbstractRepositoryAdaptor<WorkspaceInfo, Workspace, JpaWorkspaceRepository>
        implements WorkspaceRepository {

    private final @Getter Class<WorkspaceInfo> contentType = WorkspaceInfo.class;

    public @Autowired JpaWorkspaceRepositoryAdaptor(JpaWorkspaceRepository repository,
            WorkspaceMapper mapper) {
        super(repository, mapper);
    }

    @Transactional
    public @Override void unsetDefaultWorkspace() {
        throw new UnsupportedOperationException("unimplemented");
    }

    @Transactional
    public @Override void setDefaultWorkspace(@NonNull WorkspaceInfo workspace) {
        throw new UnsupportedOperationException("unimplemented");
    }

    public @Override Optional<WorkspaceInfo> getDefaultWorkspace() {
        throw new UnsupportedOperationException("unimplemented");
    }
}
