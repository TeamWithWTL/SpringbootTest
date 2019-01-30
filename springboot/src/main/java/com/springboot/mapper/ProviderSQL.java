package com.springboot.mapper;

/**
 * 书写动态sql专用
 * @author Roger
 *
 */
public class ProviderSQL {
	
	/**
	 * 动态查询某表的全部数据
	 * @param table
	 * @return
	 */
	public String getAllMes(String table) {
		return "select * from " + table;
	}
	
	/**
	 * 动态查询一条指定参数的数据
	 * @param table 表明
	 * @param name 字段名
	 * @param value 值
	 * @return
	 */
	public String getOneMes(String table, String name, String value) {
		return "select * from "+table+" where "+name+"='"+value+"'";
	}
}
