package AdminServlet;

import daoImp.AdminUserDaoImp;
import entity.AdminUser;
import myServlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaohuang on 2018/10/9.
 */
@WebServlet("/admin/user")
public class UserServlet extends BaseServlet {
    public void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AdminUser> adminUserList = new AdminUserDaoImp().queryAll();
        req.setAttribute("adminUserList",adminUserList);
        req.getRequestDispatcher("/admin/adminuser/list.jsp").forward(req,resp);
    }
}
