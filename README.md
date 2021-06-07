# dbdoc

本项目是一个在命令行执行的数据库文档生成工具，基于springboot2.5.0

核心组件：https://github.com/pingfangushi/screw


## 修改配置文件

```yaml
spring:
  datasource:
    driver-class-name: oracle.jdbc.driver.OracleDriver
    username: info
    password: 111111
    url: jdbc:oracle:thin:@127.0.0.1:1521:PORTALDB

logging:
  level:
    root: info
    com.dqv5: debug

# 自定义导出配置
dbdoc:
  output-dir: /Users/duqian/Desktop/temp/
  file-type: HTML    # 文档格式：HTML | WORD | MD
  version: 1.0.0
  description: 数据库表结构文档
  table-names: # 按表名，可配置多个，非必须
    - BASE_DEPT
    - LEAVE_APPLY
  table-prefixes: # 按前缀，可配置多个，非必须
    - APP_
  table-suffixes: # 按后缀，可配置多个，非必须
    - _USER
  ignore-names: # 忽略表名，可配置多个，非必须
    - CUSTOM_1
  ignore-prefixes: # 忽略前缀，可配置多个，非必须
    - TEST
  ignore-suffixes: # 忽略后缀，可配置多个，非必须
    - _BAK
```

## build

```bash
mvn clean package
```


## run

```bash
java -jar dbdoc-1.0.0.jar
```

