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


    CREATE TABLE
    role
    (
        id INT NOT NULL AUTO_INCREMENT COMMENT '角色表主键',
        name VARCHAR(20) NOT NULL COMMENT '角色名称',
        createtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
        creator INT DEFAULT '0' COMMENT '用户id，0为角色，有关联时则为用户的单独权限',
        description VARCHAR(200) COMMENT '角色描述',
        updateuser INT COMMENT '更新者id',
        updatetime TIMESTAMP NULL COMMENT '更新时间',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=gbk;


    CREATE TABLE
    menu
    (
        id INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
        name VARCHAR(32) NOT NULL COMMENT '菜单名称',
        url VARCHAR(500) COMMENT '网址',
        icon VARCHAR(20) COMMENT '显示的图标',
        menutype enum('0','1','2') DEFAULT '0' NOT NULL COMMENT '类型，0 菜单，1 连接网址,2 隐藏连接',
        display INT DEFAULT '1' NOT NULL COMMENT '显示排序',
        parentid INT DEFAULT '0' NOT NULL COMMENT '父级的id，引用本表id字段',
        creator INT DEFAULT '0' NOT NULL COMMENT '创建者id，0为超级管理员',
        createtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
        updateuser INT COMMENT '更新者id',
        updatetime TIMESTAMP NULL COMMENT '更新时间',
        flag enum('0','1') DEFAULT '1' NOT NULL COMMENT '是否启用，0 禁用，1启用',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=gbk;

    CREATE TABLE
    admin_user
    (
        id INT NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
        tenantid INT NOT NULL COMMENT '租户id，0为系统用户',
        name VARCHAR(20) NOT NULL COMMENT '用户名',
        psw VARCHAR(32) NOT NULL COMMENT '用户密码MD5加密',
        email VARCHAR(32) NOT NULL COMMENT '用户邮箱',
        creator INT NOT NULL COMMENT '创建人，0为初始化',
        createtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON
    UPDATE
        CURRENT_TIMESTAMP COMMENT '创建时间',
        flag INT(1) DEFAULT '1' NOT NULL COMMENT '用户状态，1启用，0禁用',
        logintime TIMESTAMP DEFAULT '0000-00-00 00:00:00' COMMENT '最后登录时间',
        updateuser INT COMMENT '更新者id',
        updatetime TIMESTAMP NULL COMMENT '更新时间',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=gbk;

    CREATE TABLE
    user_role
    (
        userid INT NOT NULL COMMENT '用户id',
        roleid INT NOT NULL COMMENT '角色id',
        creator INT NOT NULL COMMENT '创建人，0为初始化',
        createtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
        PRIMARY KEY (userid, roleid)
    )
    ENGINE=InnoDB DEFAULT CHARSET=gbk;


    INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (1, '系统首页', '/admin/index', null, '2', 1, 0, 0, '2017-03-31 20:16:57', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (2, '修改密码', '/admin/user/updatepass', 'fa-wrench', '2', 0, 0, 0, '2017-04-05 21:33:39', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (3, '系统配置', '12', 'fa-wrench', '0', 1, 0, 0, '2017-03-31 20:16:43', 0, '2017-04-05 20:30:53', '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (4, '菜单配置', '/admin/menu', 'fa-list', '0', 1, 3, 0, '2017-03-31 20:16:45', 0, '2017-04-05 20:31:10', '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (5, '角色管理', '/admin/role', null, '0', 2, 3, 0, '2017-03-31 20:16:48', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (6, '角色权限', '/admin/role/menu', null, '2', 0, 3, 0, '2017-03-31 20:16:52', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (7, '用户管理', '/admin/user', null, '1', 2, 3, 0, '2017-03-31 20:16:54', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (8, '新增菜单', '/admin/menu/edit', null, '2', 0, 4, 0, '2017-03-31 20:17:01', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (9, '删除菜单', '/admin/menu/delete', null, '2', 0, 4, 0, '2017-03-31 20:17:04', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (10, '编辑角色', '/admin/role/edit', null, '2', 0, 5, 0, '2017-03-31 20:17:06', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (11, '删除角色', '/admin/role/delete', null, '2', 0, 5, 0, '2017-03-31 20:17:07', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (12, '角色资源管理', '/admin/role/menu', null, '2', 0, 5, 0, '2017-03-31 20:17:08', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (13, '编辑用户', '/admin/user/edit', null, '2', 0, 7, 0, '2017-03-31 20:17:09', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (14, '删除用户', '/admin/user/delete', null, '2', 0, 7, 0, '2017-03-31 20:17:10', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (15, '用户角色管理', '/admin/user/role', null, '2', 0, 7, 0, '2017-03-31 20:17:12', 0, null, '1');
INSERT INTO menu (id, name, url, icon, menutype, display, parentid, creator, createtime, updateuser, updatetime, flag) VALUES (16, '菜单配置', '', null, '2', 0, 7, 20, '2017-04-02 11:38:28', 0, null, '1');

CREATE TABLE
    role_menu
    (
        roleid INT NOT NULL COMMENT '角色id',
        menuid INT NOT NULL COMMENT '菜单id',
        flag INT(1) DEFAULT '1' NOT NULL COMMENT '1为有权限，0为没有权限（防止以后会出现角色有权限但是个人没有权限的情况）',
        creator INT NOT NULL COMMENT '创建人，0为初始化',
        createtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
        PRIMARY KEY (menuid, roleid)
    )
    ENGINE=InnoDB DEFAULT CHARSET=gbk;


INSERT INTO admin_user (id, tenantid, name, psw, email, creator, createtime, flag, logintime, updateuser, updatetime) VALUES (-1, 0, 'root', '63A9F0EA7BB98050796B649E85481845', 'admin@raye.wang', 0, '2018-05-28 10:53:05', 1, '2017-04-07 22:23:15', -1, '2017-12-19 03:04:59');


INSERT INTO role (id, name, createtime, creator, description, updateuser, updatetime) VALUES (1, '超级用户', '2018-03-05 23:00:43', 0, '拥有系统所有权限', -1, '2018-03-05 09:00:44');

INSERT INTO user_role (userid, roleid, creator, createtime) VALUES (-1, 1, -1, '2018-03-05 23:37:04');

