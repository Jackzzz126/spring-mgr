package com.jack.mgr;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * CodeGenerater
 *
 * @author zhengzhe17
 * @date 2021/4/2
 */

@SpringBootTest
@Slf4j
public class CodeGenerator {
    @Test
    void codeGenerate() {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            ClassPathResource classPathResource = new ClassPathResource("config/mybatis-generator-config.xml");
            File configFile = classPathResource.getFile();
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            log.info("code generate failed: ", e);
        }
    }
}
