/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import lombok.Data;

public @Data class Legend {
    private String id;
    private int width;
    private int height;
    private String format;
    private String onlineResource;
}
