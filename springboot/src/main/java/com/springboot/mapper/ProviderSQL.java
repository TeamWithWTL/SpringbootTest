package com.springboot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 书写动态sql专用
 * 
 * @author Roger
 *
 */
public class ProviderSQL {

	/**
	 * 动态查询某表的全部数据
	 * 
	 * @param table 表名
	 * @return
	 */
	public String getAllMes(String table) {
		// return "select * from " + table;
		return new SQL() {
			{
				SELECT(" * ");
				FROM(table);
			}
		}.toString();
	}

	/**
	 * 动态查询一条指定参数的数据
	 * 
	 * @param table 表名
	 * @param name  字段名
	 * @param value 值
	 * @return
	 */
	public String getOneMes(String table, String name, @Param(value = "value") String value) {
		// return "select * from " + table + " where " + name + "='" + value + "'";
		return new SQL() {
			{
				SELECT("*");
				FROM(table);
				WHERE(name + "=#{value}");
			}
		}.toString();
	}
}
