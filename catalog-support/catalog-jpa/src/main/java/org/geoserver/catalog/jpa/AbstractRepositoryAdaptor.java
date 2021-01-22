/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa;

import java.util.Optional;
import java.util.stream.Stream;
import org.geoserver.catalog.CatalogInfo;
import org.geoserver.catalog.jpa.internal.catalog.entity.CatalogInfoDto;
import org.geoserver.catalog.jpa.internal.mapper.JpaInfoMapper;
import org.geoserver.catalog.jpa.internal.repository.AbstractJpaCatalogRepository;
import org.geoserver.catalog.plugin.CatalogInfoRepository;
import org.geoserver.catalog.plugin.Patch;
import org.geoserver.catalog.plugin.Query;
import org.opengis.filter.Filter;
import org.springframework.transaction.annotation.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 */
@Transactional(readOnly = true)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Accessors(fluent = true)
public abstract class AbstractRepositoryAdaptor<INFO extends CatalogInfo, ENTITY extends CatalogInfoDto, R extends AbstractJpaCatalogRepository<ENTITY>>
        implements CatalogInfoRepository<INFO> {

    private final @NonNull @Getter R repository;
    private final @NonNull @Getter JpaInfoMapper<INFO, ENTITY> mapper;

    @Transactional
    public @Override void add(@NonNull INFO value) {
        throw new UnsupportedOperationException("unimplemented");
    }

    @Transactional
    public @Override void remove(@NonNull INFO value) {
        throw new UnsupportedOperationException("unimplemented");
    }

    @Transactional
    public @Override <I extends INFO> I update(@NonNull I value, @NonNull Patch patch) {
        throw new UnsupportedOperationException("unimplemented");
    }

    public @Override void dispose() {
        throw new UnsupportedOperationException("unimplemented");
    }

    public @Override <U extends INFO> Stream<U> findAll(Query<U> query) {
        throw new UnsupportedOperationException("unimplemented");
    }

    public @Override <U extends INFO> long count(Class<U> of, Filter filter) {
        throw new UnsupportedOperationException("unimplemented");
    }

    public @Override <U extends INFO> Optional<U> findById(@NonNull String id, Class<U> clazz) {
        throw new UnsupportedOperationException("unimplemented");
    }

    public @Override <U extends INFO> Optional<U> findFirstByName(@NonNull String name,
            Class<U> clazz) {
        throw new UnsupportedOperationException("unimplemented");
    }

    public @Override boolean canSortBy(@NonNull String propertyName) {
        throw new UnsupportedOperationException("unimplemented");
    }

    @Transactional
    public @Override void syncTo(@NonNull CatalogInfoRepository<INFO> target) {
        throw new UnsupportedOperationException("unimplemented");
    }
}
