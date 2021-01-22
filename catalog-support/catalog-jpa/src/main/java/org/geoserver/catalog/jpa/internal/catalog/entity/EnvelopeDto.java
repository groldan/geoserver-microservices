/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
public @Data class EnvelopeDto {
    private double x1, x2, y1, y2;
}
