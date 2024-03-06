package com.yupi.wlsdbackend.mapper;

import com.yupi.wlsdbackend.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 95788
 * @description 针对表【user(用户)】的数据库操作Mapper
 * @createDate 2024-01-31 11:56:30
 * @Entity com.yupi.wlsdbackend.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




