package xyz.taoqz.dao;

import xyz.taoqz.domain.Teacher;

import java.util.List;


public interface TeacherMapper{

//    注解方式,在配置文件中和<package name="xyz.taoqz.dao"/> 搭配使用
//    @Select("select * from mybatis_xml.teacher")
    List<Teacher> findAll();

    Teacher findById(Integer tid);

    void insert(Teacher teacher);

    int update(Teacher teacher);

    int deleteById(Integer tid);
}
