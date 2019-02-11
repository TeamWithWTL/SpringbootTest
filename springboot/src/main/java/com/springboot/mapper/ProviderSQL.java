package com.springboot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 书写动态sql专用
 * 
 * @author Roger
 *
 */
public class ProviderSQL<T> {

	/**
	 * 动态无条件查询数据，可以指定要查询的字段名，以数组来进行传递，或者传递单个的字符串
	 * 
	 * @param table   表名
	 * @param columns 字段名
	 * @return 返回查询的sql语句
	 */
	public String getAllMes(String table, String... columns) {
		return new SQL() {
			{
				if (columns.length != 0) {
					SELECT(columns);
				} else {
					SELECT("*");
				}
				FROM(table);
			}
		}.toString();
	}

	/**
	 * 动态单一条件查询
	 * 
	 * @param table   表名
	 * @param name    字段名
	 * @param value   值
	 * @param columns 字段名
	 * @return 返回查询sql
	 */
	public String getOneMes(String table, String name, @Param(value = "value") String value, String... columns) {
		return new SQL() {
			{
				if (columns.length != 0) {
					SELECT(columns);
				} else {
					SELECT("*");
				}
				FROM(table);
				WHERE(name + "=#{value}");
			}
		}.toString();
	}

	/**
	 * 动态添加一个条数据
	 * 
	 * @param table        表名
	 * @param t            存储对象
	 * @param keyStrings   字段数组
	 * @param valueStrings （nameMap.字段名）数组 防sql注入的注入参数方式
	 * @return
	 */
	public String addOneMes(String table, @Param(value = "nameMap") T t, String[] keyStrings, String[] valueStrings) {
		return new SQL() {
			{
				INSERT_INTO(table);
				for (int i = 0; i < keyStrings.length; i++) {
					VALUES(keyStrings[i], valueStrings[i]);
				}
			}
		}.toString();
	}

	/**
	 * 	通过id动态修改一条数据
	 * @param table	表名
	 * @param t	存储的对象
	 * @param keyStrings	字段名
	 * @param valueStrings	“nameMap.字段名”数组
	 * @return 
	 */
	public String updateOneMes(String table, @Param(value = "nameMap") T t, String[] keyStrings, String[] valueStrings) {
		System.out.println(t);
		return new SQL() {
			{
				UPDATE(table);
				for (int i = 1; i < keyStrings.length; i++) {
					SET(keyStrings[i]+"="+valueStrings[i]);
					}
				WHERE("id="+valueStrings[0]);
			}
		}.toString();
	}

	/**
	 * 通过id删除某条数据
	 * 
	 * @param table 表名
	 * @param id    id
	 * @return 返回sql语句
	 */
	public String deleteOneMes(String table,@Param(value="id") Integer id) {
		return new SQL() {
			{
				DELETE_FROM(table);
				WHERE("id=#{id}");
			}
		}.toString();
	}

}
