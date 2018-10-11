package AdminServlet;

import com.alibaba.fastjson.JSON;
import daoImp.CategoryDaoImp;
import entity.Category;
import myServlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaohuang on 2018/9/29.
 */
@WebServlet("/admin/category")
public class CategoryServlet extends BaseServlet {
    public void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = new CategoryDaoImp().queryAll();
        resp.setContentType("text/json;charset=gbk");
        resp.getWriter().write(JSON.toJSONString(categoryList));
    }

    public void queryList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = new CategoryDaoImp().queryAll();
        req.setAttribute("categoryList",categoryList);
        req.getRequestDispatcher("/admin/category/list.jsp").forward(req,resp);
    }
}
