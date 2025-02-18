package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author tanpenggood
 * @since 2025-02-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

