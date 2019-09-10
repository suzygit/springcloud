package com.cloud.cloud.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloud.cloud.entity.Ba3427Rvc;


public class Test {

	public static void main(String[] args) throws InstantiationException {
		// TODO Auto-generated method stub
		List<Map<String,Object>> listnm01 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> listnm02 = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("piaojuhm", "1111");
		map1.put("shouxfje", 1.11);
		map1.put("listnm02", listnm02);
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("piaojuhm", "2222");
		map2.put("shouxfje", 2.22);
		map2.put("listnm02", listnm02);
		
		Map<String,Object> map3 = new HashMap<String,Object>();
		map3.put("piaojuhm", "3333");
		map3.put("shouxfje", 3.33);
		Map<String,Object> map4 = new HashMap<String,Object>();
		map4.put("piaojuhm", "4444");
		map4.put("shouxfje", 4.44);
		listnm02.add(map3);
		listnm02.add(map4);
		
		listnm01.add(map1);
		listnm01.add(map2);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("shouxfje", 1.00);
		map.put("listnm01", listnm01);
		Ba3427Rvc a = new Ba3427Rvc();
		a = (Ba3427Rvc)proData(a,map);
		System.out.println(a.getListnm01().toString()); 
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static Object proData(Object supObject,Map<String,Object> map){
		
			try {
				Field[] fields=supObject.getClass().getDeclaredFields();
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
								
								System.out.println(map.get(name).toString());
								List<Object> l = (List<Object>)map.get(name);
								System.out.println(l.size());
								List<Object> li = new ArrayList<Object>();
								for(int i =0;i<l.size();i++){
									Object o = genericClazz.newInstance();
									o = proData(o,(Map<String,Object>)l.get(i));
									li.add(o);
								}
								field.set(supObject, li);
								
							}
						}else if(Double.class.equals(field.getType())){
							field.set(supObject, Double.parseDouble(map.get(name).toString()));
						}else if(String.class.equals(field.getType())){
							field.set(supObject, map.get(name));
						}else if(Long.class.equals(field.getType())){
							field.set(supObject, Long.parseLong(map.get(name).toString()));
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return supObject;
	}

}
