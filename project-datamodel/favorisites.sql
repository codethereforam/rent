CREATE DATABASE  IF NOT EXISTS `rent` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rent`;
-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: rent
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `name` varchar(32) NOT NULL COMMENT '类别名称',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COMMENT='类别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`category_id`, `name`) VALUES (1,'camera');
INSERT INTO `category` (`category_id`, `name`) VALUES (2,'clothes');
INSERT INTO `category` (`category_id`, `name`) VALUES (41,'ccc');
INSERT INTO `category` (`category_id`, `name`) VALUES (45,'aaa');
INSERT INTO `category` (`category_id`, `name`) VALUES (46,'eee');
INSERT INTO `category` (`category_id`, `name`) VALUES (49,'ddd');
INSERT INTO `category` (`category_id`, `name`) VALUES (51,'相机');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '出租项编号',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户编号',
  `stuff_id` int(10) unsigned NOT NULL COMMENT '物品编号',
  `create_time` datetime DEFAULT NULL COMMENT '租用日期',
  `rent_day` int(10) unsigned NOT NULL COMMENT '租用天数',
  `end_time` datetime DEFAULT NULL COMMENT '归还日期',
  `apply_time` datetime NOT NULL COMMENT '申请时间',
  `status` tinyint(3) unsigned NOT NULL COMMENT '状态（0：申请中；1：不通过；2：租用中；3： 已归还）',
  PRIMARY KEY (`item_id`),
  KEY `fk_user_id_idx` (`user_id`),
  KEY `fk_stuff_id_idx` (`stuff_id`),
  CONSTRAINT `fk_stuff_id` FOREIGN KEY (`stuff_id`) REFERENCES `stuff` (`stuff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='出租项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`item_id`, `user_id`, `stuff_id`, `create_time`, `rent_day`, `end_time`, `apply_time`, `status`) VALUES (5,1,11,NULL,22,NULL,'2017-12-19 12:52:38',1);
INSERT INTO `item` (`item_id`, `user_id`, `stuff_id`, `create_time`, `rent_day`, `end_time`, `apply_time`, `status`) VALUES (6,2,4,'2017-12-19 13:37:15',21,'2017-12-19 13:37:51','2017-12-19 13:34:07',3);
INSERT INTO `item` (`item_id`, `user_id`, `stuff_id`, `create_time`, `rent_day`, `end_time`, `apply_time`, `status`) VALUES (8,1,9,'2017-12-19 13:39:23',3,'2017-12-19 13:40:07','2017-12-19 13:34:54',3);
INSERT INTO `item` (`item_id`, `user_id`, `stuff_id`, `create_time`, `rent_day`, `end_time`, `apply_time`, `status`) VALUES (9,2,11,'2017-12-19 13:49:56',8,'2017-12-19 13:50:17','2017-12-19 13:48:11',3);
INSERT INTO `item` (`item_id`, `user_id`, `stuff_id`, `create_time`, `rent_day`, `end_time`, `apply_time`, `status`) VALUES (14,1,12,'2017-12-19 20:19:02',12,NULL,'2017-12-19 20:13:50',2);
INSERT INTO `item` (`item_id`, `user_id`, `stuff_id`, `create_time`, `rent_day`, `end_time`, `apply_time`, `status`) VALUES (15,1,10,NULL,21,NULL,'2017-12-19 20:14:07',0);
INSERT INTO `item` (`item_id`, `user_id`, `stuff_id`, `create_time`, `rent_day`, `end_time`, `apply_time`, `status`) VALUES (16,2,9,'2017-12-19 20:16:32',2,'2017-12-19 20:17:46','2017-12-19 20:15:32',3);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stuff`
--

DROP TABLE IF EXISTS `stuff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='物品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stuff`
--

LOCK TABLES `stuff` WRITE;
/*!40000 ALTER TABLE `stuff` DISABLE KEYS */;
INSERT INTO `stuff` (`stuff_id`, `category_id`, `name`, `deposit`, `rental`, `status`) VALUES (1,1,'canon001',1000,100,0);
INSERT INTO `stuff` (`stuff_id`, `category_id`, `name`, `deposit`, `rental`, `status`) VALUES (2,1,'nikon01a',2000,200,0);
INSERT INTO `stuff` (`stuff_id`, `category_id`, `name`, `deposit`, `rental`, `status`) VALUES (3,2,'suit021',222,33,0);
INSERT INTO `stuff` (`stuff_id`, `category_id`, `name`, `deposit`, `rental`, `status`) VALUES (4,2,'suit321',1111,111,0);
INSERT INTO `stuff` (`stuff_id`, `category_id`, `name`, `deposit`, `rental`, `status`) VALUES (8,45,'aaa321',333,321,0);
INSERT INTO `stuff` (`stuff_id`, `category_id`, `name`, `deposit`, `rental`, `status`) VALUES (9,46,'bbb321',5555,55,0);
INSERT INTO `stuff` (`stuff_id`, `category_id`, `name`, `deposit`, `rental`, `status`) VALUES (10,1,'canon002',10000,1000,1);
INSERT INTO `stuff` (`stuff_id`, `category_id`, `name`, `deposit`, `rental`, `status`) VALUES (11,1,'canon',8888,88,0);
INSERT INTO `stuff` (`stuff_id`, `category_id`, `name`, `deposit`, `rental`, `status`) VALUES (12,2,'skirt001',1111,11,2);
/*!40000 ALTER TABLE `stuff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `role` tinyint(3) unsigned NOT NULL COMMENT '角色（0：普通用户；1:管理员）',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `username`, `password`, `role`) VALUES (1,'u1','p1',0);
INSERT INTO `user` (`user_id`, `username`, `password`, `role`) VALUES (2,'u2','p2',0);
INSERT INTO `user` (`user_id`, `username`, `password`, `role`) VALUES (3,'admin','admin',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-19 21:20:30
