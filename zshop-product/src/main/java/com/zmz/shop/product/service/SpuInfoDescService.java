package com.zmz.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:18:10
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

