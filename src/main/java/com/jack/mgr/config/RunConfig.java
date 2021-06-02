package com.jack.mgr.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

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
            String osName = System.getProperties().getProperty("os.name");;

            if(osName != null) {
                String cmdStr = "cmd /c start http://localhost:8080";//windows as default
                if(osName.indexOf("Mac") > -1) {
                    cmdStr = "open http://localhost:8080";
                }

                Runtime runtime = Runtime.getRuntime();
                runtime.exec(cmdStr);
            } else {
                log.warn("can't get os name");
            }
        } catch (Exception e) {
            log.error("start browser exception: ", e);
        }
    }
}
