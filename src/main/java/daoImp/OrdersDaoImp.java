package daoImp;

import dao.OrdersDao;
import entity.MyOrderList;
import entity.Orders;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaohuang on 2018/9/18.
 */
public class OrdersDaoImp implements OrdersDao {
    @Override
    public void add(Orders orders) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "INSERT INTO orders VALUES (?,?,?,?,?,?,?,?)";
        try {
            queryRunner.update(sql, orders.getOid(),orders.getOrdertime(),orders.getTotal(),orders.getState(),
                    orders.getAddress(),orders.getName(),orders.getTelephone(),orders.getUid());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateANT(String address,String name,String telephone,String oid) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update orders set address=?,name=?,telephone=? where oid = ?";
        try {
            queryRunner.update(sql,address,name,telephone,oid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List queryByUid(String uid) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from orders where uid = ?";
        List<Orders> ordersList = null;
        try {
            ordersList = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    public List<MyOrderList> getMyOrderList(String uid){
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select orders.oid,orders.ordertime,orders.total, product.pimage,product.pname,product.shop_price,orderitem.count,orderitem.subtotal from orders,orderitem,product WHERE orders.oid=orderitem.oid AND orderitem.pid=product.pid AND orders.uid = ?;";
        List<MyOrderList> myOrderList = null;
        try {
            myOrderList = queryRunner.query(sql, new BeanListHandler<MyOrderList>(MyOrderList.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myOrderList;
    }

    public List<String> getOidList(String uid){
        Connection con = DataSourceUtils.getConnection();
        String sql = "select oid from orders where uid = ?";
        List<String> oidList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,uid);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                oidList.add(rs.getString("oid"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return oidList;
    }

    @Override
    public Orders queryById(String id) {
        return null;
    }

    @Override
    public List<Orders> queryAll() {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public void update(Orders orders) {
    }
}
