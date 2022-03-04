package com.zj.mapper;

import com.zj.data.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.websocket.server.PathParam;

@Mapper
public interface UserMapper {

        @Select("select * from user where login = #{loginName}")
        User  findUserByName(@PathParam("loginName") String loginName);
}
