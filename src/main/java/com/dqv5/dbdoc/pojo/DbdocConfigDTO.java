package com.dqv5.dbdoc.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author duqian
 * @date 2021/6/2
 */
@Data
public class DbdocConfigDTO {

    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private String dbSchema;

    private String fileType;
    private String description;
    private String version;

    private List<String> tableNames;
    private List<String> tablePrefixes;
    private List<String> tableSuffixes;
    private List<String> ignoreTableNames;
    private List<String> ignorePrefixes;
    private List<String> ignoreSuffixes;


}
