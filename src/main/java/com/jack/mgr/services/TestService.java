package com.jack.mgr.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

/**
 * TestService
 *
 * @author zhengzhe17
 * @date 2023/5/18
 */
@Service
@Slf4j
public class TestService {
    @PreDestroy
    public void test() {
        log.info("pre destory called");
    }
}
