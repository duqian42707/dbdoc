package com.dqv5.dbdoc.config;

import cn.smallbun.screw.core.engine.EngineFileType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author duqian
 * @date 2021/6/2
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "dbdoc")
public class DbdocConfigProperties {

    private String outputDir;
    private EngineFileType fileType;
    private String description;
    private String version;
    private List<String> tableNames;
    private List<String> tablePrefixes;
    private List<String> tableSuffixes;
    private List<String> ignoreTableNames;
    private List<String> ignorePrefixes;
    private List<String> ignoreSuffixes;


}
