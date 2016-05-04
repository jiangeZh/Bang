/*
Navicat MySQL Data Transfer

Source Server         : auction
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : bang

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-05-04 13:50:35
*/

drop database if exists bang;

create database bang;

use bang;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for favorites_post
-- ----------------------------
DROP TABLE IF EXISTS `favorites_post`;
CREATE TABLE `favorites_post` (
  `user_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`post_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `favorites_post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `favorites_post_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorites_post
-- ----------------------------
INSERT INTO `favorites_post` VALUES ('1', '1');
INSERT INTO `favorites_post` VALUES ('2', '1');

-- ----------------------------
-- Table structure for favorites_res
-- ----------------------------
DROP TABLE IF EXISTS `favorites_res`;
CREATE TABLE `favorites_res` (
  `user_id` int(11) NOT NULL,
  `res_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`res_id`),
  KEY `resource_id` (`res_id`),
  CONSTRAINT `favorites_res_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `favorites_res_ibfk_2` FOREIGN KEY (`res_id`) REFERENCES `resource` (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorites_res
-- ----------------------------
INSERT INTO `favorites_res` VALUES ('2', '4');

-- ----------------------------
-- Table structure for kind
-- ----------------------------
DROP TABLE IF EXISTS `kind`;
CREATE TABLE `kind` (
  `kind_id` int(11) NOT NULL AUTO_INCREMENT,
  `kind_name` varchar(50) NOT NULL,
  `kind_desc` varchar(255) NOT NULL,
  PRIMARY KEY (`kind_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kind
-- ----------------------------
INSERT INTO `kind` VALUES ('1', '实习', '实习');
INSERT INTO `kind` VALUES ('2', '浩燊一个', '的');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `other_user_id` int(11) NOT NULL,
  `message` varchar(255) NOT NULL,
  PRIMARY KEY (`message_id`,`user_id`,`other_user_id`),
  KEY `user_id` (`user_id`),
  KEY `other_user_id` (`other_user_id`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`other_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_title` varchar(255) NOT NULL,
  `post_text` varchar(255) NOT NULL,
  `post_date` date NOT NULL,
  `thx_cnt` int(10) unsigned NOT NULL DEFAULT '0',
  `owner_id` int(11) NOT NULL,
  `kind_id` int(11) NOT NULL,
  `img_url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `owner_id` (`owner_id`),
  KEY `kind_id` (`kind_id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `post_ibfk_2` FOREIGN KEY (`kind_id`) REFERENCES `kind` (`kind_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '帅哥', '第三方', '2016-05-03', '3', '1', '1', 'd:\\Bang\\image\\b732beb9-d9be-41a5-b042-58284ee0719c_blue_info_win.png|d:\\Bang\\image\\057a536d-965a-4ba3-b6a1-466a8c94bdad_btn_attribute_christmas.png');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `res_id` int(11) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(255) NOT NULL,
  `res_desc` varchar(255) NOT NULL,
  `res_url` varchar(255) NOT NULL,
  `res_size` double NOT NULL,
  `upload_date` date NOT NULL,
  `download_cnt` int(11) NOT NULL DEFAULT '0',
  `is_encrypt` int(11) NOT NULL DEFAULT '0',
  `password` varchar(50) DEFAULT NULL,
  `owner_id` int(11) NOT NULL,
  `kind_id` int(11) NOT NULL,
  `teacher_name` varchar(50) DEFAULT NULL,
  `lesson_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`res_id`),
  KEY `owner_id` (`owner_id`),
  KEY `kind_id` (`kind_id`),
  CONSTRAINT `resource_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `resource_ibfk_2` FOREIGN KEY (`kind_id`) REFERENCES `kind` (`kind_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('4', 'btn_bt_background.png', '方式', 'd:\\Bang\\download\\16c9560b-5c1d-4901-827a-2fd6cb8f5376_btn_bt_background.png', '26504', '2016-05-03', '0', '0', '', '1', '1', null, null);
INSERT INTO `resource` VALUES ('5', 'btn_bt_select.png', '键哥', 'd:\\Bang\\download\\ec5165db-29fc-46f6-a0ab-61a6a84340bd_btn_bt_select.png', '1606', '2016-05-04', '0', '0', '', '2', '2', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `userpass` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `school_year` int(11) NOT NULL,
  `user_desc` varchar(50) NOT NULL,
  `role` int(11) DEFAULT NULL COMMENT '0代表师弟师妹，1代表师兄师姐',
  `concern_kind_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  KEY `concern_kind_id` (`concern_kind_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`concern_kind_id`) REFERENCES `kind` (`kind_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'mysql', 'mysql', '759878652@qq.com', '2013', '测试一号', null, null);
INSERT INTO `user` VALUES ('2', 'jiange', 'jiange', 'jiangezh@qq.com', '2013', '测试二号', null, null);
