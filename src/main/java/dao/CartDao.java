package dao;

import entity.Cart;

/**
 * Created by xiaohuang on 2018/9/18.
 */
public interface CartDao extends BaseDao {
    public Cart queryCartByPid(String pid) ;

}
