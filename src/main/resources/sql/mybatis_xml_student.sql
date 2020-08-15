create table student
(
    sid    int auto_increment
        primary key,
    sname  varchar(100) null,
    sex    varchar(20)  null,
    gid    int          null,
    remark varchar(200) null
);

INSERT INTO mybatis_xml.student (sid, sname, sex, gid, remark) VALUES (1, 'update', '女', 1, null);
INSERT INTO mybatis_xml.student (sid, sname, sex, gid, remark) VALUES (2, '小明', '男', 2, null);
INSERT INTO mybatis_xml.student (sid, sname, sex, gid, remark) VALUES (3, '小刚', '男', 3, null);
INSERT INTO mybatis_xml.student (sid, sname, sex, gid, remark) VALUES (6, '王五', '男', 2, null);
INSERT INTO mybatis_xml.student (sid, sname, sex, gid, remark) VALUES (8, '赵六', '男', 2, null);
INSERT INTO mybatis_xml.student (sid, sname, sex, gid, remark) VALUES (22, '赵四', '女', 2, '2020-08-11 11:18:27.0');
INSERT INTO mybatis_xml.student (sid, sname, sex, gid, remark) VALUES (23, '万茜', '女', null, null);