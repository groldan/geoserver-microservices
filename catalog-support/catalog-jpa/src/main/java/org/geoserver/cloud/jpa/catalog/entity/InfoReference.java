/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.jpa.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.geoserver.catalog.impl.ClassMappings;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoReference {
    private @NonNull ClassMappings type;
    private @NonNull String id;
}
