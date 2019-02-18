package com.provider.mapper;

import com.provider.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by yan on 2019/2/15.
 */
@Mapper
public interface UserMapper {
    User getUser(int id);
}
