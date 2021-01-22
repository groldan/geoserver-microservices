/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "published")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "published_entity_type", discriminatorType = DiscriminatorType.INTEGER)
@EqualsAndHashCode(callSuper = true)
public @Data abstract class Published extends CatalogInfoDto {

    @Column(nullable = false)
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "abstract")
    private String Abstract;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "advertised")
    private boolean advertised;

    @ElementCollection
    private List<AuthorityURL> authorityURLs;

    @ElementCollection
    private List<LayerIdentifier> identifiers;

    @Embedded
    private Attribution attribution;

    private Map<String, Serializable> metadata;
}
