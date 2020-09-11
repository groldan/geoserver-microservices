/*
 * (c) 2020 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.plugin.forwarding;

import java.util.List;
import org.geoserver.catalog.DataStoreInfo;
import org.geoserver.catalog.StoreInfo;
import org.geoserver.catalog.WorkspaceInfo;
import org.geoserver.catalog.plugin.CatalogInfoRepository.StoreRepository;

public class ForwardingStoreRepository
        extends ForwardingCatalogRepository<StoreInfo, StoreRepository> implements StoreRepository {

    public ForwardingStoreRepository(StoreRepository subject) {
        super(subject);
    }

    public @Override void setDefaultDataStore(WorkspaceInfo workspace, DataStoreInfo dataStore) {
        subject.setDefaultDataStore(workspace, dataStore);
    }

    public @Override DataStoreInfo getDefaultDataStore(WorkspaceInfo workspace) {
        return subject.getDefaultDataStore(workspace);
    }

    public @Override List<DataStoreInfo> getDefaultDataStores() {
        return subject.getDefaultDataStores();
    }

    public @Override <T extends StoreInfo> List<T> findAllByWorkspace(
            WorkspaceInfo workspace, Class<T> clazz) {
        return subject.findAllByWorkspace(workspace, clazz);
    }

    public @Override <T extends StoreInfo> List<T> findAllByType(Class<T> clazz) {
        return subject.findAllByType(clazz);
    }

    public @Override <T extends StoreInfo> T findByNameAndWorkspace(
            String name, WorkspaceInfo workspace, Class<T> clazz) {
        return subject.findByNameAndWorkspace(name, workspace, clazz);
    }
}
