package daoImp;

import dao.CartDao;
import entity.Cart;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xiaohuang on 2018/9/18.
 */
public class CartDaoImp implements CartDao {
    @Override
    public Cart queryCartByPid(String pid) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pid = ?";
        Cart cart = null;
        try {
            cart = queryRunner.query(sql,new BeanHandler<Cart>(Cart.class),pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public Object queryById(String id) {
        return null;
    }

    @Override
    public List queryAll() {
        return null;
    }


}
