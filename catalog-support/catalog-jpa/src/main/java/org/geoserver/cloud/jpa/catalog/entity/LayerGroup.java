/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.jpa.catalog.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue(value = "2")
@EqualsAndHashCode(callSuper = true)
public @Data class LayerGroup extends Published {

    public enum Mode {
        SINGLE, OPAQUE_CONTAINER, NAMED, CONTAINER, EO
    }

    @Column(name = "lg_mode")
    protected Mode mode = Mode.SINGLE;

    @Column(name = "lg_query_disabled")
    protected Boolean queryDisabled;

    @Column(name = "lg_workspace")
    protected InfoReference workspace;

    @Column(name = "lg_root_layer")
    protected InfoReference rootLayer;

    @Column(name = "lg_root_style")
    protected InfoReference rootLayerStyle;

    @Column(name = "lg_layers")
    protected List<InfoReference> layers = new ArrayList<>();

    @Column(name = "lg_styles")
    protected List<InfoReference> styles = new ArrayList<>();

    @Column(name = "lg_metadata_links")
    protected List<MetadataLink> metadataLinks = new ArrayList<>();

    @Column(name = "lg_bounds")
    protected ReferencedEnvelopeDto bounds;

    @ElementCollection
    private List<Keyword> keywords = new ArrayList<>();
}
