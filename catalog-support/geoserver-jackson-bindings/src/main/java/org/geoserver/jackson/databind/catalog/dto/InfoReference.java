/*
 * (c) 2020 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.jackson.databind.catalog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.geoserver.catalog.impl.ClassMappings;

/** Acts as a union for a reference to an object or the object itself */
@Data
@NoArgsConstructor
public class InfoReference {
    private ClassMappings type;
    private String id;
    private CatalogInfoDto value;

    /** Reference constructor */
    public InfoReference(ClassMappings type, String id) {
        this.type = type;
        this.id = id;
    }

    /** Value constructor */
    public InfoReference(CatalogInfoDto value) {
        this.value = value;
    }
}
