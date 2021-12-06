package com.zmz.shop.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zmz.common.utils.PageUtils;
import com.zmz.common.utils.Query;

import com.zmz.shop.product.dao.CategoryDao;
import com.zmz.shop.product.entity.CategoryEntity;
import com.zmz.shop.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> queryListTree() {
        // 查出所有的分类列表
        List<CategoryEntity> entityList = baseMapper.selectList(new QueryWrapper<>());

        // 包装分类实例为父子节点结构

        // 过滤所有的顶级节点
        List<CategoryEntity> collect = entityList.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == 0;
        }).map(categoryEntity -> {
            categoryEntity.setChildrenList(getChildren(categoryEntity, entityList));
            return categoryEntity;
        }).sorted(Comparator.comparing(CategoryEntity::getSort)).collect(Collectors.toList());

        return collect;
    }

    @Override
    public void deleteByCatIds(List<Long> ids) {
        // TODO 检查是否cate是否可删除
        baseMapper.deleteBatchIds(ids);
    }

    /**
     * 递归查出当前节点下的每个子节点
     */
    private List<CategoryEntity> getChildren(CategoryEntity entity, List<CategoryEntity> entityList) {
        List<CategoryEntity> res = entityList.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(entity.getCatId());
        }).map(categoryEntity -> {
            categoryEntity.setChildrenList(getChildren(categoryEntity, entityList));
            return categoryEntity;
        }).sorted(Comparator.comparing(CategoryEntity::getSort)).collect(Collectors.toList());
        return res;
    }

}