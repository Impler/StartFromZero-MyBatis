/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-04-20 23:25:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_author
-- ----------------------------
DROP TABLE IF EXISTS `t_author`;
CREATE TABLE `t_author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `author_country` varchar(10) DEFAULT NULL COMMENT '国籍',
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_author
-- ----------------------------
INSERT INTO `t_author` VALUES ('1', '鲁迅', 'zh');
INSERT INTO `t_author` VALUES ('2', '钱钟书', 'zh');
INSERT INTO `t_author` VALUES ('3', '巴金', 'zh');
INSERT INTO `t_author` VALUES ('4', '孙犁', 'zh');
INSERT INTO `t_author` VALUES ('5', '马克·吐温', 'us');
INSERT INTO `t_author` VALUES ('6', '欧内斯特·米勒尔·海明威', 'us');
INSERT INTO `t_author` VALUES ('7', '查尔斯·狄更斯', 'en');
INSERT INTO `t_author` VALUES ('8', ' 简·奥斯丁', 'en');
INSERT INTO `t_author` VALUES ('9', '詹姆斯·乔伊斯', 'en');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(100) DEFAULT NULL COMMENT '书名',
  `book_description` varchar(255) DEFAULT NULL COMMENT '描述',
  `author_id` int(255) DEFAULT NULL COMMENT '作者',
  `book_publish_date` datetime DEFAULT NULL COMMENT '出版日期',
  PRIMARY KEY (`book_id`),
  KEY `t_book_author_id` (`author_id`),
  CONSTRAINT `t_book_author_id` FOREIGN KEY (`author_id`) REFERENCES `t_author` (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', '狂人日记', '狂人日记', '1', '2016-04-12 15:30:57');
INSERT INTO `t_book` VALUES ('2', '家', '家', '3', '2016-04-10 15:31:58');
INSERT INTO `t_book` VALUES ('3', '围城', '围城', '2', '2016-04-03 15:31:55');
INSERT INTO `t_book` VALUES ('4', '春', '春', '3', '2016-04-05 15:31:52');
INSERT INTO `t_book` VALUES ('5', '呐喊', '呐喊', '1', '2016-04-12 15:31:48');
INSERT INTO `t_book` VALUES ('6', '彷徨', '彷徨', '1', '2016-02-24 15:32:10');
INSERT INTO `t_book` VALUES ('7', '秋', '秋', '3', '2016-04-15 15:33:00');
INSERT INTO `t_book` VALUES ('8', '纪念', '纪念', '2', '2016-04-18 15:32:51');
INSERT INTO `t_book` VALUES ('9', '荷花淀', '荷花淀', '4', '2016-04-04 15:32:55');
INSERT INTO `t_book` VALUES ('10', '百合心', '百合心', '2', '2016-04-03 15:33:04');
INSERT INTO `t_book` VALUES ('11', '白洋淀纪事', '白洋淀纪事', '4', '2016-04-01 15:33:08');
INSERT INTO `t_book` VALUES ('12', '第五纵队', '第五纵队', '6', '2016-04-30 15:33:12');
INSERT INTO `t_book` VALUES ('13', '赤道游记', '赤道游记', '5', '2016-04-21 15:35:39');
INSERT INTO `t_book` VALUES ('14', '风云初记', '风云初记', '4', '2016-04-08 15:35:45');
INSERT INTO `t_book` VALUES ('15', '密西西比河上的生活', '密西西比河上的生活', '5', '2016-04-02 15:35:48');
INSERT INTO `t_book` VALUES ('16', '老人与海', '老人与海', '6', '2016-04-08 15:35:52');
INSERT INTO `t_book` VALUES ('17', '在亚瑟王朝的康涅狄克州的美国佬', '在亚瑟王朝的康涅狄克州的美国佬', '5', '2016-04-02 15:35:55');
INSERT INTO `t_book` VALUES ('18', '丧钟为谁而鸣', '丧钟为谁而鸣', '6', '2016-04-04 15:35:58');
INSERT INTO `t_book` VALUES ('19', '芬尼根的守灵夜', '芬尼根的守灵夜', '9', '2016-04-04 15:38:27');
INSERT INTO `t_book` VALUES ('20', '雾都孤儿', '雾都孤儿', '7', '2016-04-04 15:38:23');
INSERT INTO `t_book` VALUES ('21', '在我们的时代里', '在我们的时代里', '6', '2016-04-26 15:38:20');
INSERT INTO `t_book` VALUES ('22', '理智与情感', '理智与情感', '8', '2016-04-09 15:38:33');
INSERT INTO `t_book` VALUES ('23', '远大前程', '远大前程', '7', '2016-04-04 15:38:36');
INSERT INTO `t_book` VALUES ('24', '艰难时世', '艰难时世', '7', '2016-04-10 15:38:39');
INSERT INTO `t_book` VALUES ('25', '最初的印象', '最初的印象', '8', '2016-04-10 15:38:42');

-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(255) DEFAULT NULL,
  `post_username` varchar(50) DEFAULT NULL COMMENT '书评人',
  `post_content` varchar(255) DEFAULT NULL COMMENT '书评内容',
  PRIMARY KEY (`post_id`),
  KEY `t_post_book_id` (`book_id`),
  CONSTRAINT `t_post_book_id` FOREIGN KEY (`book_id`) REFERENCES `t_book` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_post
-- ----------------------------
INSERT INTO `t_post` VALUES ('1', '1', '张三', '震撼！！！！！振聋发聩！！！！！');
INSERT INTO `t_post` VALUES ('2', '1', '李四', '拉开了白话文的序幕');
INSERT INTO `t_post` VALUES ('3', '1', 'LISA', '果然是狂人');
INSERT INTO `t_post` VALUES ('4', '2', '八千华', '时代的传声筒');
INSERT INTO `t_post` VALUES ('5', '5', '桃兜兜', '恨其不幸，怒其不争。大哥硬生生把自己活成一个死人。');
INSERT INTO `t_post` VALUES ('6', '3', '像何首乌一样', '挺喜欢的故事，大时代的悲剧拧着小家庭的哀愁');
INSERT INTO `t_post` VALUES ('7', '2', '采采 ', '我一直觉得家和京华烟云很像~ = = ');
INSERT INTO `t_post` VALUES ('8', '3', '为情所困', '真没看出这本小说有什么好的，除了仿红楼梦的那些篇章');
INSERT INTO `t_post` VALUES ('9', '4', '普通小姐', '之前的章节在读的时候都是不紧不慢，无论事情发展到何种程度都可以淡定坦然地读下去。然而在最后这章，我好似被觉慧的热情给感染了，也可能是他的自信，叛逆的出走的顺利，使我一直处于紧张的状态，一直担心出走受到阻碍，担心他最终反抗以失败告终。好在，是一个光明的结局。');
INSERT INTO `t_post` VALUES ('10', '5', '左手倒影', ' 只记得大概内容了，但是这句，人是最健忘的，终身难忘。。 ');
INSERT INTO `t_post` VALUES ('11', '6', '她说我死老头子', '抨击封建礼教的愤青经典');
INSERT INTO `t_post` VALUES ('12', '7', '習慣沉默', '激流三部曲');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_useraccount
-- ----------------------------
INSERT INTO `t_useraccount` VALUES ('1', '任风', '123456', '12345678910', '12345678@qq.com', '2', '1', '2016-04-20 09:18:29');
INSERT INTO `t_useraccount` VALUES ('2', '小龙女', '123455', '12345543210', '65432@sina.com', '2', '0', '2016-03-06 09:19:12');
INSERT INTO `t_useraccount` VALUES ('3', '董小姐', '121212', '1231231231', '90509905409@qq.com', '3', '0', '2016-03-07 09:19:38');
INSERT INTO `t_useraccount` VALUES ('4', 'KOBE8', 'QWEasd123', '121212121', '34444444444444@qq.com', '2', '1', '2016-04-16 17:23:23');
INSERT INTO `t_useraccount` VALUES ('5', 'KOBE1', 'QWEasd123', '121212121', '34444444444444@qq.com', '1', '0', '2016-04-16 17:23:41');

-- ----------------------------
-- Procedure structure for selectBookAndAuthorProcedure
-- ----------------------------
DROP PROCEDURE IF EXISTS `selectBookAndAuthorProcedure`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectBookAndAuthorProcedure`(IN `authorId` int)
BEGIN
	select * from t_book where author_id = authorId;
	select * from t_author where author_id = authorId;

END
;;
DELIMITER ;
