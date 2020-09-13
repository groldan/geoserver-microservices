package org.geoserver.cloud.catalog.model;

import java.io.Serializable;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Workspace extends BaseInfo {
    protected String name;
    private boolean isolated;
    protected Map<String, Serializable> metadata;
}
