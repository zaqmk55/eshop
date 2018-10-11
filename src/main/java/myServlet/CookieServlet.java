package myServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by HanGe on 2018/9/13.
 */
@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("name","xiaohuang");
        Cookie cookie1 = new Cookie("sex","ÄÐ");
        Cookie cookie2 = new Cookie("age","20");
        cookie.setMaxAge(60*3);
        cookie.setPath("/");
        cookie1.setMaxAge(60*3);
        cookie1.setPath("/");
        cookie2.setMaxAge(60*3);
        cookie2.setPath("/");
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        System.out.println("=====");
        resp.addCookie(cookie2);
        resp.sendRedirect("/test.jsp");
    }
}
