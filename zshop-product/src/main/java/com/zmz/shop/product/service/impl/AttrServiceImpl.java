package com.zmz.shop.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zmz.common.utils.PageUtils;
import com.zmz.common.utils.Query;

import com.zmz.shop.product.dao.AttrDao;
import com.zmz.shop.product.entity.AttrEntity;
import com.zmz.shop.product.service.AttrService;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 在指定的所有属性集合里面，挑出检索属性
     */
    @Override
    public List<Long> selectSearchAttrs(List<Long> attrIds) {
        // select * from 'pms_attr' where attr_id in (attrIds) and search_type =1
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper();
        queryWrapper.in("attr_id",attrIds);
        queryWrapper.eq("search_type",1);
        List<AttrEntity> attrEntityList = baseMapper.selectList(queryWrapper);
        return attrEntityList.stream().map(AttrEntity::getAttrId).collect(Collectors.toList());
    }

}