/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50150
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50150
File Encoding         : 65001

Date: 2018-06-25 14:01:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` varchar(200) NOT NULL,
  `image` varchar(200) DEFAULT NULL,
  `category` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '语文', '20', '/image/book1.jpg', 'wx');
INSERT INTO `book` VALUES ('2', '天龙八部', '30', '/image/book2.jpg', 'xy');
INSERT INTO `book` VALUES ('3', '金瓶梅', '65', '/image/book3.jpg', 'wx');
INSERT INTO `book` VALUES ('9', '藏地密码', '98', '/image/book5.jpg', 'xy');
INSERT INTO `book` VALUES ('8', '花千骨', '68', '/image/book4.jpg', 'yq');
INSERT INTO `book` VALUES ('10', '锦绣未央', '180', '/image/book6.jpg', 'yq');
