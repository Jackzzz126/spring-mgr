package com.jack.mgr.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * ColumnUtil
 *
 * @author zhengzhe17
 * @date 2021/4/7
 */
@Slf4j
public class ColumnUtil {

    private static final char serparator = '_';

    public static PropertiesConfiguration getConfig() {
        try {
            return new PropertiesConfiguration("config/column-map.properties");
        } catch (ConfigurationException e) {
            log.error("Error when read config", e);
        }
        return null;
    }
}
