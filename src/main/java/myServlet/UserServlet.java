package myServlet;

import dao.UserDao;
import daoImp.UserDaoimp;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
/**
 * Created by HanGe on 2018/9/12.
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie cookie = new Cookie("username",req.getParameter("username"));
        cookie.setPath("/");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        req.getSession().removeAttribute("user");
        resp.sendRedirect("/index.jsp");
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDao ud = new UserDaoimp();
        String r =req.getParameter("rememberme");
        String a=req.getParameter("autologin");
        Cookie cookie = new Cookie("username",req.getParameter("username"));
        Cookie cookie1 = new Cookie("password",req.getParameter("password"));
        cookie.setPath("/");
        if("1".equals(r)) {//是否记住密码
            cookie.setMaxAge(60*60);
            resp.addCookie(cookie);
        }
        if("1".equals(a)){//是否自动登陆
            cookie.setMaxAge(60*60);
            cookie1.setMaxAge(60*60);
            resp.addCookie(cookie);
            resp.addCookie(cookie1);
        }
        req.getSession().setAttribute("user", ud.login(req.getParameter("username"), req.getParameter("password")));
        resp.sendRedirect("/index.jsp");
    }

    public void register(HttpServletRequest req,HttpServletResponse resp) {
        UserDao ud = new UserDaoimp();
        Map<String, String[]> properties = req.getParameterMap();
        User user = new User();
        try {
            user.setUid(UUID.randomUUID().toString());
            BeanUtils.populate(user, properties);
            ud = new UserDaoimp();
            ud.add(user);
            resp.sendRedirect("/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("运行出错");
        }
    }

    public void checkName(HttpServletRequest req,HttpServletResponse resp) {
        UserDao ud = new UserDaoimp();
        String username = req.getParameter("username");
        try {
            if(ud.checkName(username)) {
                resp.getWriter().write("yes");
            }else {
                resp.getWriter().write("no");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}