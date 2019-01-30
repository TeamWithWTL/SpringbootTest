package com.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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
	 *  @return
	 */
	@SelectProvider(type=ProviderSQL.class, method="getAllMes")
	List<T> getAllMessage(String table);
	
	/**
	 * 获取单个数据
	 * @param table 表明
	 * @param name 字段名
	 * @param value 值
	 * @return
	 */
	@SelectProvider(type=ProviderSQL.class, method="getOneMes")
	T getOneMessage(String table, String name, String value);
}
