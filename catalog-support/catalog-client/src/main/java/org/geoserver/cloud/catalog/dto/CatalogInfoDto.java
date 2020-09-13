package org.geoserver.cloud.catalog.dto;

import java.util.Date;
import lombok.Data;

@Data
public abstract class CatalogInfoDto {
    private String id;
    private Date dateCreated;
    private Date dateModified;
}
