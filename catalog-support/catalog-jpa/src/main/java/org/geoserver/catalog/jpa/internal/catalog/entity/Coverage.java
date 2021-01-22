/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "resource_coverage")
@EqualsAndHashCode(callSuper = true)
public @Data class Coverage extends Resource {

    @Column(name = "native_coverage_name", nullable = false)
    private String nativeCoverageName;

    @Column(name = "native_format", nullable = false)
    private String nativeFormat;

    @Column(name = "default_interpolation")
    private String defaultInterpolationMethod;

    @Embedded
    private GridGeometry2DDto grid;

    @ElementCollection
    private List<String> supportedFormats;

    @ElementCollection
    private List<String> interpolationMethods;

    @ElementCollection
    private List<CoverageDimension> dimensions;

    @ElementCollection
    private List<String> requestSRS;

    @ElementCollection
    private List<String> responseSRS;
    private Map<String, Serializable> parameters;
}
