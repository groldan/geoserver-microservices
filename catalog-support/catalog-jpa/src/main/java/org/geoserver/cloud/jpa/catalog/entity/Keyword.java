/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.jpa.catalog.entity;

import lombok.Data;

public @Data class Keyword {
    private String value;
    private String language;
    private String vocabulary;
}
