/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import lombok.Data;
import javax.persistence.Embeddable;
import org.geoserver.config.util.XStreamPersister;
import org.geotools.coverage.grid.GridGeometry2D;

/**
 * DTO for {@link GridGeometry2D}
 *
 * @see XStreamPersister#GridGeometry2DConverter
 */
@Embeddable
public @Data class GridGeometry2DDto {
    private int[] low;
    private int[] high;
    private double[] transform;
    private CRS crs;
}
