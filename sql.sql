DROP DATABASE if EXISTS bookstore;
CREATE DATABASE bookstore;

USE bookstore;

## 书籍表
DROP DATABASE if EXISTS `b_book`;
CREATE TABLE `b_book` (
                          `id` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                          `name` VARCHAR(20) NOT NULL COMMENT '书籍名',
                          `price` FLOAT(5) NOT NULL COMMENT '价格',
                          `author` VARCHAR(100) NOT NULL COMMENT '作者',
                          `isbn` VARCHAR(64) UNIQUE NOT NULL COMMENT 'ISBN',
                          `type` VARCHAR(32) NOT NULL COMMENT '类别',
                          `publisher` VARCHAR(64) NOT NULL COMMENT '出版商',
                          `intro` TEXT COMMENT '介绍',
                          `cover` VARCHAR(1024) NOT NULL COMMENT '封面',
                          PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

INSERT `b_book` VALUES(1, '文城', 34.5, '余华', '111', '文学', '中国文学出版社', '林祥福找小美的故事', '');
INSERT `b_book` VALUES(2, '平凡的世界', 79.8, '路遥', '112', '文学', '北京十月文艺出版社', '平凡的人生拥有不平凡的世界', '');