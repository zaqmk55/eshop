package myServlet;

import daoImp.OrderItemDaoImp;
import daoImp.OrdersDaoImp;
import entity.*;
import utils.PaymentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by xiaohuang on 2018/9/18.
 */
@WebServlet("/order")
public class OrderServlet extends BaseServlet {
    public void submitorder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        User user = (User) req.getSession().getAttribute("user");
        if (user==null){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        Map<String,Cart> cartMap = (Map<String, Cart>) req.getSession().getAttribute("cartMap");
        List<Orderitem> orderitemList = new ArrayList<>();
        Orders orders = new Orders();
        orders.setOid(UUID.randomUUID().toString());
        orders.setOrdertime(new Date());
        orders.setState(0);
        orders.setUid(user.getUid());
        orders.setName(user.getUsername());
        Double total = 0.0;
        for(Map.Entry<String,Cart> m : cartMap.entrySet()){
            Orderitem orderitem = new Orderitem();
            orderitem.setItemid(UUID.randomUUID().toString());
            orderitem.setCount(m.getValue().getCount());
            orderitem.setOid(orders.getOid());
            orderitem.setSubtotal(orderitem.getCount()*m.getValue().getShop_price());
            orderitem.setPid(m.getValue().getPid());
            orderitemList.add(orderitem);
            total+=orderitem.getSubtotal();
        }
        orders.setTotal(total);
        new OrdersDaoImp().add(orders);
        for(Orderitem orderitem:orderitemList) {
            new OrderItemDaoImp().add(orderitem);
        }
        req.setAttribute("total",total);
        req.setAttribute("oid",orders.getOid());
        req.getRequestDispatcher("/order_info.jsp").forward(req,resp);

    }

    public void confirmorder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String telephone = req.getParameter("telephone");
        String oid = req.getParameter("oid");
        new OrdersDaoImp().updateANT(name,address,telephone,oid);

        // 获得 支付必须基本数据
        String money = req.getParameter("total");
        // 银行
        String pd_FrpId = req.getParameter("pd_FrpId");
        // 发给支付公司需要哪些数据
        String p0_Cmd = "Buy";
        String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString(
                "p1_MerId");
        String p2_Order = oid;
        String p3_Amt = money;
        String p4_Cur = "CNY";
        String p5_Pid = "test";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        // 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
        // 第三方支付可以访问网址
        String p8_Url = "/callback";
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        // 加密hmac 需要密钥
        String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
                "keyValue");
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
                p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
                pd_FrpId, pr_NeedResponse, keyValue);
        // 生成url --- url?
        req.setAttribute("pd_FrpId", pd_FrpId);
        req.setAttribute("p0_Cmd", p0_Cmd);
        req.setAttribute("p1_MerId", p1_MerId);
        req.setAttribute("p2_Order", p2_Order);
        req.setAttribute("p3_Amt", p3_Amt);
        req.setAttribute("p4_Cur", p4_Cur);
        req.setAttribute("p5_Pid", p5_Pid);
        req.setAttribute("p6_Pcat", p6_Pcat);
        req.setAttribute("p7_Pdesc", p7_Pdesc);
        req.setAttribute("p8_Url", p8_Url);
        req.setAttribute("p9_SAF", p9_SAF);
        req.setAttribute("pa_MP", pa_MP);
        req.setAttribute("pr_NeedResponse", pr_NeedResponse);
        req.setAttribute("hmac", hmac);

        req.getRequestDispatcher("/confirm.jsp").forward(req, resp);
    }

    public void myOrderList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        User user = (User) req.getSession().getAttribute("user");
        if(user==null){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        //订单编号、商品图片、商品、价格、数量、小计、下单时间、订单总价
        List<MyOrderList> ordersList = new OrdersDaoImp().getMyOrderList(user.getUid());
        //订单号表
        List<String> oidList = new OrdersDaoImp().getOidList(user.getUid());
        //key:oid  value:MyOrderList
        Map<String,List<MyOrderList>> ordermap = new HashMap<>();

        for(String s : oidList){
            List<MyOrderList> myOrderList1 = new ArrayList<>();
            for(MyOrderList myOrderList : ordersList){
                if(myOrderList.getOid().equals(s)){
                    myOrderList1.add(myOrderList);
                }
            }
            ordermap.put(s,myOrderList1);
        }
        for(Map.Entry<String,List<MyOrderList>> map :ordermap.entrySet()){
            System.out.println("=========");
            System.out.println(map.getKey());
            for(MyOrderList myOrderList : map.getValue()){
                System.out.println(myOrderList.getPname());
                System.out.println(myOrderList.getSubtotal());
            }
        }

        req.getSession().setAttribute("MyOrderListMap",ordermap);
        req.getRequestDispatcher("/order_list.jsp").forward(req,resp);
    }
}