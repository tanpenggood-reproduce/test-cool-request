-- ---------------------------------------------
-- 用户表
-- ---------------------------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint NOT NULL,
  `username` varchar(255) DEFAULT NULL COMMENT '姓名',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(1) DEFAULT 0 COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
-- ---------------------------------------------
-- 角色表
-- ---------------------------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `code` varchar(255) DEFAULT NULL COMMENT '角色编码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(1) DEFAULT 0 COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';