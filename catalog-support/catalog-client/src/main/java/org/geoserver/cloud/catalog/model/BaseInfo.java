package org.geoserver.cloud.catalog.model;

import java.util.Date;
import lombok.Data;

@Data
public abstract class BaseInfo {
    protected String id;
    protected Date dateCreated;
    protected Date dateModified;
}
