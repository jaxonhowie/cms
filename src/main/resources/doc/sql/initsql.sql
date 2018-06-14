CREATE TABLE
    user_info
    (
        USER_ID VARCHAR(32) NOT NULL,
        loginname VARCHAR(64) NOT NULL,
        name VARCHAR(64) NOT NULL,
        password VARCHAR(64) NOT NULL,
        usertype INT(1) DEFAULT '0' NOT NULL,
        isdefault INT(1) DEFAULT '0' NOT NULL,
        state INT(1) DEFAULT '0' NOT NULL,
        organization_id VARCHAR(32) DEFAULT '0' NOT NULL,
        crt_user VARCHAR(20) DEFAULT 'SYSTEM',
        crt_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        lst_upd_user VARCHAR(20),
        lst_upd_time TIMESTAMP NULL ,
        rec_status CHAR(1) DEFAULT '0',
        scr_level CHAR(2) DEFAULT '0',
        lst_login_time TIMESTAMP NULL,
        PRIMARY KEY (USER_ID)
    )
    ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE TABLE
    role_info
    (
        ROLE_ID VARCHAR(32) NOT NULL,
        name VARCHAR(64) NOT NULL,
        seq INT(1) DEFAULT '0',
        description VARCHAR(255),
        isdefault INT(1) DEFAULT '0',
        crt_user VARCHAR(20) DEFAULT 'SYSTEM',
        crt_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        lst_upd_user VARCHAR(20),
        lst_upd_time TIMESTAMP NULL,
        lst_upd_date DATE,
        rec_status CHAR(1) DEFAULT '0',
        scr_level CHAR(2) DEFAULT '0',
        PRIMARY KEY (ROLE_ID)
    )
CREATE TABLE
    RESOURCE
    (
        RESOURCE_ID VARCHAR(32) NOT NULL,
        name VARCHAR(100),
        url VARCHAR(255),
        description VARCHAR(255),
        icon VARCHAR(32),
        pid INT,
        seq INT(1) DEFAULT '0',
        state INT(1) DEFAULT '0',
        resourcetype INT(1) DEFAULT '0',
        crt_user VARCHAR(20),
        crt_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        lst_upd_user VARCHAR(20) DEFAULT 'SYSTEM',
        lst_upd_time TIMESTAMP ,
        lst_upd_date DATE,
        rec_status CHAR(1) DEFAULT '0',
        scr_level CHAR(2) DEFAULT '0',
        PRIMARY KEY (RESOURCE_ID)
    )
    ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE TABLE
    role_permission
    (
        ROLE_ID VARCHAR(32) NOT NULL,
        USERID VARCHAR(32) NOT NULL,
        PERMID VARCHAR(32) NOT NULL,
        CRT_TIME TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
        LST_UPD_USER VARCHAR(20) DEFAULT 'SYSTEM',
        LST_UPD_TIME TIMESTAMP NULL,
        PRIMARY KEY (ROLE_ID)
    )
    ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE TABLE
    role_resource
    (
        ROLE_ID VARCHAR(32) NOT NULL,
        RESOURCE_ID VARCHAR(32) NOT NULL,
        crt_user VARCHAR(20),
        crt_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        lst_upd_user VARCHAR(20) DEFAULT 'SYSTEM',
        lst_upd_time TIMESTAMP NULL,
        lst_upd_date DATE,
        rec_status CHAR(1) DEFAULT '0',
        scr_level CHAR(2) DEFAULT '0',
        PRIMARY KEY (ROLE_ID, RESOURCE_ID)
    )
    ENGINE=InnoDB DEFAULT CHARSET=gbk;