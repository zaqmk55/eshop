package AdminServlet;
import myServlet.BaseServlet;
import daoImp.ProductDaoImp;
import entity.PageBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import entity.Product;

/**
 * Created by xiaohuang on 2018/9/29.
 */
@WebServlet("/admin/product")
public class ProductServlet extends BaseServlet {
    public void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentpage = Integer.parseInt(req.getParameter("currentpage"));
        int totalrecord = new ProductDaoImp().queryAll().size();
        PageBean pageBean = new PageBean(currentpage, totalrecord);
        pageBean.setPlist(new ProductDaoImp().queryAll(pageBean.getStartIndex(), pageBean.getPageSize()));
        req.setAttribute("pageBean", pageBean);
        req.getRequestDispatcher("/admin/product/list.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String currentpage = req.getParameter("currentpage");
        new ProductDaoImp().delete(pid);
        req.getRequestDispatcher("/admin/product?method=queryAll&currentpage="+currentpage).forward(req, resp);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentpage = req.getParameter("currentpage");
        Product product = new Product();
        product.setPid(req.getParameter("pid"));
        product.setPname(req.getParameter("pname"));
        product.setIs_hot(Long.valueOf(req.getParameter("is_hot")));
        product.setMarket_price(Double.valueOf(req.getParameter("market_price")));
        product.setShop_price(Double.valueOf(req.getParameter("shop_price")));
        product.setPimage(req.getParameter("pimage"));
        product.setCid(req.getParameter("categorySecond.csid"));
        product.setPdesc(req.getParameter("pdesc"));
        new ProductDaoImp().update(product);
        req.getRequestDispatcher("/admin/product?method=queryAll&currentpage="+currentpage).forward(req, resp);
    }

    public void deliverPid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String currentpage = req.getParameter("currentpage");
        Product product=new ProductDaoImp().queryByPid(pid);
        req.setAttribute("pid",pid);
        req.setAttribute("currentpage",currentpage);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/admin/product/edit.jsp").forward(req,resp);
    }

    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String keyword = req.getParameter("keyword");
        List<Product> productList = new ProductDaoImp().queryAll(type,keyword);
        for(Product p:productList){
            System.out.println(p);
        }
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/admin/product/searchList.jsp").forward(req, resp);
    }

}
