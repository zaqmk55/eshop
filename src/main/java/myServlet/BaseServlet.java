package myServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by xiaohuang on 2018/9/17.
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        String realMethod = req.getParameter("method");
        //user?method=exit
        try {
            Method m = this.getClass().getDeclaredMethod(realMethod,HttpServletRequest.class,HttpServletResponse.class);
            m.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}