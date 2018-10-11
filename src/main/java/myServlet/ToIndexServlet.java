package myServlet;

import dao.CategoryDao;
import daoImp.CategoryDaoImp;
import entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaohuang on 2018/9/16.
 */
@WebServlet("/toindex")
public class ToIndexServlet extends BaseServlet {
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao categoryDao = new CategoryDaoImp();
        List<Category> categoryList = categoryDao.queryAll();
        request.getSession().setAttribute("categorylist",categoryList);

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }


}
