package com.zmz.shop.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zmz.shop.product.entity.AttrEntity;
import com.zmz.shop.product.service.AttrService;
import com.zmz.common.utils.PageUtils;
import com.zmz.common.utils.R;


/**
 * 商品属性
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:49:45
 */
@RestController
@RequestMapping("/product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 测试redisson加锁
     */
    @GetMapping("/redisson")
    public String redis() {
        RLock lock = redissonClient.getLock("lock");
        lock.lock();
        // 加锁成功 执行业务代码
        try {
            System.err.println("加锁成功 执行业务代码" + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.err.println("释放锁" + Thread.currentThread().getName());
            lock.unlock();
        }
        return "success";
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId) {
        AttrEntity attr = attrService.getById(attrId);

        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrEntity attr) {
        attrService.save(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrEntity attr) {
        attrService.updateById(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds) {
        attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
