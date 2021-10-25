package com.zmz.shop.product;

import com.zmz.shop.product.entity.BrandEntity;
import com.zmz.shop.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZshopProductApplicationTests {

    @Autowired
    private BrandService brandService;


    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.err.println("测试代码。。。。保存成功");

    }
    @Test
    void contextLoads2() {
        BrandEntity brandEntity = brandService.getById(1L);
        brandEntity.setDescript("华为品牌");
        brandService.updateById(brandEntity);
        System.err.println("测试代码。。。。保存成功");
    }

}
