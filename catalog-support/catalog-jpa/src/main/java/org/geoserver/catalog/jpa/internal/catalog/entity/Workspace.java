/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "workspace")
@EqualsAndHashCode(callSuper = true)
public @Data class Workspace extends CatalogInfoDto {
    @Column(name = "name")
    private String name;

    @Column(name = "isolated")
    private boolean isolated;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "workspace_metadata")
    private Map<String, MetadataItem> metadata = new HashMap<>();
}
