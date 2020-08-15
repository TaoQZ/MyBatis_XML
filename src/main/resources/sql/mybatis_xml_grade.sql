create table grade
(
    gid   int auto_increment
        primary key,
    gname varchar(20) null,
    cid   int         null
);

INSERT INTO mybatis_xml.grade (gid, gname, cid) VALUES (1, '99999999', 1);
INSERT INTO mybatis_xml.grade (gid, gname, cid) VALUES (2, 'zx', 2);
INSERT INTO mybatis_xml.grade (gid, gname, cid) VALUES (3, '九年级三班', null);
INSERT INTO mybatis_xml.grade (gid, gname, cid) VALUES (5, 'asd', null);
INSERT INTO mybatis_xml.grade (gid, gname, cid) VALUES (8, 'taoqz', null);