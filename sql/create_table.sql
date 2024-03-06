-- 创建库
IF NOT EXISTS(SELECT *
              FROM sys.databases
              WHERE name = 'my_db')
BEGIN
        CREATE DATABASE my_db;
END

-- 切换库
USE my_db;

-- 用户表
IF NOT EXISTS(SELECT *
              FROM sys.tables
              WHERE name = 'user')
BEGIN
CREATE TABLE [user]
(
    id           BIGINT IDENTITY (1,1) PRIMARY KEY,
    userAccount  VARCHAR(256)                           NOT NULL,
    userPassword VARCHAR(512)                           NOT NULL,
    unionId      VARCHAR(256)                           NULL,
    mpOpenId     VARCHAR(256)                           NULL,
    userName     VARCHAR(256)                           NULL,
    userAvatar   VARCHAR(1024)                          NULL,
    userProfile  VARCHAR(512)                           NULL,
    userRole     VARCHAR(256) DEFAULT 'user'            NOT NULL,
    createTime   DATETIME     DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updateTime   DATETIME     DEFAULT CURRENT_TIMESTAMP NOT NULL,
    isDelete     TINYINT      DEFAULT 0                 NOT NULL,
    INDEX idx_unionId (unionId)
    );
END

-- 帖子表
IF NOT EXISTS(SELECT *
              FROM sys.tables
              WHERE name = 'post')
BEGIN
CREATE TABLE post
(
    id         BIGINT IDENTITY (1,1) PRIMARY KEY,
    title      VARCHAR(512)                       NULL,
    content    TEXT                               NULL,
    tags       VARCHAR(1024)                      NULL,
    thumbNum   INT      DEFAULT 0                 NOT NULL,
    favourNum  INT      DEFAULT 0                 NOT NULL,
    userId     BIGINT                             NOT NULL,
    createTime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updateTime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    isDelete   TINYINT  DEFAULT 0                 NOT NULL,
    INDEX idx_userId (userId)
);
END

-- 帖子点赞表（硬删除）
IF NOT EXISTS(SELECT *
              FROM sys.tables
              WHERE name = 'post_thumb')
BEGIN
CREATE TABLE post_thumb
(
    id         BIGINT IDENTITY (1,1) PRIMARY KEY,
    postId     BIGINT                             NOT NULL,
    userId     BIGINT                             NOT NULL,
    createTime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updateTime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    INDEX idx_postId (postId),
    INDEX idx_userId (userId)
);
END

-- 帖子收藏表（硬删除）
IF NOT EXISTS(SELECT *
              FROM sys.tables
              WHERE name = 'post_favour')
BEGIN
CREATE TABLE post_favour
(
    id         BIGINT IDENTITY (1,1) PRIMARY KEY,
    postId     BIGINT                             NOT NULL,
    userId     BIGINT                             NOT NULL,
    createTime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updateTime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    INDEX idx_postId (postId),
    INDEX idx_userId (userId)
);
END
