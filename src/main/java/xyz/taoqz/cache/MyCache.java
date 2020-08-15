package xyz.taoqz.cache;

import org.apache.ibatis.cache.Cache;

/**
 * @author :almostTao
 * @date :Created in 2020/8/16 3:40
 */
public class MyCache implements Cache {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object key, Object value) {

    }

    @Override
    public Object getObject(Object key) {
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
