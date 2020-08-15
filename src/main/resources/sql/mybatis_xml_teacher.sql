create table teacher
(
    tid   int auto_increment
        primary key,
    tname varchar(20) null
);

INSERT INTO mybatis_xml.teacher (tid, tname) VALUES (1, 'new 111');
INSERT INTO mybatis_xml.teacher (tid, tname) VALUES (2, '张老师');
INSERT INTO mybatis_xml.teacher (tid, tname) VALUES (3, '王老师');
INSERT INTO mybatis_xml.teacher (tid, tname) VALUES (4, '赵老师');