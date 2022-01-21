package com.zmz.shop.product;

import com.zmz.shop.product.entity.BrandEntity;
import com.zmz.shop.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZshopProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.err.println("测试代码。。。。保存成功");

    }

    @Autowired
    RedissonClient redissonClient;

    /**
     * 测试redisson方法
     */
    @Test
    public void redissonTest() {
        System.err.println(redissonClient);
    }


    @Test
    public void redisTest() {

        /**
         *
         * 这个不是redis策略问题 redisTemplate.setValueSerializer(jackson2JsonRedisSerializer()); 完全OK
         * 经测试：redisTemplate.opsForValue().set("aa",UpmsConstant.IS_VAILD_YES,UpmsConstant.REDIS_TIME_OUT_3MINUTES); OK
         * redisTemplate.opsForValue().set(redisKeySb.toString(),UpmsConstant.IS_VAILD_YES); OK
         * redisTemplate.opsForValue().set(redisKeySb.toString(),"aa",UpmsConstant.REDIS_TIME_OUT_3MINUTES); 会引发value双引号问题
         * 定位了好久 一直纠结在策略上和boot版本的问题
         * 回复9 月前
         *
         * 方案二
         * //序列号key value
         *         redisTemplate.setKeySerializer(new StringRedisSerializer());
         *         redisTemplate.setValueSerializer(new StringRedisSerializer());
         *         redisTemplate.setHashKeySerializer(new StringRedisSerializer());
         *         redisTemplate.setHashValueSerializer(new StringRedisSerializer());
         *
         *         全部选用 string的序列化方式
         *
         *
         *
         */
        String a ="hello";
        String b ="k1";

        redisTemplate.opsForValue().set(b, a, 30L, TimeUnit.MINUTES);
        System.err.println(redisTemplate.opsForValue().get("k1"));
    }

}
