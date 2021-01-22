/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import javax.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode(callSuper = true)
public @Data class ReferencedEnvelopeDto extends EnvelopeDto {
    private CRS crs;
}
