package com.imooc.collection;
import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	/**
	 * 带有泛型的course的List类型属性
	 */
	public List<Course> courses;
	
	public TestGeneric() {
		this.courses = new ArrayList<Course>();//List 类型实例化为ArryList类型
	}
	/**
	 * 测试增加的方法
	 * @param args
	 */
	public void testAdd() {
		Course cr1 = new Course("1", "语文");
		courses.add(cr1);
	}
	/**
	 * 通过for each访问集合元素
	 * @param args
	 */
	public void testforeach() {
		System.out.println("通过foreach访问课程列表：");
		for(Course cr : courses) {
			System.out.println(cr.id + ":" + cr.name);
		}
	}
	/**
	 * 泛型集合可以添加泛型的子类型的对象实例
	 * @param args
	 */
	public void testChild() {
		ChildCourse ccr = new ChildCourse();
		ccr.id = "3";
		ccr.name = "我是子类型的课程对象的实例~~";
		courses.add(ccr);
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testforeach();
		tg.testChild();
		tg.testforeach();
	}

}
