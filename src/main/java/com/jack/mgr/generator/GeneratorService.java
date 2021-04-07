package com.jack.mgr.generator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Generator
 *
 * @author zhengzhe17
 * @date 2021/4/7
 */
@Slf4j
@Service
public class GeneratorService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ColumnInfo> getColumns(String tableName) {
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
        Query query = this.entityManager.createNativeQuery(sb.toString());
        List result = query.getResultList();
        for (Object o : result) {
            Object[] objArr = (Object[])o;
            columnInfos.add(new ColumnInfo(objArr[0],objArr[1],objArr[2],objArr[3],objArr[4],objArr[5]));
        }
        return columnInfos;
    }
}
