/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
public @Data class Attribution {
    private String id;
    private String title;
    private String href;
    private String logoURL;
    private int logoWidth;
    private int logoHeight;
    private String logoType;
}
