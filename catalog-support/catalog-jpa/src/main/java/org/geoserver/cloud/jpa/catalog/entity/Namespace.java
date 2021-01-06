/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.jpa.catalog.entity;

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
@Table(name = "namespace")
@EqualsAndHashCode(callSuper = true)
public @Data class Namespace extends CatalogInfoDto {
    @Column(name = "prefix")
    private String prefix;

    @Column(name = "uri")
    private String URI;

    @Column(name = "isolated")
    private boolean isolated;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "namespace_metadata")
    private Map<String, MetadataItem> metadata = new HashMap<>();
}
