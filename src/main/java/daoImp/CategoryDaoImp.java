package daoImp;

import dao.CategoryDao;
import entity.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xiaohuang on 2018/9/16.
 */
public class CategoryDaoImp implements CategoryDao {

    @Override
    public List queryAll() {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from category where fid=0";
        List<Category> categoryList = null;
        try {
            categoryList = queryRunner.query(sql,new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public void delete(String uuid) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update product set pflag=1 where cid = ?";
        try {
            queryRunner.update(sql,uuid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public Object queryById(String id) {
        return null;
    }
}
