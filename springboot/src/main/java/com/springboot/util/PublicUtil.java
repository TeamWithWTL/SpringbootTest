package com.springboot.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.springboot.entity.User;

/**
 * 	共用方法类
 * @author luoji
 *
 * @param <T> 可以随意指定实体类
 */
@Component
public class PublicUtil<T> {
	
	/**
	 * 	获取字段名List
	 * @param t	实体类
	 * @param cls	实体类
	 * @return	返回字段名list
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<String> values(T t, Class cls) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 获取所有属性
		Field[] fields = cls.getDeclaredFields();
		List<String> fieldList = new ArrayList<String>();
		// 便利所有属性
		for (Field field : fields) {
			// 获取每一个属性的名称
			String name = field.getName();
			// 获取每个属性对应的get名称
			String getName = getOrSet(name, "get");
			// 获取属性对应的get方法
			Method method = cls.getMethod(getName);
			// 执行get方法
			Object object = method.invoke(t);
			if (object != null) {
				// 属性名与get到的值存进去
				fieldList.add(name);
			}
		}
		return fieldList;
	}

	/**
	 * 获取get/set方法名
	 * 
	 * @param name        属性名
	 * @param methodNames "get"/"set"
	 * @return 返回获取的get/set方法名
	 */
	public String getOrSet(String name, String methodNames) {
		String methodName = null;
		if (methodNames.equals("get") || methodNames.equals("set")) {
			methodName = methodNames + name.substring(0, 1).toUpperCase() + name.substring(1);
		}
		return methodName;
	}
	
	/**
	 * 	获取字段名数组
	 * @param list	传入字段列表
	 * @return
	 */
	public String[] getKeyArray(List<String> list) {
		// 创建数组与列表长度相同
		String[] keyStrings = new String[list.size()];
		// 将列表转换为数组
		list.toArray(keyStrings);
		return keyStrings;
	}
	
	/**
	 * 	获取对应字段名的获取字符串
	 * @param keyStrings	"nameMap.字段名"数组
	 * @return
	 */
	public String[] getValueStrings(String[] keyStrings) {
		// 创建数组
		String[] valStrings = new String[keyStrings.length];
		// 给数组赋值
		for (int i = 0; i < valStrings.length; i++) {
			valStrings[i] = "#{nameMap."+keyStrings[i]+"}";
		}
		return valStrings;
	}
}
