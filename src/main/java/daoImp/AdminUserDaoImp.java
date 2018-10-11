package daoImp;

import dao.AdminUserDao;
import entity.AdminUser;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xiaohuang on 2018/10/9.
 */
public class AdminUserDaoImp implements AdminUserDao {
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
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from adminUser";
        List<AdminUser> adminUserList = null;
        try {
            adminUserList = queryRunner.query(sql, new BeanListHandler<AdminUser>(AdminUser.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminUserList;
    }
}
