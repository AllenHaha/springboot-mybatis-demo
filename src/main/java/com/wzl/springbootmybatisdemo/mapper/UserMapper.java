package com.wzl.springbootmybatisdemo.mapper;

import com.wzl.springbootmybatisdemo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserById(Integer id);
}
