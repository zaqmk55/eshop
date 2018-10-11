package dao;

import entity.User;

/**
 * Created by HanGe on 2018/9/12.
 */
public interface UserDao extends BaseDao<User> {
    public User login(String name,String password);
    public boolean checkName(String username);
}
