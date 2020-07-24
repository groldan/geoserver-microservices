/* (c) 2020 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.cloud.gwc;

import org.geoserver.cloud.core.FilteringXmlBeanDefinitionReader;
import org.geoserver.gwc.config.GeoserverXMLResourceProvider;
import org.geoserver.platform.resource.ResourceStore;
import org.geoserver.wfs.WFSInfoImpl;
import org.geowebcache.config.ConfigurationException;
import org.geowebcache.config.ConfigurationResourceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ConditionalOnClass(value = WFSInfoImpl.class)
@ImportResource( //
    reader = FilteringXmlBeanDefinitionReader.class, //
    locations = { //
        "jar:gs-gwc-.*!/applicationContext.xml"
    }
)
public class GWCConfiguration {
    //	<bean id="gwcXmlConfigResourceProvider"
    // class="org.geoserver.gwc.config.GeoserverXMLResourceProvider">
    //    <constructor-arg value="geowebcache.xml" />
    //    <constructor-arg ref="resourceStore" />
    //    </bean>

    public @Bean ConfigurationResourceProvider gwcXmlConfigResourceProvider(
            @Qualifier("resourceStore") ResourceStore resourceStore) throws ConfigurationException {

        String providedConfigDirectory = "";
        String configFileName = "geowebcache.xml";
        return new GeoserverXMLResourceProvider(
                providedConfigDirectory, configFileName, resourceStore);
    }
}
