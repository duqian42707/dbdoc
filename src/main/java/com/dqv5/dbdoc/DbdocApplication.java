package com.dqv5.dbdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author duq
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DbdocApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbdocApplication.class, args);
    }

}
