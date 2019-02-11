package com.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * 公用的mapper
 * @author Roger
 *
 * @param <T> 你想要的实体类
 */
@Mapper
public interface PublicMapper<T> {
	
	/**
	 * 	获取所有查询信息
	 *  @param table 表名
	 *  @param columns	字段名
	 *  @return
	 */
	@SelectProvider(type=ProviderSQL.class, method="getAllMes")
	List<T> getAllMessage(String table, String ...columns);
	
	/**
	 * 	获取单个数据
	 * 	@param table 表名
	 * 	@param name 字段名
	 * 	@param value 值
	 * 	@param columns	字段名
	 * 	@return
	 */
	@SelectProvider(type=ProviderSQL.class, method="getOneMes")
	T getOneMessage(String table, String name, @Param(value="value")String value, String ... columns);
	
	/**
	 * 	添加一行数据
	 * 	@param table 表名
	 * 	@param cls	实体类
	 * 	@param t	存储的对象
	 * 	@param keyStrings	字段名
	 * 	@param valueStrings	“nameMap.字段名” 数组
	 * 	@return 成功返回1，失败返回0
	 */
	@InsertProvider(type=ProviderSQL.class, method="addOneMes")
	Integer addOneMessage(String table, @Param(value="nameMap") T t, String[] keyStrings, String[] valueStrings);

	/**
	 * 	动态修改一条数据
	 * 	@param table	表名
	 * 	@param cls	实体类
	 * 	@param t	存储的对象
	 * 	@param keyStrings	字段名
	 * 	@param valueStrings	“nameMap.字段名” 数组
	 * 	@return 成功返回1，失败返回0
	 */
	@UpdateProvider(type=ProviderSQL.class, method="updateOneMes")
	Integer updateOneMessage(String table, @Param(value="nameMap") T t, String[] keyStrings, String[] valueStrings);
	
	/**
	 * 	删除一行数据
	 * 	@param table 表明
	 * 	@param id	id
	 * 	@return	成功返回1，失败返回0
	 */
	@DeleteProvider(type=ProviderSQL.class, method="deleteOneMes")
	Integer deleteOneMessage(String table, @Param(value="id") Integer id);
}
