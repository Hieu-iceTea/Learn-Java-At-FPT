# 1_1 Thiết kế cơ sở dữ liệu

# [Java2_05] eBookStore Online: design database & select
# https://www.codelean.vn/2020/03/java205-ebookstore-online-design.html

DROP DATABASE IF EXISTS eBookStore;
CREATE DATABASE IF NOT EXISTS eBookStore;

USE eBookStore;

DROP TABLE IF EXISTS Author;
CREATE TABLE IF NOT EXISTS Author (
    IDAuthor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    Name NVARCHAR(32) NOT NULL,
    Description NVARCHAR(256),

    CreatedBy NVARCHAR(32),
    UpdatedBy NVARCHAR(32),
    CreatedDate DATETIME,
    UpdatedDate DATETIME,
    Enabled BOOLEAN

    #PRIMARY KEY (IDAuthor)
);

DROP TABLE IF EXISTS PublishCompany;
CREATE TABLE IF NOT EXISTS PublishCompany (
    IDPublishCompany INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    Name NVARCHAR(32),
    Description NVARCHAR(256),

    CreatedBy NVARCHAR(32),
    UpdatedBy NVARCHAR(32),
    CreatedDate DATETIME,
    UpdatedDate DATETIME,
    Enabled BOOLEAN

    #PRIMARY KEY (IDPublishCompany)
);

DROP TABLE IF EXISTS Category;
CREATE TABLE IF NOT EXISTS Category (
    IDCategory INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    Name NVARCHAR(32) NOT NULL,
    Description NVARCHAR(256),

    CreatedBy NVARCHAR(32),
    UpdatedBy NVARCHAR(32),
    CreatedDate DATETIME,
    UpdatedDate DATETIME,
    Enabled BOOLEAN

    #PRIMARY KEY (IDCategory)
);

DROP TABLE IF EXISTS Book;
CREATE TABLE IF NOT EXISTS Book (
    IDBook INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    IDAuthor INT NOT NULL,
    IDCategory INT NOT NULL,
    IDPublishCompany INT NOT NULL,

    Name NVARCHAR(128) NOT NULL,
    Price DOUBLE(18,2) NOT NULL,
    Qty INT NOT NULL,
    DatePublish DATETIME,
    Description NVARCHAR(512),

    CreatedBy NVARCHAR(32),
    UpdatedBy NVARCHAR(32),
    CreatedDate DATETIME,
    UpdatedDate DATETIME,
    Enabled BOOLEAN,

    FOREIGN KEY (IDAuthor) REFERENCES Author(IDAuthor),
    FOREIGN KEY (IDCategory) REFERENCES Category(IDCategory),
    FOREIGN KEY (IDPublishCompany) REFERENCES PublishCompany(IDPublishCompany)

    #PRIMARY KEY (IDBook)
);

DROP TABLE IF EXISTS Customer;
CREATE TABLE IF NOT EXISTS Customer (
    IDCustomer INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    Name NVARCHAR(32) NOT NULL,
    Address NVARCHAR(128),
    Phone VARCHAR(32),
    Email VARCHAR(64),
    UserName VARCHAR(64),
    Password VARCHAR(64),
    Description NVARCHAR(256),

    CreatedBy NVARCHAR(32),
    UpdatedBy NVARCHAR(32),
    CreatedDate DATETIME,
    UpdatedDate DATETIME,
    Enabled BOOLEAN

    #PRIMARY KEY (IDCustomer)
);

DROP TABLE IF EXISTS `Order`;
CREATE TABLE IF NOT EXISTS `Order` (
    IDOrder INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    IDCustomer INT NOT NULL,

    Status INT NOT NULL,
    TotalPrice DOUBLE(18,2) NOT NULL,
    Description NVARCHAR(256),

    CreatedBy NVARCHAR(32),
    UpdatedBy NVARCHAR(32),
    CreatedDate DATETIME,
    UpdatedDate DATETIME,
    Enabled BOOLEAN,

    FOREIGN KEY (IDCustomer) REFERENCES Customer(IDCustomer)

    #PRIMARY KEY (IDOrder)
);

DROP TABLE IF EXISTS OrderDetail;
CREATE TABLE IF NOT EXISTS OrderDetail (
    IDOrderDetail INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    IDOrder INT NOT NULL,
    IDBook INT NOT NULL,

    Price DOUBLE(18,2) NOT NULL,
    Qty INT NOT NULL,
    Description NVARCHAR(256),

    CreatedBy NVARCHAR(32),
    UpdatedBy NVARCHAR(32),
    CreatedDate DATETIME,
    UpdatedDate DATETIME,
    Enabled BOOLEAN,

    FOREIGN KEY (IDOrder) REFERENCES `Order`(IDOrder),
    FOREIGN KEY (IDBook) REFERENCES Book(IDBook)

    #PRIMARY KEY (IDOrderDetail)
);