package com.jack.mgr.generator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Generator
 *
 * @author zhengzhe17
 * @date 2021/4/7
 */
@Slf4j
@Service
public class GeneratorService {
    private final JdbcTemplate jdbcTemplate;

    public GeneratorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void generate(String tableName, String packName, boolean restOnly) {
        List<ColumnInfo> columnInfos = this.getColumns(tableName);

    }

    private List<ColumnInfo> getColumns(String tableName) {
        List<ColumnInfo> columnInfos = new ArrayList<>();
        if(StringUtils.isEmpty(tableName)) {
            log.error("empty table name");
            return columnInfos;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("select column_name, is_nullable, data_type, column_comment, column_key, extra ")
                .append("from information_schema.columns where ")
                .append("table_name = '")
                .append(tableName)
                .append("' ")
                .append("and table_schema = (select database()) order by ordinal_position");
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sb.toString());

        for (Map<String, Object> map : mapList) {
            ColumnInfo columnInfo = new ColumnInfo();
            columnInfo.setName((String)map.get("column_name"));
            columnInfo.setNullable((String)map.get("is_nullable"));
            columnInfo.setType((String)map.get("data_type"));
            columnInfo.setComment((String)map.get("column_comment"));
            columnInfo.setKey((String)map.get("column_key"));
            columnInfo.setExtra((String)map.get("extra"));
            columnInfos.add(columnInfo);
        }

        return columnInfos;
    }
}
