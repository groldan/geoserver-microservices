/*
 * (c) 2020 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.geoserver.jackson.databind.config.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.geoserver.catalog.LayerInfo.WMSInterpolation;
import org.geoserver.catalog.impl.AuthorityURL;
import org.geoserver.catalog.impl.LayerIdentifier;
import org.geoserver.config.ServiceInfo;
import org.geoserver.jackson.databind.catalog.dto.InfoReference;
import org.geoserver.jackson.databind.catalog.dto.Keyword;
import org.geoserver.jackson.databind.catalog.dto.MetadataLink;
import org.geoserver.security.CatalogMode;
import org.geoserver.wfs.GMLInfoImpl;
import org.geoserver.wfs.WFSInfo.ServiceLevel;
import org.geoserver.wfs.WFSInfo.Version;
import org.geoserver.wms.CacheConfiguration;
import org.geoserver.wms.WatermarkInfoImpl;
import org.geoserver.wps.ProcessGroupInfo;
import org.geoserver.wps.ProcessInfo;
import org.geotools.coverage.grid.io.OverviewPolicy;

/** DTO for {@link ServiceInfo} */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Service.WmsService.class, name = "WMSInfo"),
    @JsonSubTypes.Type(value = Service.WfsService.class, name = "WFSInfo"),
    @JsonSubTypes.Type(value = Service.WcsService.class, name = "WCSInfo"),
    @JsonSubTypes.Type(value = Service.WpsService.class, name = "WPSInfo")
})
@EqualsAndHashCode(callSuper = true)
public @Data class Service extends ConfigInfoDto {
    private String name;
    private InfoReference workspace;
    private boolean citeCompliant;
    private boolean enabled;
    private String onlineResource;
    private String title;
    private String Abstract;
    private String maintainer;
    private String fees;
    private String accessConstraints;
    private List<String> versions;
    private List<Keyword> keywords;
    private List<String> exceptionFormats;
    private MetadataLink metadataLink;
    private String outputStrategy;
    private String schemaBaseURL;
    private boolean verbose;
    private Map<String, Serializable> metadata;
    // not used
    // Map<Object, Object> clientProperties;

    @EqualsAndHashCode(callSuper = true)
    public static @Data class WmsService extends Service {
        // Works well as POJO, no need to create a separate DTO
        private WatermarkInfoImpl watermark;
        // enum, direct use
        private WMSInterpolation interpolation;
        private List<String> SRS;
        private Set<String> GetMapMimeTypes;
        private boolean GetMapMimeTypeCheckingEnabled;
        private Set<String> GetFeatureInfoMimeTypes;
        private boolean GetFeatureInfoMimeTypeCheckingEnabled;
        private Boolean BBOXForEachCRS;
        private int maxBuffer;
        private int maxRequestMemory;
        private int maxRenderingTime;
        private int maxRenderingErrors;
        private List<AuthorityURL> authorityURLs;
        private List<LayerIdentifier> identifiers;
        private String rootLayerTitle;
        private String rootLayerAbstract;
        private Boolean dynamicStylingDisabled;
        private boolean featuresReprojectionDisabled;
        private int maxRequestedDimensionValues;
        // CacheConfiguration is a POJO, use it directly
        private CacheConfiguration cacheConfiguration;
        private int remoteStyleMaxRequestTime;
        private int remoteStyleTimeout;
    }

    @EqualsAndHashCode(callSuper = true)
    public static @Data class WfsService extends Service {
        private Map<Version, GMLInfoImpl> GML;
        private int maxFeatures;
        private ServiceLevel serviceLevel;
        private boolean featureBounding;
        private boolean canonicalSchemaLocation;
        private boolean encodeFeatureMember;
        private boolean hitsIgnoreMaxFeatures;
        private Integer maxNumberOfFeaturesForPreview;
        private List<String> SRS;
        private Boolean allowGlobalQueries;
        private boolean simpleConversionEnabled;
    }

    @EqualsAndHashCode(callSuper = true)
    public static @Data class WcsService extends Service {
        private boolean GMLPrefixing;
        private long maxInputMemory;
        private long maxOutputMemory;
        private OverviewPolicy overviewPolicy;
        private boolean subsamplingEnabled;
        private boolean LatLon;
        private List<String> SRS;
        private int maxRequestedDimensionValues;
    }

    @EqualsAndHashCode(callSuper = true)
    public static @Data class WpsService extends Service {
        private double connectionTimeout;
        private int resourceExpirationTimeout;
        private int maxSynchronousProcesses;
        private int maxAsynchronousProcesses;
        private List<ProcessGroup> processGroups;
        private String storageDirectory;
        private CatalogMode catalogMode;
        private int maxComplexInputSize;
        private int maxAsynchronousExecutionTime;
        private Integer maxAsynchronousTotalTime;
        private int maxSynchronousExecutionTime;
        private Integer maxSynchronousTotalTime;

        /** DTO for {@link ProcessGroupInfo} */
        public static @Data class ProcessGroup {
            private String factoryClass;
            private boolean isEnabled;
            private List<WpsService.Process> filteredProcesses;
            private Map<String, Serializable> metadata;
            private List<String> roles;
        }
        /** DTO for {@link ProcessInfo} */
        public static @Data class Process {
            private NameDto name;
            private boolean enabled;
            private List<String> roles;
        }
    }
}
