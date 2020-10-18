/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : db_pet

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-10-18 20:43:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `admin_id` varchar(255) NOT NULL,
  `admin_nickname` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_realname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('159868820392738', 'admin', 'root', 'admin');

-- ----------------------------
-- Table structure for t_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE `t_doctor` (
  `doctor_id` varchar(255) NOT NULL,
  `doctor_description` varchar(255) DEFAULT NULL COMMENT '律师详细介绍',
  `doctor_gender` varchar(255) DEFAULT NULL,
  `doctor_icon` varchar(255) DEFAULT NULL,
  `doctor_nickname` varchar(255) DEFAULT NULL,
  `doctor_password` varchar(255) DEFAULT NULL,
  `doctor_realname` varchar(255) DEFAULT NULL,
  `doctor_title` varchar(255) DEFAULT NULL COMMENT '律师介绍标题',
  `lawyer_field` varchar(255) DEFAULT NULL COMMENT '擅长领域',
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_doctor
-- ----------------------------
INSERT INTO `t_doctor` VALUES ('2c9fa18b7516b757017516dc3e6e0000', '我很厉害', '男', 'images/product/160300222219372.jpg', '张医生', '123456', '张伟', '博士', '猫绝育');
INSERT INTO `t_doctor` VALUES ('2c9fa18b7516b757017516dde3700001', '无', '女', 'images/product/160240644116271.jpg', '天霸动霸tua', '123456', '楚云飞', '博士', '狗狗的各种疾病');
INSERT INTO `t_doctor` VALUES ('2c9fa18b7516b757017516df4bd30002', '宠物疾病找老李', '男', 'images/product/160240653326901.jpg', '宠物医生老李', '123', '李云龙', '副教授', '各种宠物疾病都ok');

-- ----------------------------
-- Table structure for t_info
-- ----------------------------
DROP TABLE IF EXISTS `t_info`;
CREATE TABLE `t_info` (
  `info_id` varchar(64) NOT NULL,
  `info_title` varchar(255) DEFAULT NULL,
  `info_type` varchar(255) DEFAULT '知识',
  `info_content` varchar(255) DEFAULT NULL,
  `info_icon` varchar(255) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_info
-- ----------------------------
INSERT INTO `t_info` VALUES ('2c9fa255753b93d801753b957cfc0000', '为什么你的二哈总拆家？', '科普', '因为你的二哈是纯种的。', 'images/product/160302245313232.jpg', '2020-10-18 20:00:54');
INSERT INTO `t_info` VALUES ('2c9fa255753b93d801753b9911030001', '养了这么多年的狗，你真的会养狗吗？', '科普', '就发了开始的课拉倒', 'images/product/160302268745101.jpg', '2020-10-18 20:04:49');
INSERT INTO `t_info` VALUES ('2c9fa255753b93d801753ba7491b0002', '震惊，金毛竟被二哈带跑偏！是道德的缺失还是人性的沦丧。', '新闻', '哈哈哈哈哈', 'images/product/160302361946915.jpg', '2020-10-18 20:20:20');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `realname` varchar(8) DEFAULT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `doctor_id` varchar(8) DEFAULT NULL,
  `doctor_name` varchar(16) NOT NULL,
  `pet_id` varchar(64) DEFAULT NULL,
  `pet_name` varchar(255) DEFAULT NULL,
  `pet_icon` varchar(255) DEFAULT NULL,
  `symptom` varchar(255) DEFAULT NULL,
  `solution` varchar(255) DEFAULT NULL,
  `ordertime` varchar(32) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `orderstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_pet
-- ----------------------------
DROP TABLE IF EXISTS `t_pet`;
CREATE TABLE `t_pet` (
  `pet_id` varchar(255) NOT NULL,
  `pet_name` varchar(255) DEFAULT NULL,
  `pet_category` varchar(255) DEFAULT NULL,
  `pet_icon` varchar(255) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`pet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pet
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` varchar(255) NOT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_gender` varchar(255) DEFAULT NULL,
  `user_nickname` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_realname` varchar(255) DEFAULT NULL,
  `user_icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2c9fa255753a6c8101753a71a8380000', '河北省石家庄市', 'zhangsan@123.com', '女', '小张', '123', '110', '张三', 'images/product/160300332725202.jpg');
INSERT INTO `t_user` VALUES ('2c9fa255753a6c8101753a7426670001', '北京市西城区', 'lisi@123.com', '男', '小李同学', '123456', '110', '李四', 'images/product/160300349124675.jpg');
