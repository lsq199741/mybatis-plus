/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 10/05/2019 16:51:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '密码盐',
  `create_admin` int(10) DEFAULT '0' COMMENT '创建管理员编号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='管理员用户表';

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES (1, '骆书强', 'luoshuqiang', '5d9828eb0fb4064df20bff5aa9388760', '1', 0, '2019-04-30 13:23:17');
INSERT INTO `admin` VALUES (2, '周凯旋', 'zhoukaixuan', 'eeafb716f93fa090d7716749a6eefa72', '1', 1, '2019-04-30 13:26:34');
INSERT INTO `admin` VALUES (3, '张苗苗', 'zmm', 'eeafb716f93fa090d7716749a6eefa72', '1', 1, '2019-04-30 13:27:04');
INSERT INTO `admin` VALUES (5, '骆晨', 'luochen', '6b4308e762489d86fd98151fbb476d2e', 'chen', 1, '2019-05-07 15:54:09');
COMMIT;

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `admin_id` int(10) NOT NULL COMMENT '管理员编号',
  `role_id` int(10) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`admin_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员权限表';

-- ----------------------------
-- Records of admin_role
-- ----------------------------
BEGIN;
INSERT INTO `admin_role` VALUES (1, 1);
INSERT INTO `admin_role` VALUES (2, 2);
INSERT INTO `admin_role` VALUES (3, 3);
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(10) DEFAULT NULL COMMENT '父id',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `permission` varchar(32) DEFAULT NULL COMMENT '许可名称',
  `url` varchar(100) DEFAULT NULL COMMENT '接口url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='许可表';

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
INSERT INTO `permission` VALUES (1, 0, '系统管理', 'menu', 'system', '');
INSERT INTO `permission` VALUES (2, 1, '系统管理员管理', 'menu', 'adminManagement', '/admn/adminManagement');
INSERT INTO `permission` VALUES (3, 2, '管理员用户列表', 'api', 'adminList', '/admin/UserList');
INSERT INTO `permission` VALUES (4, 2, '管理员用户详情', 'api', 'adminInfo', '/admin/adminInfo');
INSERT INTO `permission` VALUES (5, 2, '管理员用户修改', 'api', 'adminUpdate', '/admin/adminUpdate');
INSERT INTO `permission` VALUES (6, 2, '管理员用户添加', 'api', 'adminAdd', '/admin/adminAdd');
INSERT INTO `permission` VALUES (7, 2, '管理员用户删除', 'api', 'adminDelete', '/admin/adminDel');
INSERT INTO `permission` VALUES (8, 2, '管理员角色列表', 'api', 'roleList', '/admin/roleList');
INSERT INTO `permission` VALUES (9, 2, '管理员修改密码', 'api', 'updatePassword', '/admin/updatePassword');
INSERT INTO `permission` VALUES (10, 2, '管理员重置密码', 'api', 'resetPassword', '/admin/resetPassword');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `name` varchar(32) NOT NULL COMMENT '角色名称',
  `title` varchar(32) NOT NULL COMMENT '角色说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'sys_admin', '系统管理员');
INSERT INTO `role` VALUES (2, 'admin', '普通管理员');
INSERT INTO `role` VALUES (3, 'back_admin', '后台管理员');
COMMIT;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int(10) NOT NULL COMMENT '角色id',
  `permission_id` int(10) NOT NULL COMMENT '许可id',
  `isenable` int(1) NOT NULL DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`role_id`,`permission_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色许可表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
BEGIN;
INSERT INTO `role_permission` VALUES (1, 1, 1);
INSERT INTO `role_permission` VALUES (1, 2, 1);
INSERT INTO `role_permission` VALUES (1, 3, 1);
INSERT INTO `role_permission` VALUES (1, 4, 1);
INSERT INTO `role_permission` VALUES (1, 5, 1);
INSERT INTO `role_permission` VALUES (1, 6, 1);
INSERT INTO `role_permission` VALUES (1, 7, 1);
INSERT INTO `role_permission` VALUES (1, 8, 1);
INSERT INTO `role_permission` VALUES (1, 9, 1);
INSERT INTO `role_permission` VALUES (1, 10, 1);
INSERT INTO `role_permission` VALUES (2, 1, 1);
INSERT INTO `role_permission` VALUES (2, 2, 1);
INSERT INTO `role_permission` VALUES (2, 3, 1);
INSERT INTO `role_permission` VALUES (2, 4, 1);
INSERT INTO `role_permission` VALUES (2, 5, 1);
INSERT INTO `role_permission` VALUES (2, 6, 1);
INSERT INTO `role_permission` VALUES (2, 7, 1);
INSERT INTO `role_permission` VALUES (2, 8, 1);
INSERT INTO `role_permission` VALUES (2, 9, 1);
INSERT INTO `role_permission` VALUES (2, 10, 1);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `username` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `role` int(10) NOT NULL COMMENT '角色',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '骆书强', '1246690778@qq.com', 'c11086871e4220e8c351341d51e08e75', 1, '2019-04-22 19:48:10');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
