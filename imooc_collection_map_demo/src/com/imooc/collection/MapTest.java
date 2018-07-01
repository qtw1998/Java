package com.imooc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {//声明属性的时候都是用抽象的集合接口，初始化的时候都用实例化HashMap
	/**
	 * 用来承装学生类型对象
	 */
	public Map<String, Student> students;
	/**
	 * 在构造器当中初始化students
	 */
	public MapTest() {
		this.students = new HashMap<String,Student>(); 
	}
	/**
	 * 测试添加：输入学生的ID，判断下是否ID已经被占用
	 * 若未被占用，则创建新的学生对象
	 * 并且增加到students当中
	 */
	public void testPut() {
		//创建一个Scanner对象，用来获取输入的学生ID和姓名
		Scanner console = new Scanner(System.in);
		int i = 0;
		while(i < 3) {
			System.out.println("请输入学生的ID：");//因为键值对的Key是唯一的用来判断是否是已占用的
			String ID = console.next();
			//判断是否ID被占用
			Student st = students.get(ID);//map当中的get()方法
			if(st == null) {
				System.out.println("请输入学生的姓名：");
				String name = console.next();	//注意Scanner是可以复用的Scanner console = new Scanner(System.in)
				Student newstudent = new Student(ID, name);
				students.put(ID, newstudent);//这里是关键核心代码
				System.out.println("成功添加学生：" + students.get(ID).name);
				i++;
			}else {
				System.out.println("该学生的ID已经占用！");
				continue;
			}
		}
	}
	public void testKeySet() {//遍历map内的成员的功能
		Set<String> keySet = students.keySet();//keyset()功能是将所有的键的集合
		System.out.println("总共有：" + students.size() + "个学生！");
		for (String stuId : keySet) {
			Student st = students.get(stuId);
			if(st != null) {
				System.out.println("学生：" + st.name);
			}
		}
	}
	/**
	 * 用来删除Map当中的映射
	 */
	public void testRemove() {
		while(true) {
			//提示删除带输入的学生的ID
			System.out.println("请输入待删除学生的ID：");
			Scanner console = new Scanner(System.in);
			String studelId = console.next();
			
			Student studel = students.get(studelId);
			if(studel != null) {
				students.remove(studelId);
				break;
			}else {
				System.out.println("您要删除的学生不存在！");	
			}
		}
	}
	/**
	 * 通过entrySet()的方法来返回Map的所有键值对
	 * @param args
	 */
	public void testEntrySet() {
		Set<Entry<String, Student>> entrySet = students.entrySet();
		for (Entry<String, Student> entry : entrySet) {
			System.out.println("取得了键：" + entry.getKey());
			System.out.println("对应的值为：" + entry.getValue().name);
			
		}
	}
	public static void main(String[] args) {
		MapTest mTest = new MapTest();
		mTest.testPut();
		mTest.testKeySet();
		mTest.testRemove();
		mTest.testEntrySet();
	}
}
