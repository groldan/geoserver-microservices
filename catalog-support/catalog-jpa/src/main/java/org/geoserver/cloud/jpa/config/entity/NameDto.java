/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.jpa.config.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/** DTO for {@link org.opengis.feature.type.Name} */
@Embeddable
public @Data class NameDto {
    
    @Column(name = "namespace_uri")
    private String namespaceURI;
    
    @Column(name = "localPart")
    private String localPart;
}
