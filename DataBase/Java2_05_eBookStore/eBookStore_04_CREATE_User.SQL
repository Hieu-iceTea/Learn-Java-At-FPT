USE eBookStore;

DROP TABLE IF EXISTS User;
CREATE TABLE IF NOT EXISTS User (
    IdUser INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UserName VARCHAR(32) NOT NULL,
    Password VARCHAR(32) NOT NULL,
    Role INT NOT NULL,

    Name NVARCHAR(64),
    Email NVARCHAR(64),

    CreatedBy NVARCHAR(32),
    UpdatedBy NVARCHAR(32),
    CreatedDate DATETIME,
    UpdatedDate DATETIME,
    Enabled BOOLEAN

    #PRIMARY KEY (IDCustomer)
);