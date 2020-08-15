package xyz.taoqz;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.taoqz.dao.GradeMapper;
import xyz.taoqz.dao.SchoolMapper;
import xyz.taoqz.domain.Grade;
import xyz.taoqz.domain.School;
import xyz.taoqz.utils.MyBatisCacheUtil;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author :almostTao
 * @date :Created in 2020/8/15 12:52
 */
public class TwoLevelCacheTest {

    @Test
    public void demo() {
        SqlSession sqlSession1 = MyBatisCacheUtil.openSession();
        SqlSession sqlSession2 = MyBatisCacheUtil.openSession();

        GradeMapper mapper1 = sqlSession1.getMapper(GradeMapper.class);
        GradeMapper mapper2 = sqlSession2.getMapper(GradeMapper.class);

        System.out.println("mapper1  " + mapper1.findById(1));
        //        手动提交
        sqlSession1.commit();
        //        或者关闭
//        sqlSession1.close();
        System.out.println("mapper2  " + mapper2.findById(1));

    }

    /**
     * 测试不同的sqlsession之间是否共享缓存
     */
    @Test
    public void demo1(){
        SqlSession sqlSession1 = MyBatisCacheUtil.openSession();
        SqlSession sqlSession2 = MyBatisCacheUtil.openSession();

        GradeMapper mapper1 = sqlSession1.getMapper(GradeMapper.class);
        GradeMapper mapper2 = sqlSession2.getMapper(GradeMapper.class);

        System.out.println("mapper1 "+mapper1.findById(1));
        sqlSession1.commit();

        Grade grade = new Grade();
        grade.setGid(1);
        grade.setGname("99999999");
        mapper1.update(grade);
        sqlSession1.commit();
        System.out.println("mapper1 "+mapper1.findById(1));
        sqlSession1.commit();
        System.out.println("mapper2 "+mapper2.findById(1));

    }

    @Test
    public void fun(){
        SqlSession sqlSession2 = MyBatisCacheUtil.openSession();
        GradeMapper mapper2 = sqlSession2.getMapper(GradeMapper.class);
        System.out.println("mapper2 "+mapper2.findById(1));
        sqlSession2.commit();
    }

    @Test
    public void insert(){
        SqlSession sqlSession2 = MyBatisCacheUtil.openSession2();
        GradeMapper mapper2 = sqlSession2.getMapper(GradeMapper.class);
        Grade grade = new Grade();
        grade.setGname("444444444");
        mapper2.insert(grade);
    }


    @Test
    public void findAllSize(){
        SqlSession sqlSession = MyBatisCacheUtil.openSession();
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);

        SqlSession sqlSession2 = MyBatisCacheUtil.openSession();
        GradeMapper mapper2 = sqlSession2.getMapper(GradeMapper.class);
        ArrayList<Grade> grades = new ArrayList<>();
        Grade byId = mapper.findById(1);
        Grade byId1 = mapper.findById(2);
        Grade byId2 = mapper.findById(3);
        Grade byId3 = mapper.findById(5);
        Collections.addAll(grades,byId,byId1,byId2,byId3);
        System.out.println(grades);
        sqlSession.close();
        ArrayList<Grade> grades2 = new ArrayList<>();
        Grade byIdq = mapper2.findById(1);
        Grade byId1q = mapper2.findById(2);
        Grade byId2q = mapper2.findById(3);
        Grade byId3q = mapper2.findById(5);
        Collections.addAll(grades2,byIdq,byId1q,byId2q,byId3q);
        byId3q.setGname("asd");
        mapper2.update(byId3q);
        System.out.println(grades2);

    }

    @Test
    public void refCache(){
        SqlSession sqlSession1 = MyBatisCacheUtil.openSession();
        SqlSession sqlSession2 = MyBatisCacheUtil.openSession();

        GradeMapper gradeMapper = sqlSession1.getMapper(GradeMapper.class);
        SchoolMapper schoolMapper = sqlSession2.getMapper(SchoolMapper.class);
        System.out.println(gradeMapper.findById(1));
        sqlSession1.commit();
        School school = new School();
        school.setCid(1);
        school.setCname("交大");
        schoolMapper.update(school);
        sqlSession2.commit();
        System.out.println(gradeMapper.findById(1));

    }
}
