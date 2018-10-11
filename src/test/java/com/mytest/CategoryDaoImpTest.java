package com.mytest;

import daoImp.CategoryDaoImp;
import entity.Category;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xiaohuang on 2018/10/10.
 */
public class CategoryDaoImpTest {
    @Test
    public void queryAll() throws Exception {
        CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
        List<Category> categoryList = categoryDaoImp.queryAll();
        //预期结果不为空
        assertNotNull(categoryList);
    }

}