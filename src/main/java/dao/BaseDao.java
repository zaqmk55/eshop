package dao;

import java.util.List;

/**
 * Created by HanGe on 2018/9/12.
 */
public interface BaseDao<T> {
     void add(T t);
     void delete(String uuid);
     void update(T t);
     T queryById(String id);
     List<T> queryAll();
}
