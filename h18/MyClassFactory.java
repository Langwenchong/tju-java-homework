package com.huawei.classroom.student.h18;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

public class MyClassFactory {

	public MyClassFactory(String string) {
		// TODO Auto-generated constructor stub
		try {
			Init.Initialization(string);
			// System.out.println(Init.myClasses);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public <T> T createInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		String className = clazz.getName();
		// System.out.println(className);
		T obj = clazz.newInstance();
		Map<String, Object> parameter = Init.myClasses.get(className);
		Iterator<String> it = parameter.keySet().iterator();
		while (it.hasNext()) {
			String property = it.next();
			Object value = parameter.get(property);
			String methodName = "set" + property.substring(0, 1).toUpperCase() + property.substring(1);
			Method method = obj.getClass().getMethod(methodName, value.getClass());
			method.invoke(obj, value);
		}
		return obj;
	}

}
