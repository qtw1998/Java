package com.imooc.collection;
import java.util.HashSet;
import java.util.Set;

/***
 * 学生类
 * @author qtw1998
 *
 */
public class Student implements Comparable<Student>{
	public String id;
	public String name;
	public Set<Course> courses;	//学生的备选课程是Set集合-->无序但不可重复
	
	public Student (String id,String name) {
		this.id = id;
		this.name = name;
		this.courses = new HashSet<Course>();
	}

	@Override
	public int compareTo(Student o) {//o对象 相等返回0，o比当前小返回正整数
		// TODO Auto-generated method stub
		//return 0;
		return this.id.compareTo(o.id);
	}
}
