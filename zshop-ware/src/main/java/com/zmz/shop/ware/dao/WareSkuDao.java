package com.zmz.shop.ware.dao;

import com.zmz.shop.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * εεεΊε­
 * 
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-11-02 15:37:30
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {

    Long getSkuStock(Long skuId);
}
