package xyz.taoqz.dao;

import xyz.taoqz.domain.School;

import java.util.List;

public interface SchoolMapper{

    List<School> findAll();

    void update(School school);
}
