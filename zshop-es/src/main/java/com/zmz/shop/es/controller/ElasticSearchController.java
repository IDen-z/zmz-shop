package com.zmz.shop.es.controller;

import com.zmz.common.exception.CodeEnum;
import com.zmz.common.exception.RRException;
import com.zmz.common.model.SkuEsModel;
import com.zmz.common.utils.R;
import com.zmz.shop.es.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @Description: ES相关 操作
 * @Author: Zhu Mengze
 * @Date: 2021/12/24 14:44
 */
@RestController
@RequestMapping("/search")
public class ElasticSearchController {

    @Autowired
    private ElasticSearchService elasticSearchService;

    /**
     * 上架商品
     */
    @PostMapping("/product/up")
    public R productUp(@RequestBody List<SkuEsModel> skuEsModelList) {
        try {
            elasticSearchService.productUp(skuEsModelList);
        } catch (Exception e) {
            return R.error(CodeEnum.PRODUCT_UP_EXCEPTION.getCode(), CodeEnum.PRODUCT_UP_EXCEPTION.getMsg());
        }
        return R.ok();
    }


}
