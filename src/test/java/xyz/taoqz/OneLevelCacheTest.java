package xyz.taoqz;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.taoqz.dao.TeacherMapper;
import xyz.taoqz.domain.Teacher;
import xyz.taoqz.utils.MyBatisCacheUtil;
import xyz.taoqz.utils.MyBatisUtil;

/**
 * @author :almostTao
 * @date :Created in 2020/8/11 21:02
 */
public class OneLevelCacheTest {

    @Test
    public void demo(){
        TeacherMapper mapper = MyBatisUtil.getMapper(TeacherMapper.class);
        System.out.println(mapper.findById(1));
        mapper.deleteById(100);
        System.out.println(mapper.findById(1));
    }

    public static void main(String[] args) {
        SqlSession sqlSession1= MyBatisCacheUtil.openSession();
        SqlSession sqlSession2 = MyBatisCacheUtil.openSession();
        System.out.println(sqlSession1);
        System.out.println(sqlSession2);

        TeacherMapper mapper1 = sqlSession1.getMapper(TeacherMapper.class);
        TeacherMapper mapper2 = sqlSession2.getMapper(TeacherMapper.class);

        System.out.println("mapper1 select"+mapper1.findById(1));
        System.out.println("mapper1 select"+mapper1.findById(1));
        Teacher teacher = new Teacher(1, "new 111");
        System.out.println("mapper2 update"+mapper2.update(teacher));

        System.out.println("mapper1 select"+mapper1.findById(1));
        System.out.println("mapper2 select"+mapper2.findById(1));
    }
    @Test
    public void demo2(){
        SqlSession sqlSession1= MyBatisCacheUtil.openSession();
        System.out.println(sqlSession1);

        TeacherMapper mapper1 = sqlSession1.getMapper(TeacherMapper.class);

        System.out.println("mapper1 select"+mapper1.findById(1));
        sqlSession1.clearCache();
        System.out.println("mapper1 select"+mapper1.findById(1));
    }

}
