package xyz.taoqz;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.taoqz.dao.SchoolMapper;
import xyz.taoqz.utils.MyBatisCacheUtil;

/**
 * @author :almostTao
 * @date :Created in 2020/8/16 3:37
 */
public class EhcacheCacheTest {

    @Test
    public void demo(){
        SqlSession sqlSession2 = MyBatisCacheUtil.openSession();
        SchoolMapper mapper2 = sqlSession2.getMapper(SchoolMapper.class);
        System.out.println("mapper2 "+mapper2.findAll());
    }
}
