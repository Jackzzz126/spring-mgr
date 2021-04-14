package com.jack.mgr.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * RunConfig
 *
 * @author zhengzhe17
 * @date 2021/4/14
 */
@Configuration
@Slf4j
public class RunConfig implements CommandLineRunner {
    @Override
    public void run(String... args) {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("cmd /c start http://localhost:8080");
        } catch (Exception e) {
            log.error("start browser exception: ", e);

        }

    }
}
