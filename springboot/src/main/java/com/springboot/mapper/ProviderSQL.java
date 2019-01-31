package com.springboot.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import java.util.Set;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	/**
	 * 动态添加一条数据
	 * @param table	表名
	 * @param cls	实体类
	 * @param obj	存储对象
	 * @return
	 * @throws Exception
	 */
	public String addOneMes(String table, Class cls, Object obj) {
		try {
			Set<Entry<String, Object>> set = values(obj, cls);
			return new SQL() {
				{
					INSERT_INTO(table);
					for (Entry<String, Object> entry : set) {
						String key = entry.getKey();
						String value = "'"+entry.getValue()+"'";
						VALUES(key, value);
					}
				}
			}.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取属性与值的map
	 * @param obj	需要存入的对象
	 * @param cls	对象对应的实体类
	 * @return
	 * @throws Exception
	 */
	public static Set<Entry<String, Object>> values(Object obj, Class cls) throws Exception {
		Field[] fields = cls.getDeclaredFields();
		Set<Entry<String, Object>> set = null;
		for (Field field : fields) {
			Map<String, Object> values = new HashMap<String, Object>();
			String name = field.getName();
			String getName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
			Method method = cls.getMethod(getName);
			Object object = method.invoke(obj);
			values.put(name, object);
			set = values.entrySet();
		}
		return set;
	}
}
