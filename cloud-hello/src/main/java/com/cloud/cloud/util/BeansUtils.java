package com.cloud.cloud.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONObject;

public abstract class BeansUtils {
	/**
	 * 循环向上转型, 获取对象的 DeclaredField
	 * 
	 * @param object
	 *            : 子类对象
	 * @param fieldName
	 *            : 父类中的属性名
	 * @return 父类中的属性对象
	 */

	public static Field getDeclaredField(Object object, String fieldName) {
		Field field = null;

		Class<?> clazz = object.getClass();
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				return field;
			} catch (Exception e) {
			}
		}

		return null;
	}

	/**
	 * 直接设置对象属性值, 忽略 private/protected 修饰符, 也不经过 setter
	 * 
	 * @param object
	 *            : 子类对象
	 * @param fieldName
	 *            : 父类中的属性名
	 * @param value
	 *            : 将要设置的值
	 */

	public static void setFieldValue(Object object, String fieldName, Object value) {

		// 根据 对象和属性名通过反射 调用上面的方法获取 Field对象
		Field field = getDeclaredField(object, fieldName);
		// 抑制Java对其的检查
		field.setAccessible(true);

		try {
			// 将 object 中 field 所代表的值 设置为 value
			field.set(object, value);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 直接调用对象方法, 而忽略修饰符(private, protected, default)
	 * 
	 * @param object
	 *            : 子类对象
	 * @param methodName
	 *            : 父类中的方法名
	 * @param parameterTypes
	 *            : 父类中的方法参数类型
	 * @param parameters
	 *            : 父类中的方法参数
	 * @return 父类中方法的执行结果
	 */

	public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters) {
		// 根据 对象、方法名和对应的方法参数 通过反射 调用上面的方法获取 Method 对象
		Method method = getDeclaredMethod(object, methodName, parameterTypes);

		// 抑制Java对方法进行检查,主要是针对私有方法而言
		method.setAccessible(true);
		try {
			if (null != method) {
				// 调用object 的 method 所代表的方法，其方法的参数是 parameters
				return method.invoke(object, parameters);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 循环向上转型, 获取对象的 DeclaredMethod
	 * 
	 * @param object
	 *            : 子类对象
	 * @param methodName
	 *            : 父类中的方法名
	 * @param parameterTypes
	 *            : 父类中的方法参数类型
	 * @return 父类中的方法对象
	 */

	public static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
		Method method = null;
		for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				method = clazz.getDeclaredMethod(methodName, parameterTypes);
				return method;
			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				// 如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了

			}
		}

		return null;
	}
	
	/**
	 * json转bean
	 * @param object
	 * @param jsonObject
	 */
	public static void jsonToBean(Object object,JSONObject jsonObject) {
		Map map =  JSONObject.fromObject(jsonObject);
		Field[] fields=object.getClass().getDeclaredFields();
        Field field;
        for(int i = 1;i<fields.length ; i++){ 
    		try {
				field=object.getClass().getDeclaredField(fields[i].getName());
				Column column=field.getAnnotation(Column.class); //获取指定类型注解
				if(column!=null){ 
					if(null != map && null != map.get(column.name())){
						field.setAccessible(true);
						if("class java.math.BigDecimal".equals(field.getGenericType().toString())){
							field.set(object, new BigDecimal(map.get(column.name()).toString()));
						}else{
							field.set(object, map.get(column.name()).toString());
						}
					}
				}
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
        } 
	}
	
	@SuppressWarnings("unchecked")
	public static Object proData(Map<String,Object> map,Object object){
		
			try {
				Field[] fields=object.getClass().getDeclaredFields();
				for (Field field : fields) {
					field.setAccessible(true);
					String name = field.getName();
					Type genericType = field.getGenericType();
					
					if(null != map && null != map.get(name)){
						if(List.class.equals(field.getType())){
							// 如果是泛型参数的类型   
							if(genericType instanceof ParameterizedType){   
								ParameterizedType pt = (ParameterizedType) genericType;
								//得到泛型里的class类型对象  
								Class<?> genericClazz = (Class<?>)pt.getActualTypeArguments()[0];
								
								List<Object> l = (List<Object>)map.get(name);
								List<Object> li = new ArrayList<Object>();
								for(int i =0;i<l.size();i++){
									Object o = genericClazz.newInstance();
									o = proData((Map<String,Object>)l.get(i),o);
									li.add(o);
								}
								field.set(object, li);
								
							}
						}else if(Double.class.equals(field.getType())){
							field.set(object, Double.parseDouble(map.get(name).toString()));
						}else if(String.class.equals(field.getType())){
							field.set(object, map.get(name));
						}else if(Long.class.equals(field.getType())){
							field.set(object, Long.parseLong(map.get(name).toString()));
						}else if (Date.class.equals(field.getType())) {
							try {
								field.set(object, DateUtils.getStringDateTime(map.get(name).toString()));
							} catch (Exception e) {
								field.set(object, DateUtils.getStringDate(map.get(name).toString()));
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return object;
	}
}
