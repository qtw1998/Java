package com.imooc.collection;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;





public class SetTest {
	
	public List<Course> coursesToSelect;
	private Scanner console;
	public Student student;
	
	public SetTest() {
		this.coursesToSelect = new ArrayList<Course>();
		console = new Scanner(System.in);
	}
	
	public void testAdd() {
		//创建一个备选课程，并且用add方法添加到备选课程List当中
		Course cr1 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
//		Course temp = (Course)coursesToSelect.get(0);
//		System.out.println("添加了课程：" + temp.id + ":" + temp.name);

		Course cr2 = new Course("2","C语言");
		coursesToSelect.add(0,cr2);
//		Course temp2 = (Course)coursesToSelect.get(0);
//		System.out.println("添加了课程：" + temp2.id + ":" + temp2.name);
		
		//注意下边的添加方法
		Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));//把数组转换成集合-->注意:仅仅针对对象数组类型,基本数据类型数组不具备该特性,
//		Course temp3 = (Course)coursesToSelect.get(2);
//		Course temp4 = (Course)coursesToSelect.get(3);
//		System.out.println("添加了课程：" + temp3.id + ":" + temp3.name + "添加了课程：" + temp4.id + ":" + temp4.name);
		
		Course[] courses2 = {new Course("5", "高等数学"),new Course("6", "大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(courses2));
//		Course temp5 = (Course)coursesToSelect.get(2);
//		Course temp6 = (Course)coursesToSelect.get(3);
//		System.out.println("添加了课程：" + temp5.id + ":" + temp5.name + "添加了课程：" + temp6.id + ":" + temp6.name);
	}
	
	/**
	 * 通过foreach方法访问集合元素（迭代器方法的一种简便的写法）
	 * @param args
	 */
//	public void testForEach() {
//		System.out.println("有如下课程待选（通过for each访问）：");
//		for(Course cr : coursesToSelect) {
//			System.out.println("课程" + cr.id + ":" + cr.name);
//		}
//	}
//	/**
//	 * 测试List的contains()方法
//	 * @param args
//	 */
	public void testListContains() {
		//取得备选课程序列的第0个元素
		Course course = coursesToSelect.get(0);
		//打印输出CourseToSelect是否包含course对象
		System.out.println("取得课程：" + course.name);
		System.out.println("备选课程是否包含课程：" + course.name + coursesToSelect.contains(course));
		//提示输入的课程的名称
		System.out.println("请输入课程的名称");
		String name = console.next();
		Course course2 = new Course();
		course2.name = name;
		System.out.println("新创建的课程：" + course2.name);
		System.out.println("备选课程是否包含课程：" + course2.name + coursesToSelect.contains(course2));
	}
	
	/**
	 * 创建学生对象并选课
	 */
	public void createStudentAndSelectCours() {
		//创建一个学生对象
		Student student = new Student("1", "小明");
		System.out.println("欢迎学生：" + student.id + ":" + student.name + "选课！");
		console = new Scanner(System.in);
		
		for(int i = 0;i < 3;i++) {
			System.out.println("请输入课程ID：");
			String courseId = console.next();
			for(Course cr :coursesToSelect) {	//注意：要加“st.”!!!
				if(cr.id.equals(courseId)) {//如果课程列表里面匹配了课程名称，就添加在student的列表里面
					student.courses.add(cr);
				}
			}
		}
	}		
		/**
		 * 测试Set的contains方法
		 */
		public void testSetContains() {
			//提示输入课程名称
			System.out.println("请输入学生已选的课程名称：");
			String name = console.next();
			//创建一个新的课程对象
			Course course2 = new Course();
			course2.name = name;
			System.out.println("新创建的课程：" + course2.name);
			System.out.println("备选课程是否包含课程：" + course2.name + "," +coursesToSelect.contains(course2));
		
		
		
//		/**
//		 * foreach 方法来输出
//		 */
//		for(Course cr : student.courses) {
//			System.out.println("选择了课程：" + cr.id + ":" + cr.name);
//		}
//		/**
//		 * iterator的方法来输出
//		 */
//		Iterator<Course> iterator = student.courses.iterator();//学生选择的课程列表里面选择
//		while(iterator.hasNext()) {
//			Course cr = iterator.next();
//			System.out.println("选择了课程：" + cr.id + ":" + cr.name);
//		}
//		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest st = new SetTest();//课程是无序的但不可以重复，用set来初始化实例
		st.testAdd();
		//st.testForEach();
		
		st.createStudentAndSelectCours();
		st.testSetContains();
//		st.testListContains();
//		//创建一个学生对象
//		Student student = new Student("1", "小明");
//		System.out.println("欢迎学生：" + student.id + ":" + student.name + "选课！");
//		//创建一个Scanner对象，接受从键盘输入的课程ID
//		Scanner console = new Scanner(System.in);
//		
//		for(int i = 0;i < 3;i++) {
//			System.out.println("请输入课程ID：");
//			String courseId = console.next();
//			for(Course cr : st.coursesToSelect) {	//注意：要加“st.”!!!
//				if(cr.id.equals(courseId)) {//如果课程列表里面匹配了课程名称，就添加在student的列表里面
//					student.courses.add(cr);
//				}
//			}
//		}
		/**
		 * foreach 方法来输出
		 */
//		for(Course cr : student.courses) {
//			System.out.println("选择了课程：" + cr.id + ":" + cr.name);
//		}
//		/**
//		 * iterator的方法来输出
//		 */
//		Iterator<Course> iterator = student.courses.iterator();//学生选择的课程列表里面选择
//		while(iterator.hasNext()) {
//			Course cr = iterator.next();
//			System.out.println("选择了课程：" + cr.id + ":" + cr.name);
//		}
//		
	}

}
