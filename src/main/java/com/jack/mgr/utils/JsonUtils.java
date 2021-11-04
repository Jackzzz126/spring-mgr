package com.jack.mgr.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * JsonUtils
 *
 * @author zhengzhe17
 * @date 2021/11/4
 */
@Slf4j
public class JsonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Json序列化异常: ", e);
            return null;
        } catch (IOException e) {
            log.error("Json序列化异常: ", e);
            return null;
        }
    }

    public static <T> T fronJson(String jsonStr, Class<T> objClass) {
        try {
            return mapper.readValue(jsonStr, objClass);
        } catch (IOException e) {
            log.error("Json解析异常: ", e);
            return null;
        }
    }
}
