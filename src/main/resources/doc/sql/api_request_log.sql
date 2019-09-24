/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : wolf

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-09-24 16:26:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for api_request_log
-- ----------------------------
DROP TABLE IF EXISTS `api_request_log`;
CREATE TABLE `api_request_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `request_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '请求时间',
  `status` varchar(255) DEFAULT '' COMMENT '请求状态',
  `ip` varchar(255) DEFAULT NULL COMMENT '请求者IP地址',
  `response_time` double(150,0) DEFAULT NULL COMMENT '响应时间',
  `request_url` varchar(255) DEFAULT NULL COMMENT '请求访问路径',
  `ajax_request_flag` varchar(255) DEFAULT NULL COMMENT '是否是ajax请求',
  `request_method` varchar(255) DEFAULT NULL COMMENT '请求方法(GET/POST)',
  `request_method_name` varchar(255) DEFAULT NULL COMMENT '请求方法名称',
  `request_params` varchar(255) DEFAULT NULL COMMENT '请求参数',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户ID',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户名称',
  `request_session_id` varchar(150) DEFAULT NULL COMMENT '网页sessionId',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of api_request_log
-- ----------------------------
INSERT INTO `api_request_log` VALUES ('1', '2019-09-23 09:38:21', '200', '0:0:0:0:0:0:0:1', '0', '/customer/toLogIn', '0', 'GET', 'toLogIn', '{}', null, null, 'A8F636D0A290EE3486F39A6EFD751A37');
INSERT INTO `api_request_log` VALUES ('2', '2019-09-23 09:47:35', '200', '0:0:0:0:0:0:0:1', '0', '/customer/toLogIn', '0', 'GET', 'toLogIn', '{}', '711', '刘五', 'A8F636D0A290EE3486F39A6EFD751A37');
INSERT INTO `api_request_log` VALUES ('3', '2019-09-23 09:47:41', '200', '0:0:0:0:0:0:0:1', '6', '/customer/logIn', '0', 'GET', 'logIn', '{\"loginName\":[\"lw108\"],\"passWord\":[\"1\"]}', '711', '刘五', 'A8F636D0A290EE3486F39A6EFD751A37');
INSERT INTO `api_request_log` VALUES ('4', '2019-09-23 09:47:41', '200', '0:0:0:0:0:0:0:1', '127', '/customer/toListAllCustomer', '0', 'GET', 'toListAllCustomer', '{}', '711', '刘五', 'A8F636D0A290EE3486F39A6EFD751A37');
INSERT INTO `api_request_log` VALUES ('5', '2019-09-23 09:52:06', '200', '0:0:0:0:0:0:0:1', '2', '/layUI/goLayUI', '0', 'GET', 'goLayUI', '{}', '711', '刘五', 'A8F636D0A290EE3486F39A6EFD751A37');
INSERT INTO `api_request_log` VALUES ('6', '2019-09-23 09:52:06', '200', '0:0:0:0:0:0:0:1', '0', '/layUI/toLayUI', '0', 'GET', 'toLayUI', '{}', '711', '刘五', 'A8F636D0A290EE3486F39A6EFD751A37');
INSERT INTO `api_request_log` VALUES ('7', '2019-09-23 09:52:07', '200', '0:0:0:0:0:0:0:1', '9', '/customer/listAllUser', '1', 'GET', 'listAllUser', '{\"page\":[\"1\"],\"limit\":[\"10\"]}', '711', '刘五', 'A8F636D0A290EE3486F39A6EFD751A37');
INSERT INTO `api_request_log` VALUES ('8', '2019-09-23 09:52:19', '200', '0:0:0:0:0:0:0:1', '10', '/customer/listAllUser', '1', 'GET', 'listAllUser', '{\"page\":[\"2\"],\"limit\":[\"10\"]}', '711', '刘五', 'A8F636D0A290EE3486F39A6EFD751A37');
INSERT INTO `api_request_log` VALUES ('9', '2019-09-23 09:52:20', '200', '0:0:0:0:0:0:0:1', '8', '/customer/listAllUser', '1', 'GET', 'listAllUser', '{\"page\":[\"3\"],\"limit\":[\"10\"]}', '711', '刘五', 'A8F636D0A290EE3486F39A6EFD751A37');
INSERT INTO `api_request_log` VALUES ('10', '2019-09-23 09:52:24', '200', '0:0:0:0:0:0:0:1', '11', '/customer/listAllUser', '1', 'GET', 'listAllUser', '{\"page\":[\"3\"],\"limit\":[\"40\"]}', '711', '刘五', 'A8F636D0A290EE3486F39A6EFD751A37');
INSERT INTO `api_request_log` VALUES ('11', '2019-09-24 15:50:05', '200', '0:0:0:0:0:0:0:1', '117', '/customer/toLogIn', '0', 'GET', 'toLogIn', '{}', null, null, '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('12', '2019-09-24 16:13:37', '200', '0:0:0:0:0:0:0:1', '48', '/customer/logIn', '0', 'GET', 'logIn', '{\"loginName\":[\"lw108\"],\"passWord\":[\"1\"]}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('13', '2019-09-24 16:13:37', '200', '0:0:0:0:0:0:0:1', '136', '/customer/toListAllCustomer', '0', 'GET', 'toListAllCustomer', '{}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('14', '2019-09-24 16:18:09', '200', '0:0:0:0:0:0:0:1', '0', '/customer/toLogIn', '0', 'GET', 'toLogIn', '{}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('15', '2019-09-24 16:19:02', '200', '0:0:0:0:0:0:0:1', '5', '/customer/logIn', '0', 'GET', 'logIn', '{\"loginName\":[\"lw108\"],\"passWord\":[\"1\"]}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('16', '2019-09-24 16:19:02', '200', '0:0:0:0:0:0:0:1', '6', '/customer/toListAllCustomer', '0', 'GET', 'toListAllCustomer', '{}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('17', '2019-09-24 16:21:41', '200', '0:0:0:0:0:0:0:1', '2', '/layUI/goLayUI', '0', 'GET', 'goLayUI', '{}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('18', '2019-09-24 16:21:41', '200', '0:0:0:0:0:0:0:1', '0', '/layUI/toLayUI', '0', 'GET', 'toLayUI', '{}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('19', '2019-09-24 16:21:41', '200', '0:0:0:0:0:0:0:1', '14', '/customer/listAllUser', '1', 'GET', 'listAllUser', '{\"page\":[\"1\"],\"limit\":[\"10\"]}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('20', '2019-09-24 16:22:47', '200', '0:0:0:0:0:0:0:1', '8', '/customer/listAllUser', '1', 'GET', 'listAllUser', '{\"page\":[\"2\"],\"limit\":[\"10\"]}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('21', '2019-09-24 16:22:48', '200', '0:0:0:0:0:0:0:1', '8', '/customer/listAllUser', '1', 'GET', 'listAllUser', '{\"page\":[\"1\"],\"limit\":[\"10\"]}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('22', '2019-09-24 16:23:04', '200', '0:0:0:0:0:0:0:1', '8', '/customer/listAllUser', '1', 'GET', 'listAllUser', '{\"page\":[\"2\"],\"limit\":[\"10\"]}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
INSERT INTO `api_request_log` VALUES ('23', '2019-09-24 16:23:06', '200', '0:0:0:0:0:0:0:1', '6', '/customer/listAllUser', '1', 'GET', 'listAllUser', '{\"page\":[\"1\"],\"limit\":[\"10\"]}', '711', '刘五', '9DAF46AA8B488D1A6AA374F4F965787F');
