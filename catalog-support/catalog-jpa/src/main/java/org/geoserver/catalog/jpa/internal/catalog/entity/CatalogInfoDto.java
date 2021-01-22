/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public @Data abstract class CatalogInfoDto extends InfoDto {

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
}
