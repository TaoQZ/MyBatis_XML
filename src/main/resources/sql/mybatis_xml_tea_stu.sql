create table tea_stu
(
    tsid int auto_increment
        primary key,
    tid  int null,
    sid  int null
);

INSERT INTO mybatis_xml.tea_stu (tsid, tid, sid) VALUES (1, 1, 1);
INSERT INTO mybatis_xml.tea_stu (tsid, tid, sid) VALUES (2, 2, 2);
INSERT INTO mybatis_xml.tea_stu (tsid, tid, sid) VALUES (3, 3, 3);
INSERT INTO mybatis_xml.tea_stu (tsid, tid, sid) VALUES (4, 4, 6);
INSERT INTO mybatis_xml.tea_stu (tsid, tid, sid) VALUES (5, 1, 8);
INSERT INTO mybatis_xml.tea_stu (tsid, tid, sid) VALUES (6, 2, 1);
INSERT INTO mybatis_xml.tea_stu (tsid, tid, sid) VALUES (7, 2, 3);