/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-04-19 09:31:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_useraccount
-- ----------------------------
DROP TABLE IF EXISTS `t_useraccount`;
CREATE TABLE `t_useraccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `telnumber` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `role` tinyint(1) DEFAULT NULL COMMENT '用户角色',
  `active` tinyint(1) DEFAULT NULL COMMENT '用户状态',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_useraccount
-- ----------------------------
INSERT INTO `t_useraccount` VALUES ('1', '任风', '123456', '12345678910', '12345678@qq.com', '2', '1', '2016-04-20 09:18:29');
INSERT INTO `t_useraccount` VALUES ('2', '小龙女', '123455', '12345543210', '65432@sina.com', '2', '0', '2016-03-06 09:19:12');
INSERT INTO `t_useraccount` VALUES ('3', '董小姐', '121212', '1231231231', '90509905409@qq.com', '3', '0', '2016-03-07 09:19:38');
INSERT INTO `t_useraccount` VALUES ('4', 'KOBE8', 'QWEasd123', '121212121', '34444444444444@qq.com', '2', '1', '2016-04-16 17:23:23');
INSERT INTO `t_useraccount` VALUES ('5', 'KOBE1', 'QWEasd123', '121212121', '34444444444444@qq.com', '1', '0', '2016-04-16 17:23:41');
