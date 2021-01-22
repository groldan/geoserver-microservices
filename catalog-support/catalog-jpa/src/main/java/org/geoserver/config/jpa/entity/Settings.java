/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.config.jpa.entity;

import java.io.Serializable;
import java.util.Map;
import org.geoserver.catalog.jpa.internal.catalog.entity.InfoReference;
import org.geoserver.config.SettingsInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/** DTO for {@link SettingsInfo} */
@EqualsAndHashCode(callSuper = true)
public @Data class Settings extends ConfigInfoDto {
    private InfoReference workspace;
    private String title;
    private Contact contact;
    private String charset;
    private int numDecimals;
    private String onlineResource;
    private String proxyBaseUrl;
    private String schemaBaseUrl;
    private boolean verbose;
    private boolean verboseExceptions;
    private Map<String, Serializable> metadata;
    // seems not to be used at all in geoserver
    // Map<Object, Object> clientProperties;
    private boolean localWorkspaceIncludesPrefix;
    private boolean showCreatedTimeColumnsInAdminList;
    private boolean showModifiedTimeColumnsInAdminList;
}
