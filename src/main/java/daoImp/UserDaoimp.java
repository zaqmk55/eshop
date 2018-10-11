package daoImp;

import dao.UserDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HanGe on 2018/9/12.
 */
public class UserDaoimp implements UserDao {
    @Override
    public boolean checkName(String username){
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=?";
        User user =null;
        try {
            user = queryRunner.query(sql,new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void add(User user) {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            queryRunner.update(sql, user.getUid(), user.getUsername(),
                    user.getPassword(), user.getName(), user.getEmail(),
                    user.getTelephone(), user.getBirthday(), user.getSex(),
                    user.getState(), user.getCode());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User login(String name, String password) {
        User user = new User();
        Connection con = DataSourceUtils.getConnection();
        String sql = "SELECT * FROM user WHERE username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String pw = rs.getString("password");
                if (pw.equals(password)) {
                    user.setUid(rs.getString(1));
                    user.setUsername(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setName(rs.getString(4));
                    user.setEmail(rs.getString(5));
                    user.setTelephone(rs.getString(6));
                    user.setBirthday(rs.getDate(7));
                    user.setSex(rs.getString(8));
                    user.setState(rs.getLong(9));
                    user.setCode(rs.getString(10));
                } else {
                    System.out.println("fail to login");
                }
            } else {
                System.out.println("this user doesn't exist");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("error");
        }
        return user;
    }
    @Override
    public void delete(String uuid) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User queryById(String id) {
        return null;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }


}