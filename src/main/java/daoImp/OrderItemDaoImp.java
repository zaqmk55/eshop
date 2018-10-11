package daoImp;

import dao.OrderItemDao;
import entity.Orderitem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.util.List;
import java.sql.SQLException;
/**
 * Created by xiaohuang on 2018/9/18.
 */
public class OrderItemDaoImp implements OrderItemDao {
    @Override
    public void add(Orderitem orderitem) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "INSERT INTO orderitem VALUES (?,?,?,?,?)";
        try {
            queryRunner.update(sql,orderitem.getItemid(),orderitem.getCount(),orderitem.getSubtotal(),orderitem.getPid(),orderitem.getOid());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public void update(Orderitem orderitem) {

    }

    @Override
    public Orderitem queryById(String id) {
        return null;
    }

    @Override
    public List<Orderitem> queryAll() {
        return null;
    }

    public List<Orderitem> queryByOid(String oid) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from orderitem where oid = ?";
        List<Orderitem> orderitemList = null;
        try {
            orderitemList = queryRunner.query(sql, new BeanListHandler<Orderitem>(Orderitem.class),oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderitemList;
    }
}
