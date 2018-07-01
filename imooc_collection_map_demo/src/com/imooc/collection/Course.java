package com.imooc.collection;


public class Course {
	/**
	 * 课程类
	 */
	public String id;
	public String name;
	
	public Course(String id,String name) {
		this.id = id;
		this.name = name;
	}
	public Course() {
			
		}
	/**
	 * 重写equals的模板（可复用）
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {	//==代表的是地址的相等
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Course)) {
			return false;
		}
		Course course = (Course)obj;
		/**
		 * 如果要增加其他的判断的属性，我们可以在下面进行其他的增加
		 */
		if(this.name == null) {
			if(course.name == null)
				return true;
			else
				return false;
		}else {
			if(this.name.equals(course.name)) {
				return true;
			}
			else 
				return false;
		}
	}
	
}
