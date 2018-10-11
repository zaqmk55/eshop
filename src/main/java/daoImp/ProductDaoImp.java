package daoImp;


import dao.ProductDao;
import entity.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xiaohuang on 2018/9/17.
 */
public class ProductDaoImp implements ProductDao {
    public List queryByCid(String cid) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where cid = ? and pflag = 0";
        List<Product> productList = null;
        try {
            productList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public Product queryByPid(String pid) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pid = ? and pflag = 0";
        Product product = null;
        try {
            product = queryRunner.query(sql, new BeanHandler<Product>(Product.class), pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> queryAll() {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pflag = 0";
        List<Product> productList = null;
        try {
            productList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> queryAll(int startindex, int pagesize) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pflag = 0 limit ?,? ";
        List<Product> pageList = null;
        try {
            pageList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), startindex, pagesize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageList;
    }

    public List<Product> queryAll(String type, String keyword) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product ";
        List<Product> productList = null;
        try {
            if("all".equals(type)){
                sql+="where pname like ? or pdesc like ? and pflag = 0";
                productList=queryRunner.query(sql,new BeanListHandler<Product>(Product.class),"%"+keyword+"%","%"+keyword+"%");
            }else if("pname".equals(type)){
                sql+="where pname like ? and pflag = 0";
                productList=queryRunner.query(sql,new BeanListHandler<Product>(Product.class),"%"+keyword+"%");
            }else if("pdesc".equals(type)){
                sql+="where pdesc like ? and pflag = 0";
                productList=queryRunner.query(sql,new BeanListHandler<Product>(Product.class),"%"+keyword+"%");
            }else if("category".equals(type)){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void add(Product product) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
        try {
            queryRunner.update(sql, product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),
                    product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),
                    product.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(String uuid) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update product set pflag=1 where pid = ?";
        try {
            queryRunner.update(sql,uuid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update product set pname=?,market_price=?,pimage=?,cid=?,pdesc=?,is_hot=?,shop_price=? where pid=?";
        try {
            queryRunner.update(sql,product.getPname(),product.getMarket_price(),product.getPimage(),product.getCid(),
                    product.getPdesc(),product.getIs_hot(),product.getShop_price(),product.getPid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product queryById(String id) {
        return null;
    }
}


