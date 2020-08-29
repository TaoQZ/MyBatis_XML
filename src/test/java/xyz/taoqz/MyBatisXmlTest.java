package xyz.taoqz;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;
import xyz.taoqz.dao.TeacherMapper;
import xyz.taoqz.domain.Student;
import xyz.taoqz.domain.Teacher;
import xyz.taoqz.utils.MyBatisUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author :almostTao
 * @date :Created in 2020/8/11 7:17
 */
public class MyBatisXmlTest {

    /**
     * 测试获取连接
     */
    @Test
    public void testConnection(){
//        MyBatisUtil.getMapper();
        Connection connection = MyBatisUtil.openSession().getConnection();
        System.out.println(connection);
    }
    SqlSession sqlSession = MyBatisUtil.openSession();

    @Test
    public void insert(){
        Student student = new Student();
        student.setSex("女");
        student.setSname("赵四");
        student.setGid(2);
//        sqlSession.insert("xyz.taoqz.domain.Student.insertCondition",student);
        try {
            int insert = sqlSession.insert("studentSpace.insertCondition", student);
            System.out.println(insert);
            System.out.println(student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    @Test
    public void insert2(){
        Student student = new Student();
        student.setSex("女");
        student.setSname("万茜");
        student.setGid(2);
        int insert = sqlSession.insert("studentSpace.insertStudent", student);
        System.out.println(student);
        System.out.println(insert);
        sqlSession.commit();
    }

    public void findByPage(){
        HashMap<String, Integer> pageMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int pageNum = scanner.nextInt();
        int pageSize = scanner.nextInt();
        pageNum = (pageNum - 1) * pageSize;
        pageMap.put("pageNum",pageNum);
        pageMap.put("pageSize",pageSize);
        List<Student> students = sqlSession.selectList("studentSpace.findByPage", pageMap);
        System.out.println(students);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update(){
        Student student = new Student();
        student.setSid(1);
        student.setSname("update");
        sqlSession.update("studentSpace.updateCondition",student);
        sqlSession.commit();
    }

    @Test
    public void findByCondotion(){
        HashMap<String, String> conMap = new HashMap<>();
        conMap.put("sname","王五");
//        List<Student> students = sqlSession.selectList("studentSpace.findByCondotion", conMap);
        List<Student> students = sqlSession.selectList("xyz.taoqz.domain.Student.findByCondotion", conMap);
        System.out.println(students.get(0).getGrade());
        sqlSession.commit();
    }

    @Test
    public void findByIds(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        List<Student> students = sqlSession.selectList("xyz.taoqz.domain.Student.findByIds", integers);
        System.out.println(students);
        sqlSession.commit();
    }

    @Test
    public void findAll(){
//        List<Student> students = sqlSession.selectList("studentSpace.findAll");
        List<Student> students = sqlSession.selectList("xyz.taoqz.domain.Student.findAll");
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.commit();
    }

    /**
     * 测试延迟加载
     */
    @Test
    public void findAllMapper(){
        TeacherMapper mapper = MyBatisUtil.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.findAll();
        for (Teacher teacher : teachers) {
//            System.out.println(teacher.getStudents());
            System.out.println(teacher);
        }
        System.out.println(teachers.get(0).getTname()+"======="+teachers.get(0).getStudents());
//        System.out.println(teachers.get(0).getClass());

    }

    @Test
    public void demo(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        List<Teacher> teachers = sqlSession.selectList("xyz.taoqz.dao.TeacherMapper.findAll");
        System.out.println(teachers);
        List<Teacher> teachers2 = sqlSession.selectList("xyz.taoqz.dao.TeacherMapper.findAll");

    }


    public static void main(String[] args) {
        new MyBatisXmlTest().findByPage();
    }


    @After
    public void close(){
        sqlSession.close();
    }

}
