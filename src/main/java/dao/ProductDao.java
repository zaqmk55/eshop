package dao;

import entity.Product;

import java.util.List;

/**
 * Created by xiaohuang on 2018/9/17.
 */
public interface ProductDao extends BaseDao<Product> {
    List queryByCid(String s);
    Product queryByPid(String s);
}
