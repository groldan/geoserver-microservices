/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "resource_wms_layer")
@EqualsAndHashCode(callSuper = true)
public @Data class WMSLayer extends Resource {
    private String forcedRemoteStyle = "";
    private String preferredFormat;
    private Double minScale;
    private Double maxScale;
    private boolean metadataBBoxRespected;
    private List<String> selectedRemoteFormats;
    private List<String> selectedRemoteStyles;
}
