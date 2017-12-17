CREATE DATABASE `rent` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `role` tinyint(3) unsigned NOT NULL COMMENT '角色（0：普通用户；1:管理员）',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='用户';

CREATE TABLE `category` (
  `category_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `name` varchar(32) NOT NULL COMMENT '类别名称',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='类别';

CREATE TABLE `stuff` (
  `stuff_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '物品编号',
  `category_id` int(10) unsigned NOT NULL COMMENT '类别编号',
  `name` varchar(32) NOT NULL COMMENT '物品名称',
  `deposit` int(10) unsigned NOT NULL COMMENT '押金(rmb)',
  `rental` int(10) unsigned NOT NULL COMMENT '租金（rmb/day）',
  `status` tinyint(3) unsigned NOT NULL COMMENT '物品状态（0:未租；1:申请租用；2:已租）',
  PRIMARY KEY (`stuff_id`),
  KEY `category_id_idx` (`category_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='物品';

CREATE TABLE `item` (
  `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '出租项编号',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户编号',
  `stuff_id` int(10) unsigned NOT NULL COMMENT '物品编号',
  `create_time` datetime NOT NULL COMMENT '租用日期',
  `rent_day` int(10) unsigned NOT NULL COMMENT '租用天数',
  `end_time` datetime DEFAULT NULL COMMENT '归还日期',
  PRIMARY KEY (`item_id`),
  KEY `fk_user_id_idx` (`user_id`),
  KEY `fk_stuff_id_idx` (`stuff_id`),
  CONSTRAINT `fk_stuff_id` FOREIGN KEY (`stuff_id`) REFERENCES `stuff` (`stuff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='出租项';
