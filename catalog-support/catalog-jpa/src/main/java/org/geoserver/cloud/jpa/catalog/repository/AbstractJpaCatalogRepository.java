/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.jpa.catalog.repository;

import org.geoserver.cloud.jpa.catalog.entity.CatalogInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 */
public interface AbstractJpaCatalogRepository<D extends CatalogInfoDto>
        extends JpaRepository<D, String> {

}
