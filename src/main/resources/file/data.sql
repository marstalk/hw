/*
Navicat MySQL Data Transfer

Source Server         : beidou-ali-shenzhen
Source Server Version : 50722
Source Host           : 47.107.166.120:3306
Source Database       : hw

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-02-23 12:56:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `user_name` varchar(90) DEFAULT '' COMMENT '用户名字',
  `goods_id` varchar(90) NOT NULL DEFAULT '' COMMENT '商品ID',
  `comment` varchar(800) NOT NULL DEFAULT '' COMMENT '评论详情',
  `c_date` datetime NOT NULL COMMENT '评论日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '2', 'Steven', '1a11931f-232d-4611-802c-7ccbc1ba2d5e', 'fantastic', '2019-02-17 15:23:29');
INSERT INTO `t_comment` VALUES ('2', '2', 'Steven', '1a11931f-232d-4611-802c-7ccbc1ba2d5e', 'this is a very good book', '2019-02-17 15:23:18');
INSERT INTO `t_comment` VALUES ('3', '2', 'Steven', '1a11931f-232d-4611-802c-7ccbc1ba2d5e', 'Wonderful book', '2019-02-17 15:23:13');
INSERT INTO `t_comment` VALUES ('4', '2', null, '1a2a34ec-d44b-41c1-94bb-16100449c80c', 'i love it', '2019-02-17 15:23:06');
INSERT INTO `t_comment` VALUES ('5', '2', 'Steven', '1a2a34ec-d44b-41c1-94bb-16100449c80c', ' like it so much', '2019-02-17 15:22:57');
INSERT INTO `t_comment` VALUES ('6', '2', 'Steven', '6fbd4167-5f36-4baa-9e84-6cd89dcfad41', '我是第一个评论的没？', '2019-02-22 20:27:36');
INSERT INTO `t_comment` VALUES ('7', '2', 'Steven', '6fbd4167-5f36-4baa-9e84-6cd89dcfad41', '第二个评论？？？', '2019-02-22 20:10:52');
INSERT INTO `t_comment` VALUES ('8', '2', 'Steven', '6fbd4167-5f36-4baa-9e84-6cd89dcfad41', '一步一拳功夫意念要专心', '2019-02-22 20:10:43');
INSERT INTO `t_comment` VALUES ('9', '2', 'Steven', '6fbd4167-5f36-4baa-9e84-6cd89dcfad41', '哈哈哈', '2019-02-22 20:10:47');
INSERT INTO `t_comment` VALUES ('10', '2', 'Steven', '6fbd4167-5f36-4baa-9e84-6cd89dcfad41', '很好的东西', '2019-02-22 11:36:42');
INSERT INTO `t_comment` VALUES ('11', '2', 'Steven', '6fbd4167-5f36-4baa-9e84-6cd89dcfad41', '很好的东西，很想买', '2019-02-22 12:05:28');
INSERT INTO `t_comment` VALUES ('12', '2', 'Steven', 'e3a1992e-ed60-4014-b4a6-bd34bcc9ad44', '天龙八部', '2019-02-22 14:23:43');
INSERT INTO `t_comment` VALUES ('13', '2', 'Steven', 'e3a1992e-ed60-4014-b4a6-bd34bcc9ad44', '神雕侠侣', '2019-02-22 14:25:06');
INSERT INTO `t_comment` VALUES ('14', '2', 'Steven', 'e3a1992e-ed60-4014-b4a6-bd34bcc9ad44', '', '2019-02-22 14:25:41');

-- ----------------------------
-- Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `goods_id` varchar(80) NOT NULL DEFAULT '' COMMENT '商品ID',
  `name` varchar(56) NOT NULL DEFAULT '' COMMENT '商品名称',
  `type_name` varchar(90) DEFAULT NULL COMMENT '商品类型',
  `type` int(11) NOT NULL COMMENT '商品类型ID',
  `rentalCost` float(11,2) NOT NULL COMMENT '单日租金',
  `deposit` float(11,2) DEFAULT NULL COMMENT '商品押金',
  `desc` varchar(500) DEFAULT NULL COMMENT '描述',
  `addr` varchar(500) DEFAULT NULL COMMENT '交易地址',
  `owner` int(11) NOT NULL COMMENT '商品所有者ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('18', '2aa9c09f-9fb0-466e-95f0-1593ff5f4235', 'devilzds', 'Camera', '1', '3.00', '123.00', 'heheh', 'hhahah', '2');
INSERT INTO `t_goods` VALUES ('19', '0cc87802-f95d-4e17-b32b-bdecb9d926c7', 'zds', 'Wedding', '4', '10000.00', '100001.00', 'i love xiamen', 'xiamen', '2');
INSERT INTO `t_goods` VALUES ('20', '95196f88-eca0-45d3-ae7b-28ebf8e8143d', 'libai', 'Game', '2', '88.00', '88.00', '王者大陆召唤师峡谷', '王者李白', '2');
INSERT INTO `t_goods` VALUES ('21', 'f6b0ce3d-0621-48a4-a77d-02030a1eddb4', 'shenmengxi', 'Game', '2', '168.00', '168.00', '王者大陆召唤师峡谷', '王者沈梦溪', '2');
INSERT INTO `t_goods` VALUES ('22', 'ea0a5da9-c7ba-4354-a6a1-d4ae55fd6fdb', '火箭浣熊', 'Game', '2', '1000.00', '1000.00', '银河护卫队-火箭浣熊', '银河护卫队', '2');
INSERT INTO `t_goods` VALUES ('23', 'ba0af688-2ecc-46fc-a03e-f6040d6ba6fa', '杰克-斯帕罗', 'Game', '2', '2000.00', '2000.00', '加勒比海盗-杰克-斯帕罗', '加勒比海盗', '2');
INSERT INTO `t_goods` VALUES ('24', 'e3a1992e-ed60-4014-b4a6-bd34bcc9ad44', '彼得-帕克', 'Game', '2', '2000.00', '2000.00', '复仇者联盟-蜘蛛侠', '漫威复仇者大厦', '2');
INSERT INTO `t_goods` VALUES ('25', '6fbd4167-5f36-4baa-9e84-6cd89dcfad41', '蜘蛛侠', 'Game', '2', '888.00', '888.00', '漫威-蜘蛛侠', '漫威世界', '2');

-- ----------------------------
-- Table structure for `t_goods_pic`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_pic`;
CREATE TABLE `t_goods_pic` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `goods_id` varchar(80) NOT NULL DEFAULT '' COMMENT '商品ID',
  `pic_url` varchar(100) NOT NULL DEFAULT '' COMMENT '图片相对路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods_pic
-- ----------------------------
INSERT INTO `t_goods_pic` VALUES ('1', '1', '/welflejffsdfsd');
INSERT INTO `t_goods_pic` VALUES ('2', '1', '/sfsjakjjsfs_sdf');
INSERT INTO `t_goods_pic` VALUES ('3', '2', '/sdfsajf');
INSERT INTO `t_goods_pic` VALUES ('4', '1a2a34ec-d44b-41c1-94bb-16100449c80c', '/sdfjsldjflsdfjl/sdfsd/fsdf/sdf');
INSERT INTO `t_goods_pic` VALUES ('5', '1a11931f-232d-4611-802c-7ccbc1ba2d5e', '/sdfjsldjflsdfjl/sdfsd/fsdf/sdf');
INSERT INTO `t_goods_pic` VALUES ('6', '1a11931f-232d-4611-802c-7ccbc1ba2d5e', '/welcome/app/f');
INSERT INTO `t_goods_pic` VALUES ('7', '5b427606-eade-4217-bbe5-d99e68ac8e54', 'string');
INSERT INTO `t_goods_pic` VALUES ('8', '4055c17e-03ff-4fac-8f2a-4f37d745e5df', 'string');
INSERT INTO `t_goods_pic` VALUES ('9', '0cdd4172-812b-4038-9035-07d593529a4f', '111');
INSERT INTO `t_goods_pic` VALUES ('10', '98d23f5f-cc2f-4582-b3c4-2f67f62c4ea8', '111');
INSERT INTO `t_goods_pic` VALUES ('11', '2aa9c09f-9fb0-466e-95f0-1593ff5f4235', '111');
INSERT INTO `t_goods_pic` VALUES ('12', '0cc87802-f95d-4e17-b32b-bdecb9d926c7', '9221f5db-1e41-45ec-a54c-1ab2bc68fb0d');
INSERT INTO `t_goods_pic` VALUES ('13', '0cc87802-f95d-4e17-b32b-bdecb9d926c7', '3d548501-2615-4691-b7e8-77f63a02e22c');
INSERT INTO `t_goods_pic` VALUES ('14', '0cc87802-f95d-4e17-b32b-bdecb9d926c7', '3da060bf-0c70-4aa0-8bc6-9abd2d2be790');
INSERT INTO `t_goods_pic` VALUES ('15', '0cc87802-f95d-4e17-b32b-bdecb9d926c7', 'b67509a2-9d25-4632-ad42-fe915ce9f188');
INSERT INTO `t_goods_pic` VALUES ('16', '0cc87802-f95d-4e17-b32b-bdecb9d926c7', 'f01120c5-75ad-4bb5-ac50-3fe063b60e27');
INSERT INTO `t_goods_pic` VALUES ('17', '95196f88-eca0-45d3-ae7b-28ebf8e8143d', '6334f117-57e3-4f04-b7f6-9db82697f3ce');
INSERT INTO `t_goods_pic` VALUES ('18', 'f6b0ce3d-0621-48a4-a77d-02030a1eddb4', 'd5742091-ef19-4e40-afac-7faede37f5b6');
INSERT INTO `t_goods_pic` VALUES ('19', 'ea0a5da9-c7ba-4354-a6a1-d4ae55fd6fdb', '0b36265c-8338-4dda-b3a9-151a24e7602e');
INSERT INTO `t_goods_pic` VALUES ('20', 'ba0af688-2ecc-46fc-a03e-f6040d6ba6fa', '5c139935-0c33-484c-9f9b-7559ab1a835f');
INSERT INTO `t_goods_pic` VALUES ('21', 'e3a1992e-ed60-4014-b4a6-bd34bcc9ad44', '23a4fa75-0392-4958-b299-2475b70887ce');
INSERT INTO `t_goods_pic` VALUES ('22', '6fbd4167-5f36-4baa-9e84-6cd89dcfad41', '294bebb0-cfd8-4c41-b151-c4a1062b7a28');
INSERT INTO `t_goods_pic` VALUES ('23', '6fbd4167-5f36-4baa-9e84-6cd89dcfad41', '5854c637-198d-4909-844c-fa4b8e33c586');
INSERT INTO `t_goods_pic` VALUES ('24', '6fbd4167-5f36-4baa-9e84-6cd89dcfad41', 'b58b93ae-0e63-4c66-bbb4-0f050b83c395');

-- ----------------------------
-- Table structure for `t_goods_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_type`;
CREATE TABLE `t_goods_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品类型ID',
  `name` varchar(30) NOT NULL DEFAULT '' COMMENT '商品类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods_type
-- ----------------------------
INSERT INTO `t_goods_type` VALUES ('1', 'Camera');
INSERT INTO `t_goods_type` VALUES ('2', 'Game');
INSERT INTO `t_goods_type` VALUES ('3', 'Outdoor Item');
INSERT INTO `t_goods_type` VALUES ('4', 'Wedding');
INSERT INTO `t_goods_type` VALUES ('5', 'Sports Itetm');
INSERT INTO `t_goods_type` VALUES ('6', 'Clothes');
INSERT INTO `t_goods_type` VALUES ('7', 'Musical');
INSERT INTO `t_goods_type` VALUES ('8', 'Instrument');
INSERT INTO `t_goods_type` VALUES ('9', 'Books');
INSERT INTO `t_goods_type` VALUES ('10', 'Child and Baby Items');
INSERT INTO `t_goods_type` VALUES ('11', 'Others');

-- ----------------------------
-- Table structure for `t_like`
-- ----------------------------
DROP TABLE IF EXISTS `t_like`;
CREATE TABLE `t_like` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `goods_id` varchar(90) NOT NULL DEFAULT '' COMMENT '商品ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_like
-- ----------------------------
INSERT INTO `t_like` VALUES ('1', '1', '1a11931f-232d-4611-802c-7ccbc1ba2d5e');
INSERT INTO `t_like` VALUES ('2', '2', '1a11931f-232d-4611-802c-7ccbc1ba2d5e');
INSERT INTO `t_like` VALUES ('4', '2', '1a11931f-232d-4611-802c-7ccbc1ba2d5e');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `order_id` varchar(90) NOT NULL DEFAULT '' COMMENT '订单ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `goods_id` varchar(90) NOT NULL DEFAULT '' COMMENT '商品ID',
  `rent_start_day` date NOT NULL COMMENT '租赁开始日期',
  `rent_end_day` date NOT NULL COMMENT '租赁结束日期',
  `daily_fee` float(11,2) NOT NULL COMMENT '商品日租金',
  `service_fee` float(11,2) DEFAULT '0.00' COMMENT '服务费',
  `total_fee` float(11,2) NOT NULL COMMENT '总费用',
  `pay_type` int(11) NOT NULL COMMENT '支付类型',
  `pay_status` int(11) NOT NULL DEFAULT '0' COMMENT '支付状态0: unpay; 1:paying; 99: paied',
  `audit_status` int(11) NOT NULL DEFAULT '0' COMMENT '审核状态：0:unaudit; 99: audited',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_end_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_end_user`;
CREATE TABLE `t_end_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `type` varchar(45) DEFAULT NULL COMMENT '用户注册类型',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `gender` char(1) DEFAULT NULL COMMENT '性别：M男；F女',
  `first_name` varchar(45) DEFAULT NULL COMMENT '姓氏',
  `last_name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birth` varchar(45) DEFAULT NULL COMMENT '生日',
  `notify` char(1) DEFAULT 'N' COMMENT '是否接收通知',
  `pwd` varchar(45) DEFAULT NULL COMMENT '登陆密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_end_user
-- ----------------------------
INSERT INTO `t_end_user` VALUES ('1', 'email', '12345678', 'test@test.com', 'M', 'Bill', 'Gates', '1965-2-2', 'Y', 'qwe');
INSERT INTO `t_end_user` VALUES ('2', 'phone', '123456', 'jia@qq.com', 'F', 'Steven', 'Jobs', '1998-4-12', 'N', 'qweasd');
INSERT INTO `t_end_user` VALUES ('3', 'email', null, 'zds@qq.com', null, 'zhong', 'dongsheng', '1989-9-10', 'N', 'pwd');
