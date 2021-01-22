/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa;

import java.util.Optional;
import org.geoserver.catalog.WorkspaceInfo;
import org.geoserver.catalog.jpa.internal.catalog.entity.Workspace;
import org.geoserver.catalog.jpa.internal.mapper.WorkspaceMapper;
import org.geoserver.catalog.jpa.internal.repository.JpaWorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import lombok.Getter;
import lombok.NonNull;

/**
 * 
 */
public class WorkspaceRepositoryAdaptor
        extends AbstractRepositoryAdaptor<WorkspaceInfo, Workspace, JpaWorkspaceRepository>
        implements org.geoserver.catalog.plugin.CatalogInfoRepository.WorkspaceRepository {

    private final @Getter Class<WorkspaceInfo> contentType = WorkspaceInfo.class;

    public @Autowired WorkspaceRepositoryAdaptor(JpaWorkspaceRepository repository,
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
