package org.geoserver.cloud.catalog.modelmapper;

import org.geoserver.catalog.NamespaceInfo;
import org.geoserver.catalog.WorkspaceInfo;
import org.geoserver.cloud.catalog.model.Namespace;
import org.geoserver.cloud.catalog.model.Workspace;
import org.mapstruct.Mapper;

@Mapper(config = SpringCatalogInfoMapperConfig.class)
public interface CatalogInfoMapper {

    WorkspaceInfo map(Workspace o);

    Workspace map(WorkspaceInfo o);

    NamespaceInfo map(Namespace o);

    Namespace map(NamespaceInfo o);
}
