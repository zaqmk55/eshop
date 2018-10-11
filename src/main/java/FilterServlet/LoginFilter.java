package FilterServlet;

import dao.CategoryDao;
import daoImp.CategoryDaoImp;
import daoImp.UserDaoimp;
import entity.Category;
import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaohuang on 2018/9/28.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //过滤登陆，若不是从首页进入也可以获得用户信息
        if(request.getSession().getAttribute("user")==null) {
            Cookie[] cookies = request.getCookies();
            String username = this.getCookieByName(cookies, "username");
            String password = this.getCookieByName(cookies, "password");
            if (username != null && password != null) {
                User user = new UserDaoimp().login(username, password);
                if (user == null) {
                    request.getRequestDispatcher("/login.jsp");
                } else {
                    request.getSession().setAttribute("user", user);
                }
            }
        }
        //加上品种列表
        CategoryDao categoryDao = new CategoryDaoImp();
        List<Category> categoryList = categoryDao.queryAll();
        request.getSession().setAttribute("categorylist",categoryList);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public String getCookieByName(Cookie[] cookies,String s){
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(s))
                    return cookie.getValue();
            }
        }
        return null;
    }
}
