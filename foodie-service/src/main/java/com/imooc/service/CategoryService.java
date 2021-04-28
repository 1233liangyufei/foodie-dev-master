package com.imooc.service;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有一级分类
     * @return
     */
    public List<Category> queryAllRootLevelCat( );

    /**
     * 根据一级分类id查询子分类
     * @return
     */
    public List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 查询每个商品一级分类下最新的6条数据
     * @return
     */
    public List<NewItemsVO> getSixNewItemLazy(Integer rootCatId);

}
