/*
 * (c) 2020 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.geofence.config;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration(proxyBeanMethods = true)
@ImportResource( //
    reader = XmlBeanDefinitionReader.class, //
    locations = {
        "classpath*:applicationContext-client.xml",
        "classpath*:applicationContext.xml"
    } //
)
public class GeofenceAutoConfiguration {}
