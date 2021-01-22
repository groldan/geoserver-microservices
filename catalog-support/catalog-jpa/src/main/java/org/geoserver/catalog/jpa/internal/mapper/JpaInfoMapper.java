/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.mapper;

import org.geoserver.catalog.Info;
import org.geoserver.catalog.jpa.internal.catalog.entity.InfoDto;

/**
 * 
 */
public interface JpaInfoMapper<INFO extends Info, ENTITY extends InfoDto> {

    INFO toInfo(ENTITY entity);

    ENTITY toJpa(INFO info);
}
