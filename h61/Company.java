package com.huawei.classroom.student.h61;

//新建Company类继承GroupSite类
//用来模拟公司中的传染情况
public class Company extends GroupedSite {

	public Company(int id, int size, double spreadRate) {
		super(id, size, spreadRate);
	}
	//每当有人去公司
	//把这个人加在继承于GroupSite中的List<Person>中
	@Override
	public void addPerson(Person person) {
		super.addPerson(person);
		person.setCompany(this);
	}
	//查看某一个Person对象是否在潜伏期
	@Override
	public boolean checkInfection(Person person) {
		// TODO Auto-generated method stub
		
		return  person.getState()==Enum_States.latent;
	}
}
