package com.ydcun.java.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestG1 {
	/**
	 * 通过泛型减少强制类型转化
	 */
	public void method1(){
		List<String> list = new ArrayList<String>();
		list.add("abc");
		System.out.println(list.get(0));
	}
	/**
	 * 泛型是javac编辑器使用的 编译器编译后会去掉泛型信息
	 */
	public void method2() throws Exception{
		List<String> list1 = new ArrayList<String>();
		List<Integer> list2 = new ArrayList<Integer>();
		System.out.println(list1.getClass() == list2.getClass());//说明指向的是统一分字节码文件
		
		list1.getClass().getMethod("add",Object.class).invoke(list1, "abc");
		System.out.print(list1.get(0));
	}
	/**
	 * 通过问号通配符接受任意类型
	 * 不能调用与参数化有关的方法
	 * @param collection
	 * Collection<? extends Number>  Number或者其子类的任意类型
	 * Collection<? super Integer> Integer或者其父类
	 */
	public void printCollection(Collection<?> collection){
		for(Object obj:collection){
			System.out.println(obj);
		}
	}
	public void printMap(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("wxm",12);
		map.put("mxm",33);
		
		Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
		for(Map.Entry<String,Integer> entry:entrySet){
			System.out.println(entry.getKey()+":"+entry.getValue());
		} 
	}
	public  static void main(String[] arge){
		try {
			TestG1 testG1 = new TestG1();
	//		testG1.method1();
			testG1.method2();
			List<String> list1 = new ArrayList<String>();
			list1.add("ddd");
//			testG1.printCollection(list1);
			testG1.printMap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
