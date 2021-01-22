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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.geoserver.catalog.ProjectionPolicy;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "resource")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public @Data abstract class Resource extends CatalogInfoDto {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "namespace", nullable = false)
    private InfoReference namespace;

    @Column(name = "", nullable = false)
    private InfoReference store;

    @Column(name = "native_name", nullable = false)
    private String nativeName;

    @ElementCollection
    private List<String> alias;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "abstract")
    private String Abstract;

    @ElementCollection
    private List<Keyword> keywords;

    @ElementCollection
    private List<MetadataLink> metadataLinks;

    @ElementCollection
    private List<DataLink> dataLinks;

    @Embedded
    private CRS nativeCRS;

    @Column(name = "srs")
    private String SRS;

    @Embedded
    private EnvelopeDto nativeBoundingBox;

    @Embedded
    private EnvelopeDto latLonBoundingBox;

    @Column(name = "proj_policy")
    private ProjectionPolicy projectionPolicy;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "advertised")
    private Boolean advertised;

    @Column(name = "service_config")
    private boolean serviceConfiguration;

    @ElementCollection
    private List<String> disabledServices;

    @Column(name = "simple_conversion")
    private Boolean simpleConversionEnabled;

    private Map<String, Serializable> metadata;
}
