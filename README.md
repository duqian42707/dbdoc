# dbdoc

本项目是一个在命令行执行的数据库文档生成工具，基于springboot2.x

核心组件：https://github.com/pingfangushi/screw

## 使用方法

### 1. 获取程序

- 方式一：下载jar包，[下载地址](https://github.com/duqian42707/dbdoc/releases/latest)
- 方式二：从源码编译，[源码地址](https://github.com/duqian42707/dbdoc)

    ```bash
    mvn clean package
    ```

### 2. 修改配置文件

- 方式一：使用vim直接编辑jar包中的`application.yml`文件
- 方式二：在jar包同级目录下新建`application.yml`文件 （推荐）

文件内容：

```yaml
spring:
  datasource:
    driver-class-name: oracle.jdbc.driver.OracleDriver
    url: jdbc:oracle:thin:@127.0.0.1:1521:PORTALDB
    username: info
    password: 111111

logging:
  level:
    root: info
    com.dqv5: debug

# 自定义导出配置
dbdoc:
  output-dir: ./output/
  file-type: HTML           # 文档格式：HTML | WORD | MD
  version: 1.0.0
  description: 数据库表结构文档
#  produce-type: freemarker  # 生成模板的实现 freemarker|velocity，默认freemarker
#  # 自定义文档模板的文件路径，模板需要和文件类型和使用模板的语法进行编写和处理，否则将会生成错误
#  custom-template: "D:\\Documents\\workspace_personal\\dbdoc\\templates\\documentation_word.ftl"
#  table-names: # 按表名，可配置多个，非必须
#    - BASE_DEPT
#    - LEAVE_APPLY
#  table-prefixes: # 按前缀，可配置多个，非必须
#    - APP_
#  table-suffixes: # 按后缀，可配置多个，非必须
#    - _USER
#  ignore-names: # 忽略表名，可配置多个，非必须
#    - CUSTOM_1
#  ignore-prefixes: # 忽略前缀，可配置多个，非必须
#    - TEST
#  ignore-suffixes: # 忽略后缀，可配置多个，非必须
#    - _BAK

```

### 3. 运行

```bash
java -jar dbdoc-1.0.3.jar
```

### 4. 备注

postgresql 指定数据库为mars、模式为info的写法url：

```txt
jdbc:postgresql://127.0.0.1:5432/mars?currentSchema=info
```
