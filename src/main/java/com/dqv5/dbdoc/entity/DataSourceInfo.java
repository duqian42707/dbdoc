package com.dqv5.dbdoc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author duqian
 * @date 2020/7/22
 */
@Entity
@Table
@Data
public class DataSourceInfo {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String type;
    private String host;
    private Integer port;
    private String instanceName;
    private String username;
    private String password;
    private Integer orderNo;
    private String remark;
}
