/*
 * (c) 2021 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.cloud.bus.event;

import org.springframework.cloud.stream.binder.BinderFactory;
import org.springframework.cloud.stream.config.BindingServiceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;

/** */
@Configuration
public class TestSpringCloudBusConfig {

    @Bean
    public TestBindingService bindingService(
            BindingServiceProperties bindingServiceProperties,
            BinderFactory binderFactory,
            TaskScheduler taskScheduler) {

        return new TestBindingService(bindingServiceProperties, binderFactory, taskScheduler);
    }
}
