create table school
(
    cid   int auto_increment
        primary key,
    cname varchar(20) null
);

INSERT INTO mybatis_xml.school (cid, cname) VALUES (1, '交大');
INSERT INTO mybatis_xml.school (cid, cname) VALUES (2, '交大');