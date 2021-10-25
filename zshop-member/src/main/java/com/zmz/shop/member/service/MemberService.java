package com.zmz.shop.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 20:05:22
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

