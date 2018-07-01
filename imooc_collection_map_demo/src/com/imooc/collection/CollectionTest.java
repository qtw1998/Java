package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;





public class CollectionTest {
	/**
	 * 通过Collections.sort()方法，
	 * 对Integer泛型的List,插入十个100以内的不重复的随机整数，
	 * 调用Collections.sort()方法对其进行排序
	 * @author qtw1998
	 */
	public void testSort1() {
		
		List<Integer> integerList = new ArrayList<Integer>();
		//插入十个100以内的不重复的随机整数
		Random random = new Random();//随机整数
		Integer k;
		for(int i = 0;i < 10;i++) {
			do {
			 k = random.nextInt(100);//介于[0,n)的区间
			}while(integerList.contains(k));
			
			integerList.add(k);
			System.out.println("成功添加整数：" + k);
		}
		System.out.println("------排序前-------");
		for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}
		Collections.sort(integerList);
		System.out.println("-------排序后--------");
		for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}
}
	
	/**
	 * 产生随机的字符串
	 */
	 public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
	 
	 /**
	  * 每一条都是不一样的随机，而且每条字符串的长度也不一致
	  */
	 public List<String> randomString(int length){
			List<String> tempList = new ArrayList<String>();
			String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			// 添加十条随机字符串
			for (int i = 0; i < length; i++) {
				Random random = new Random();
				StringBuffer sb = new StringBuffer();
				// 长度为10以内的字符串
				int stringLength = random.nextInt(10);
				// 生成一条字符串
				do {
					for (int j = 0; j < stringLength; j++) {
						int number = random.nextInt(base.length());   
				        sb.append(base.charAt(number));   
					}
				// 字符串不可重复
				} while(tempList.contains(sb.toString()));
				
				tempList.add(sb.toString());
			}
			return tempList;
		}
	/**
	 * 对STRING类进行排序
	 * 创建String泛型的List，增加三个乱序的String元素
	 * 调用后sort方法，再次输出排序后的顺序
	 * @param args
	 */
	public void testSort2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("lenovo");
		System.out.println("------排序前-------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
		Collections.sort(stringList);
		System.out.println("-------排序后--------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
		
	}
	/*
	 * 利用Collections.sort()方法对泛型string的list版本进行排序的版本
	 * 创建完list<string>之后，往其中添加十条随机字符串
	 * 每条字符串长度为10以内的随机整数
	 * 每条字符串每个分字符都为随机生成的字符，字符可以重复
	 * 每条随机字符串不可以重复
	 */
	public void testsort3() {
		List<String> stringList = randomString(10);
		int k = 0;
//		for(int i = 0;i < 10;i++) {
//			stringList.add(randomString(10));
//		}
		System.out.println("------排序前-------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
		Collections.sort(stringList);
		System.out.println("-------排序后--------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
	}
	
	public void testsort4() {
		List<Student> studentlist = new ArrayList<Student>();
		Random random = new Random();
		studentlist.add(new Student(random.nextInt(1000) + "" , "Mike"));
		studentlist.add(new Student(random.nextInt(1000) + "" , "Angela"));
		studentlist.add(new Student(random.nextInt(1000) + "" , "Lucy"));
		studentlist.add(new Student(10000 + "","Beyonce" ));
//		studentlist.add(new Student(1 + "" , "小明"));//加“”的原因是将数字转换成为字符串类型
//		studentlist.add(new Student(2 + "", "小红"));
//		studentlist.add(new Student(3 + "", "小兰"));
		System.out.println("---------排序前-----------");
		for (Student student : studentlist) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}
		Collections.sort(studentlist);
		System.out.println("---------排序后-----------");
		for (Student student : studentlist) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}
		Collections.sort(studentlist,new StudentComparator());
		System.out.println("--------按照姓名排序后---------");
		for (Student student : studentlist) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}
	}
	public static void main(String[] args) {
		CollectionTest cTest = new CollectionTest();
		//cTest.testSort1();
		//cTest.testsort3();
	cTest.testsort4();
	}
}
