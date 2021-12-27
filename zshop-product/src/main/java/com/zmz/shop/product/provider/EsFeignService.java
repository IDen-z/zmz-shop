package com.zmz.shop.product.provider;

import com.zmz.common.model.SkuEsModel;
import com.zmz.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("zshop-es")
public interface EsFeignService {

    @PostMapping("/search/product/up")
    R productUp(@RequestBody List<SkuEsModel> skuEsModelList);


}
