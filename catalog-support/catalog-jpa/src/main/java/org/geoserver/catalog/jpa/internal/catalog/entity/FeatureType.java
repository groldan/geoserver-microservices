/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.catalog.jpa.internal.catalog.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "resource_featuretype")
@EqualsAndHashCode(callSuper = true)
public @Data class FeatureType extends Resource {
    private String cqlFilter;

    private int maxFeatures;
    private int numDecimals;
    private boolean padWithZeros;
    private boolean forcedDecimal;

    private List<AttributeType> attributes;
    private List<String> responseSRS;

    private boolean overridingServiceSRS;
    private boolean skipNumberMatched;
    private boolean circularArcPresent;
    private boolean encodeMeasures;
    private String linearizationTolerance;
}
