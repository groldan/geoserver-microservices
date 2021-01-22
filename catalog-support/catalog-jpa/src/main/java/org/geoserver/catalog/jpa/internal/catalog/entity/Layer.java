/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.geoserver.catalog.PublishedType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue(value = "1")
@EqualsAndHashCode(callSuper = true)
public @Data class Layer extends Published {
    public enum WMSInterpolation {
        Nearest, Bilinear, Bicubic
    }

    @Column(name = "l_path")
    protected String path;

    @Column(name = "l_default_style")
    protected InfoReference defaultStyle;

    @Column(name = "l_resource")
    protected InfoReference resource;

    @Column(name = "l_legend")
    protected Legend legend;

    @Column(name = "l_type")
    private PublishedType type;

    @Column(name = "l_queryable")
    protected Boolean queryable;

    @Column(name = "l_opaque")
    protected Boolean opaque;

    @Column(name = "l_def_wms_interpolation")
    protected WMSInterpolation defaultWMSInterpolationMethod;

    @Column(name = "l_styles")
    protected Set<InfoReference> styles = new HashSet<>();
}
