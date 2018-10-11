package myServlet;

import com.alibaba.fastjson.JSON;
import daoImp.CartDaoImp;
import daoImp.ProductDaoImp;
import entity.Cart;
import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaohuang on 2018/9/16.
 */
@WebServlet("/product")
public class ProductServlet extends BaseServlet {
    public void queryByCid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("categorycid");
        List<Product> productList = new ProductDaoImp().queryByCid(cid);
        req.setAttribute("productlist",productList);
        req.getRequestDispatcher("/product_list.jsp").forward(req,resp);
    }

    public void AqueryByCid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        List<Product> productList = new ProductDaoImp().queryByCid(cid);
        resp.setContentType("text/json;charset=gbk");
        resp.getWriter().write(JSON.toJSONString(productList));
    }

    public void queryByPid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        Cookie[] cookies = req.getCookies();
        String s = getCookieByName(cookies,"pids");
        if(s==null) {
            Cookie cookie = new Cookie("pids",pid);
        }
        Product product = new ProductDaoImp().queryByPid(pid);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/product_info.jsp").forward(req,resp);
    }

    public void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String str = getCookieByName(cookies,"JSESSIONID");
        Cookie cookie = new Cookie("JSESSIONID",str);
        cookie.setPath("/");
        cookie.setMaxAge(7*24*3600);
        resp.addCookie(cookie);
        //用当前的jsessionid值创建新的同名jsessionid来替换并设置过期时间
        String pid = req.getParameter("pid");
        int count = Integer.parseInt(req.getParameter("quantity"));
        Map<String,Cart> cartMap = (Map<String,Cart>)req.getSession().getAttribute("cartMap");
        if(cartMap==null){
            cartMap = new HashMap<String,Cart>();
            cartMap.put(pid,new CartDaoImp().queryCartByPid(pid));
            cartMap.get(pid).setCount(count);
            req.getSession().setAttribute("cartMap",cartMap);
        }else{
            if(cartMap.containsKey(pid)){
                cartMap.get(pid).setCount(cartMap.get(pid).getCount()+count);
            }else{
                Cart newcart = new CartDaoImp().queryCartByPid(pid);
                newcart.setCount(count);
                cartMap.put(pid,newcart);
            }
        }
        req.getRequestDispatcher("/cart.jsp").forward(req,resp);
    }

    public void deleteCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String pid = req.getParameter("pid");
        System.out.println(pid);
        HashMap<String,Cart> cartMap = (HashMap<String,Cart>)req.getSession().getAttribute("cartMap");
        if(cartMap!=null){
            cartMap.remove(pid);
        }
        req.getRequestDispatcher("/cart.jsp").forward(req,resp);
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