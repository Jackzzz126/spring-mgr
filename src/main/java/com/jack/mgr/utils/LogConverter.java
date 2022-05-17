package com.jack.mgr.utils;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

/**
 * LogConverter
 *
 * @author zhengzhe17
 * @date 2022/5/17
 */
@Slf4j
public class LogConverter extends MessageConverter {
    // 替换手机号中间4位为****
    public static final String regex = "(\\D1\\d{2})(\\d{4})(\\d{4}\\D)";
    public static final String replacement = "$1****$3";
    public static Pattern pattern = null;
    static {
        pattern = Pattern.compile(regex);
    }

    @Override
    public String convert(ILoggingEvent event) {
        String msgStr = event.getFormattedMessage();
        String result = pattern.matcher(msgStr).replaceAll(replacement);
        return result;
    }

    public static void main(String[] args) {
        String str1 = pattern.matcher("aa12233334444bb").replaceAll(replacement);
        log.info(str1);
        String str2 = pattern.matcher("aa122333344445").replaceAll(replacement);
        log.info(str2);
        String str3 = pattern.matcher("512233334444aaa").replaceAll(replacement);
        log.info(str3);
        String str4 = pattern.matcher("test_log_start_18513127801_test_log_end").replaceAll(replacement);
        log.info(str4);
    }
}
