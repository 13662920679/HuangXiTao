/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50150
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50150
File Encoding         : 65001

Date: 2018-06-25 14:01:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', 'hxt', '16668777@qq.com', '123456', '14899948998');
INSERT INTO `user` VALUES ('3', 'hj', 'h', 'h', 'h');
INSERT INTO `user` VALUES ('5', 'qhy', '8848', '666', '333');
INSERT INTO `user` VALUES ('6', 'é»?é?¡æ»?', '13662920679@163.com', '980715', '13662920679');
INSERT INTO `user` VALUES ('7', 'HHH', '123456789@163.com', '123456', '123456789');
INSERT INTO `user` VALUES ('8', 'uy', 'yg', 'y', 'y');
INSERT INTO `user` VALUES ('9', 'YY', 'yg', 'y', 'Y');
INSERT INTO `user` VALUES ('10', 'QWFD', 'ASD', 'WD', 'QWD');
INSERT INTO `user` VALUES ('11', 'GFGFGFDG', 'FGFGF', 'GDFGD', 'FG');
INSERT INTO `user` VALUES ('12', 'asd', 'qwdqw', 'qwd', 'qwd');
INSERT INTO `user` VALUES ('13', 'aaa', 'aaa', 'aaa', 'aaa');
