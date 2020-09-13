package org.geoserver.cloud.catalog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import lombok.Data;
import org.geoserver.catalog.Catalog;
import org.geoserver.catalog.WorkspaceInfo;

@Data
public class Store {
    protected String id;
    protected String name;
    protected String description;
    protected String type;
    protected boolean enabled;
    protected WorkspaceInfo workspace;
    protected transient Catalog catalog;
    protected Throwable error;
    protected Date dateCreated;
    protected Date dateModified;
    private Map<String, Serializable> connectionParameters;
    private Map<String, Serializable> metadata;
}
