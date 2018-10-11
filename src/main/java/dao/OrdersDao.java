package dao;

import entity.Orders;

/**
 * Created by xiaohuang on 2018/9/18.
 */
public interface OrdersDao extends BaseDao<Orders> {
    public void updateANT(String address,String name,String telephone,String oid);

}
