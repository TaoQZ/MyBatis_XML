package xyz.taoqz.dao;

import xyz.taoqz.domain.Grade;

import java.util.List;

public interface GradeMapper {

    List<Grade> findAll();

    Grade findById(Integer gid);

    void insert(Grade teacher);

    int update(Grade teacher);

    int deleteById(Integer gid);

}
