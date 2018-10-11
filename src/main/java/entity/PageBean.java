package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaohuang on 2018/9/29.
 */
public class PageBean {
    private int currentPage;
    private int totalPage;
    private int totalRecord;
    private int prePage;
    private int nextPage;
    private int startIndex;
    private int pageSize=9;
    private List<Product> plist=new ArrayList<>();
    public PageBean(int currentPage,int totalRecord){
        this.currentPage=currentPage;
        this.totalPage=(totalRecord/pageSize)+1;
        this.totalRecord=totalRecord;
        this.prePage=currentPage-1>=1?currentPage-1:1;
        this.nextPage=currentPage+1>=totalPage?totalPage:currentPage+1;
        this.startIndex=(currentPage-1)*pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Product> getPlist() {
        return plist;
    }

    public void setPlist(List<Product> plist) {
        this.plist = plist;
    }
}
