package com.imooc.controller;

import com.imooc.enums.YesOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author admin
 */
@Api(value = "首页",tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {
    
    final static Logger logger= LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表",notes = "获取首页轮播图列表",httpMethod = "GET")
    @GetMapping("/carousel")
    public IMOOCJSONResult carouse() {
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        return IMOOCJSONResult.ok(list);
    }
    @ApiOperation(value = "获取商品分类（一级分类）",notes = "获取商品分类（一级分类）",httpMethod = "GET")
    @GetMapping("/cats")
    public IMOOCJSONResult cats() {
        List<Category> list = categoryService.queryAllRootLevelCat();
        return IMOOCJSONResult.ok(list);
    }

    @ApiOperation(value = "获取商品子分类",notes = "获取商品子分类",httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public IMOOCJSONResult subCat(
            @ApiParam(name = "rootCatId",value = "一级分类id",required = true)
            @PathVariable Integer rootCatId) {
        if(rootCatId == null){
            return IMOOCJSONResult.errorMsg("分类不存在");
        }
        List<CategoryVO> list = categoryService.getSubCatList(rootCatId);
        return IMOOCJSONResult.ok(list);
    }

    @ApiOperation(value = "获取每个一级分类下的最新6条商品数据",notes = "获取每个一级分类下的最新6条商品数据",httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public IMOOCJSONResult sixNewItems(
            @ApiParam(name = "rootCatId",value = "一级分类id",required = true)
            @PathVariable Integer rootCatId) {
        if(rootCatId == null){
            return IMOOCJSONResult.errorMsg("分类不存在");
        }
        List<NewItemsVO> list = categoryService.getSixNewItemLazy(rootCatId);
        return IMOOCJSONResult.ok(list);
    }
    
}
