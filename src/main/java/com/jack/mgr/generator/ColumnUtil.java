package com.jack.mgr.generator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ColumnUtil
 *
 * @author zhengzhe17
 * @date 2021/4/7
 */
@Slf4j
public class ColumnUtil {

    private static final char SEPARATOR = '_';

    public static PropertiesConfiguration getConfig() {
        try {
            return new PropertiesConfiguration("config/column-map.properties");
        } catch (ConfigurationException e) {
            log.error("Error when read config", e);
        }
        return null;
    }

    public static String toJavaType(String type){
        Configuration config = getConfig();
        return config.getString(type, null);
    }

    /**
     * 把下划线分割的命名，转变为驼峰命名
     * @param s 要转换的string
     * @param capitalize 是否首字母大写
     * @return
     */
    public static String toCamelCase(String s, boolean capitalize) {
        if (s == null) {
            return null;
        }
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        char firstChar = str.charAt(0);
        if(capitalize) {
            sb.append(Character.toUpperCase(firstChar));
        } else {
            sb.append(firstChar);
        }
        boolean toUpperCase = false;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                toUpperCase = true;
            } else {
                if (toUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    toUpperCase = false;
                } else {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
