package com.example.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import test.entity.User;

public class test {
	public static void main(String[] args) throws Exception {
		String name = User.class.getName();
		name = name.substring(name.lastIndexOf(".")+1);
		User user = new User();
		user.setId(1);
		user.setPassWord("1223");
		user.setUserName("laal");
		user.setRealName("realname");
		System.out.println(user);
		lala(user,User.class);
	}
	public static void lala(Object obj, Class cls) throws Exception {
		Field[]fields = cls.getDeclaredFields();
		String str = "";
		for (Field field : fields) {
			String name = field.getName();
			String getName = "get"+name.substring(0, 1).toUpperCase() + name.substring(1);
			Method method = cls.getMethod(getName);
			Object object = method.invoke(obj);
			if(!(object==null)) {
				if(object instanceof Integer) {
					str += name + " = " +object + " ";
				}else {
					str += name + " = '" + object +"' ";
				}
			}
		}
	}
}
