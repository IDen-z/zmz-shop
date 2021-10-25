package com.zmz.shop.member.dao;

import com.zmz.shop.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 20:05:22
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
