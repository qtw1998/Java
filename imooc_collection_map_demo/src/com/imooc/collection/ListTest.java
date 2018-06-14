package com.imooc.collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * 备选课程类
 * @author qtw1998
 *
 */
public class ListTest {
	/**
	 * 用于存放备选课程的List
	 */
	
	public List coursesToSelect;
	
	public ListTest() {
		this.coursesToSelect = new ArrayList();
	}
	
	/**
	 * 用于往coursesToSelect里添加备选课程
	 */
	public void testAdd() {
		//创建一个备选课程，并且用add方法添加到备选课程List当中
		Course cr1 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		Course temp = (Course)coursesToSelect.get(0);
		System.out.println("添加了课程：" + temp.id + ":" + temp.name);

		Course cr2 = new Course("2","C语言");
		coursesToSelect.add(0,cr2);
		Course temp2 = (Course)coursesToSelect.get(0);
		System.out.println("添加了课程：" + temp2.id + ":" + temp2.name);
		
		//注意下边的添加方法
		Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));//把数组转换成集合-->注意:仅仅针对对象数组类型,基本数据类型数组不具备该特性,
		Course temp3 = (Course)coursesToSelect.get(2);
		Course temp4 = (Course)coursesToSelect.get(3);
		System.out.println("添加了课程：" + temp3.id + ":" + temp3.name + "添加了课程：" + temp4.id + ":" + temp4.name);
		
		Course[] courses2 = {new Course("5", "高等数学"),new Course("6", "大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(courses2));
		Course temp5 = (Course)coursesToSelect.get(2);
		Course temp6 = (Course)coursesToSelect.get(3);
		System.out.println("添加了课程：" + temp5.id + ":" + temp5.name + "添加了课程：" + temp6.id + ":" + temp6.name);
	}

	/*
	 * 取得LIST中的元素的方法（普通遍历）
	 */
	public void testGet() {
		int size = coursesToSelect.size();
		System.out.println("有如下课程待选：");
		for(int i = 0; i < size;i++) {
			Course cr = (Course) coursesToSelect.get(i);
			System.out.println("课程" + cr.id + ":" + cr.name);
		}
	}
	/**
	 * 迭代器访问
	 */
	public void testIterator() {
		//通过集合的iterator方法，取得迭代器的实例
		Iterator it = coursesToSelect.iterator();
		System.out.println("有如下课程待选（通过迭代器访问）：");
		while(it.hasNext()) {
			Course cr = (Course) it.next();
			System.out.println("课程" + cr.id + ":" + cr.name);
		}
		
	}
	/**
	 * 通过foreach方法访问集合元素（迭代器方法的一种简便的写法）
	 * @param args
	 */
	public void testForEach() {
		System.out.println("有如下课程待选（通过for each访问）：");
		for(Object object : coursesToSelect) {
			Course cr = (Course) object;
			System.out.println("课程" + cr.id + ":" + cr.name);
		}
	}
	/**
	 * 修改List中的元素
	 * @param args
	 */
	public void testModify() {
		coursesToSelect.set(5,new Course("7", "qtw1998") );
	}
	/**
	 * 删除List中的元素
	 * @param args
	 */
	public void testRemove() {
//		Course cr = (Course) coursesToSelect.get(5);
//		System.out.println("我是课程：" + cr.id + ":" + cr.name + "我即将被删除！");
//		coursesToSelect.remove(5);//此处参数也可以是obj（Course类对象）
//		System.out.println("成功删除课程！");
//		testForEach();
		
		System.out.println("利用removeAll删除4和5位置上的元素！");
		Course[] course = {(Course) coursesToSelect.get(4),(Course) coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(course));
		System.out.println("成功删除课程！");
		testForEach();
	}
	public static void main(String args[]) {
		ListTest It = new ListTest();
		It.testAdd();
		It.testGet();
		It.testIterator();
		It.testForEach();
		It.testModify();
		It.testForEach();
		It.testRemove();
	}
}
