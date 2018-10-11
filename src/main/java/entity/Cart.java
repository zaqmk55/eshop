package entity;

/**
 * Created by xiaohuang on 2018/9/18.
 */
public class Cart {
    private String pid;
    private String pname;
    private String pimage;
    private Double shop_price;
    private int count;

    @Override
    public String toString() {
        return "Cart{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", pimage='" + pimage + '\'' +
                ", shop_price=" + shop_price +
                ", count=" + count +
                '}';
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
