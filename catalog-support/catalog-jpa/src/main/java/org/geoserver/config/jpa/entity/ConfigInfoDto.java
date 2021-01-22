/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.config.jpa.entity;

import org.geoserver.catalog.jpa.internal.catalog.entity.InfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public @Data class ConfigInfoDto extends InfoDto {
}
