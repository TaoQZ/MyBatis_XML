package xyz.taoqz;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.taoqz.dao.GradeMapper;
import xyz.taoqz.domain.Grade;
import xyz.taoqz.domain.Student;
import xyz.taoqz.utils.MyBatisCacheUtil;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author :almostTao
 * @date :Created in 2020/8/13 21:51
 */
public class OtherTest {


    public static void main(String[] args) {
        String a = "123";
        System.out.println("123" == a);
        Student student = new Student();
        student.setSname("通话");

        Student student1 = new Student();
        student1.setSname("通话");
        Set<Student> students = new HashSet<>();
        students.add(student);
        students.add(student1);
        System.out.println(students);
        System.out.println(student.hashCode() == student1.hashCode());
        System.out.println(student.hashCode());
        System.out.println("通话".hashCode());
        System.out.println("通话".hashCode() == "重地".hashCode());
    }

    @Test
    public void demo(){

        SqlSession sqlSession = MyBatisCacheUtil.openSession();
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
        Grade grade = new Grade();
        grade.setGname("taoqz");
        mapper.insert(grade);

    }

    private Object eldestKey;

    @Test
    public void demo4(){
        int size = 3;
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>(5);

        map  = new LinkedHashMap<Object, Object>(size, .75F, true) {
            private static final long serialVersionUID = 4267176411845948333L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
                boolean tooBig = size() > size;
                if (tooBig) {
                    eldestKey = eldest.getKey();
                }
                return tooBig;
            }
        };

        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        System.out.println(map);
    }



}
