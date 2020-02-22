package com.leyou.goods.controller;

import com.leyou.goods.service.IGoodsHtmlService;
import com.leyou.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/item")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IGoodsHtmlService goodsHtmlService;
    /**
     * 跳转到商品详情页
     * @param model
     * @param id
     * @return
     */
    @GetMapping("{id}.html")
    public String toItemPage(Model model, @PathVariable("id")Long id){
        // 加载所需的数据
        Map<String, Object> modelMap = this.goodsService.loadModel(id);
        // 把数据放入数据模型
        model.addAllAttributes(modelMap);
        // 页面静态化
        this.goodsHtmlService.asyncExcute(id);

        return "item";
    }
}
