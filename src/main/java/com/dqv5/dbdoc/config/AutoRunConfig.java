package com.dqv5.dbdoc.config;

import com.dqv5.dbdoc.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author duqian
 * @date 2021/6/2
 */
@Component
@Slf4j
public class AutoRunConfig implements ApplicationRunner {
    @Resource
    private MainService mainService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开始执行....");
        mainService.exportToFile();
        log.info("执行结束....");
    }
}
