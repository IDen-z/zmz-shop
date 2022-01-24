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

        // 一般可以使用tryLock方法 ，指定一下获取锁的时间  如果大于那段时间 那么就放弃获取锁

        // 加锁成功 执行业务代码
        try {
            System.err.println("加锁成功 执行业务代码" + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // redisson解决了两个问题
            // 1、 锁的自动续期，redisson会根据看门狗机制判断业务代码是否执行完毕，如果在一定时间内没有执行
            //     完毕，redisson会自动为同一把锁进行续期。
            // 2、 加锁的业务只要完成，就不会跟给前锁续期，即使unlock方法 因为某些原因未被执行，所也会因过期时间而失效。

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
