package xyz.taoqz.dao;

import tk.mybatis.mapper.common.Mapper;
import xyz.taoqz.domain.School;

import java.util.List;

public interface SchoolMapper {

    List<School> findAll();

    void update(School school);
}
