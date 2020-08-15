package xyz.taoqz.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author :almostTao
 * @date :Created in 2020/8/11 21:15
 */
public class MyBatisCacheUtil {

    //成员位置定义静态的  session工厂与ThreadLocal
    private static SqlSessionFactory factory;

    static {
        //资源
        //获取配置文件中的内容，转为io流对象
        try {
            InputStream is = null;
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //工厂
            //创建工厂构造者的对象
            SqlSessionFactoryBuilder builer = new SqlSessionFactoryBuilder();
            //使用工厂构造这创建工程，传入io形式的配置信息
            factory = builer.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        return factory.openSession(true);
    }

    public static SqlSession openSession2() {
        return factory.openSession();
    }
}
