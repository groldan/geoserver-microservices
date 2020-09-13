package org.geoserver.cloud.catalog.modelmapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    // uses = {SimpleTypeMapper.class},
    injectionStrategy = InjectionStrategy.FIELD,
    uses = {ObjectFacotries.class}
)
public class SpringCatalogInfoMapperConfig {}
