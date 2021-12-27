package com.zmz.shop.product.provider;

import com.zmz.common.utils.R;
import com.zmz.shop.product.vo.SkuHasStockVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("zshop-ware")
public interface WareFeignService {

    @PostMapping(value = "/ware/waresku/hasStock")
    R<List<SkuHasStockVo>> getSkuHasStock(@RequestBody List<Long> skuIds);

}
