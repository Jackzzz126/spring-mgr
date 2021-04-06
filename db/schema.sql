DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creater` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `modify_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `modifier` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '修改人',
  `delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `name` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '名字',
  `age` int(11) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
