package com.huawei.classroom.student.h14;

public class Student {
	public String name;
	public String id;
	public String _class;
	public boolean isSubmit = false;

	public Student(String id, String name, String _class) {
		this.id = id;
		this.name = name;
		this._class = _class;
	}
}
