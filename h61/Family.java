package com.huawei.classroom.student.h61;

//新建Family类继承GroupSite
//用来模拟每个家庭的传染情况
public class Family extends GroupedSite {
	public Family(int id, int size, double spreadRate) {
		super(id, size, spreadRate);
	}
	//以下两个函数功能与Company中类似
	@Override
	public void addPerson(Person person) {
		super.addPerson(person);
		person.setFamily(this);
	}
	@Override
	public boolean checkInfection(Person person) {
		// TODO Auto-generated method stub
		
		return person.getState()==Enum_States.ill_home||person.getState()==Enum_States.latent;
	}
}
