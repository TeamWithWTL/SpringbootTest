package com.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * 公用的mapper
 * @author Roger
 *
 * @param <T> 你想要的实体类
 */
@Mapper
public interface PublicMapper<T> {
	
	/**
	 *  获取所有查询信息
	 *  @param table 表名
	 *  @return
	 */
	@SelectProvider(type=ProviderSQL.class, method="getAllMes")
	List<T> getAllMessage(String table);
	
	/**
	 * 获取单个数据
	 * @param table 表名
	 * @param name 字段名
	 * @param value 值
	 * @return
	 */
	@SelectProvider(type=ProviderSQL.class, method="getOneMes")
	T getOneMessage(String table, String name, @Param(value="value")String value);
	
	/**
	 * 添加一行数据
	 * @param table 表名
	 * @param cls	实体类
	 * @param obj	存储对象
	 */
	@SelectProvider(type=ProviderSQL.class, method="addOneMes")
	void addOneMessage(String table, Class cls, Object obj);
}
