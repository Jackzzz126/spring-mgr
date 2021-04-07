package com.jack.mgr.generator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ColumnInfo
 *
 * @author zhengzhe17
 * @date 2021/4/7
 */
@Data
public class ColumnInfo {
    /** 数据库字段名称 **/
    private String name;

    /** 允许空值 **/
    private String nullable;

    /** 数据库字段类型 **/
    private String type;

    /** 数据库字段注释 **/
    private String comment;

    /** 数据库字段键类型 **/
    private String key;

    /** 额外的参数 **/
    private String extra;
}
