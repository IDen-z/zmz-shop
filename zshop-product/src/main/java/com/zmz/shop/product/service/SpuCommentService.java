package com.zmz.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:49:45
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

