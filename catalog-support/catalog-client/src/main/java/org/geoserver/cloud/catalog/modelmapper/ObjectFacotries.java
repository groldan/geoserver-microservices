package org.geoserver.cloud.catalog.modelmapper;

import java.util.function.Supplier;
import org.geoserver.catalog.Info;
import org.geoserver.catalog.NamespaceInfo;
import org.geoserver.catalog.WorkspaceInfo;
import org.geoserver.catalog.impl.NamespaceInfoImpl;
import org.geoserver.catalog.impl.WorkspaceInfoImpl;
import org.geoserver.cloud.catalog.model.Namespace;
import org.geoserver.cloud.catalog.model.Workspace;
import org.geoserver.ows.util.OwsUtils;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
public class ObjectFacotries {

    public @ObjectFactory WorkspaceInfo workspaceInfoImpl(
            Workspace source, @TargetType Class<WorkspaceInfo> type) {
        return create(source.getId(), WorkspaceInfoImpl::new);
    }

    public @ObjectFactory NamespaceInfo namespaceInfoImpl(
            Namespace source, @TargetType Class<NamespaceInfo> type) {
        return create(source.getId(), NamespaceInfoImpl::new);
    }

    public <T extends Info> T create(String id, Supplier<T> factoryMethod) {
        T info = factoryMethod.get();
        OwsUtils.set(info, "id", id);
        return info;
    }
}
