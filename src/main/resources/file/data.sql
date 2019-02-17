# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.18)
# Database: hw
# Generation Time: 2019-02-17 08:33:34 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP database if EXISTS `hw`;

CREATE database hw;

USE hw;

# Dump of table t_comment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(90) DEFAULT '',
  `goods_id` varchar(90) NOT NULL DEFAULT '',
  `comment` varchar(800) NOT NULL DEFAULT '',
  `c_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;

INSERT INTO `t_comment` (`id`, `user_id`, `user_name`, `goods_id`, `comment`, `c_date`)
VALUES
	(1,2,'Steven','1a11931f-232d-4611-802c-7ccbc1ba2d5e','fantastic','2019-02-17 15:23:29'),
	(2,2,'Steven','1a11931f-232d-4611-802c-7ccbc1ba2d5e','this is a very good book','2019-02-17 15:23:18'),
	(3,2,'Steven','1a11931f-232d-4611-802c-7ccbc1ba2d5e','Wonderful book','2019-02-17 15:23:13'),
	(4,2,NULL,'1a2a34ec-d44b-41c1-94bb-16100449c80c','i love it','2019-02-17 15:23:06'),
	(5,2,'Steven','1a2a34ec-d44b-41c1-94bb-16100449c80c',' like it so much','2019-02-17 15:22:57');

/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_goods_pic
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_goods_pic`;

CREATE TABLE `t_goods_pic` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(80) NOT NULL DEFAULT '',
  `pic_url` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

LOCK TABLES `t_goods_pic` WRITE;
/*!40000 ALTER TABLE `t_goods_pic` DISABLE KEYS */;

INSERT INTO `t_goods_pic` (`id`, `goods_id`, `pic_url`)
VALUES
	(1,'1','/welflejffsdfsd'),
	(2,'1','/sfsjakjjsfs_sdf'),
	(3,'2','/sdfsajf'),
	(4,'1a2a34ec-d44b-41c1-94bb-16100449c80c','/sdfjsldjflsdfjl/sdfsd/fsdf/sdf'),
	(5,'1a11931f-232d-4611-802c-7ccbc1ba2d5e','/sdfjsldjflsdfjl/sdfsd/fsdf/sdf'),
	(6,'1a11931f-232d-4611-802c-7ccbc1ba2d5e','/welcome/app/f');

/*!40000 ALTER TABLE `t_goods_pic` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_goods
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_goods`;

CREATE TABLE `t_goods` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(80) NOT NULL DEFAULT '',
  `name` varchar(56) NOT NULL DEFAULT '',
  `type` int(11) NOT NULL,
  `rentalCost` float(11,2) NOT NULL,
  `deposit` float(11,2) DEFAULT NULL,
  `desc` varchar(500) DEFAULT NULL,
  `addr` varchar(500) DEFAULT NULL,
  `owner` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

LOCK TABLES `t_goods` WRITE;
/*!40000 ALTER TABLE `t_goods` DISABLE KEYS */;

INSERT INTO `t_goods` (`id`, `goods_id`, `name`, `type`, `rentalCost`, `deposit`, `desc`, `addr`, `owner`)
VALUES
	(1,'2342','book',1,10.50,200.50,'noval of Wandering Earth by Liu Cixin','红磡体育馆。',1),
	(2,'1314','game',2,4.00,100.00,'三体游戏，精彩纷呈。',NULL,1),
	(11,'1a2a34ec-d44b-41c1-94bb-16100449c80c','book name',1,5.33,3.44,'this is a boook','addrsdfs',1),
	(13,'1a11931f-232d-4611-802c-7ccbc1ba2d5e','book name2',1,5.33,3.44,'this is a boook','addrsdfs',1);

/*!40000 ALTER TABLE `t_goods` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_goods_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_goods_type`;

CREATE TABLE `t_goods_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

LOCK TABLES `t_goods_type` WRITE;
/*!40000 ALTER TABLE `t_goods_type` DISABLE KEYS */;

INSERT INTO `t_goods_type` (`id`, `name`)
VALUES
	(1,'Camera'),
	(2,'Game'),
	(3,'Outdoor Item'),
	(4,'Wedding'),
	(5,'Sports Itetm'),
	(6,'Clothes'),
	(7,'Musical'),
	(8,'Instrument'),
	(9,'Books'),
	(10,'Child and Baby Items'),
	(11,'Others');

/*!40000 ALTER TABLE `t_goods_type` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_like
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_like`;

CREATE TABLE `t_like` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `goods_id` varchar(90) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

LOCK TABLES `t_like` WRITE;
/*!40000 ALTER TABLE `t_like` DISABLE KEYS */;

INSERT INTO `t_like` (`id`, `user_id`, `goods_id`)
VALUES
	(1,1,'1a11931f-232d-4611-802c-7ccbc1ba2d5e'),
	(2,2,'1a11931f-232d-4611-802c-7ccbc1ba2d5e'),
	(4,2,'1a11931f-232d-4611-802c-7ccbc1ba2d5e');

/*!40000 ALTER TABLE `t_like` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` varchar(90) NOT NULL DEFAULT '',
  `user_id` int(11) NOT NULL,
  `goods_id` varchar(90) NOT NULL DEFAULT '',
  `rent_start_day` date NOT NULL,
  `rent_end_day` date NOT NULL,
  `daily_fee` float(11,2) NOT NULL,
  `service_fee` float(11,2) DEFAULT '0.00',
  `total_fee` float(11,2) NOT NULL,
  `pay_type` int(11) NOT NULL,
  `pay_status` int(11) NOT NULL DEFAULT '0' COMMENT '0: unpay; 1:paying; 99: paied',
  `audit_status` int(11) NOT NULL DEFAULT '0' COMMENT '0:unaudit; 99: audited',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `birth` varchar(45) DEFAULT NULL,
  `notify` char(1) DEFAULT 'N',
  `pwd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;

INSERT INTO `t_user` (`id`, `type`, `phone`, `email`, `gender`, `first_name`, `last_name`, `birth`, `notify`, `pwd`)
VALUES
	(1,'email','12345678','test@test.com','M','Bill','Gates','1965-2-2','Y','qwe'),
	(2,'phone','123456','jia@qq.com','F','Steven','Jobs','1998-4-12','N','qweasd');

/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
