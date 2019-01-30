package com.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.springboot.entity.User;

/**
 * user实体类的相关数据库操作，继承公用mapper，只写复杂查询
 * @author Roger
 *
 */
@Mapper
public interface UserMapper extends PublicMapper<User>{
	
}
