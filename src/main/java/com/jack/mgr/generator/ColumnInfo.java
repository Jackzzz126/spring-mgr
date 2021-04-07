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
@AllArgsConstructor
public class ColumnInfo {
    /** 数据库字段名称 **/
    private Object name;

    /** 允许空值 **/
    private Object nullable;

    /** 数据库字段类型 **/
    private Object type;

    /** 数据库字段注释 **/
    private Object comment;

    /** 数据库字段键类型 **/
    private Object key;

    /** 额外的参数 **/
    private Object extra;
}
