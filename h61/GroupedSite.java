package com.huawei.classroom.student.h61;

import java.util.ArrayList;
import java.util.List;

//新建抽象类GroupSite代表有很多人集中的地点
//Company和Family
/*
 * 其中属性包括：
 * id:这个地点的id
 * size:这个地点的人数
 * spreadRate:传染的概率
 * List<Person>:在这个地点的所有人的列表
 * infectionSource:这个地点是否有传染源
 */
public abstract class GroupedSite {
	private int id;
	private int size;
	private double spreadRate;
	private List<Person> persons;
	private boolean infectionSource=false;
	public int getId() {
		return id;
	}

 

	public GroupedSite(int id, int size, double spreadRate) {
		super();
		this.id = id;
		this.size = size;
		this.spreadRate = spreadRate;
		persons=new ArrayList<Person>();
	}



	public GroupedSite(int id, int size) {
		super();
		this.id = id;
		this.size = size;
		this.persons=new ArrayList<Person>();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean nfectionExist() {
		return infectionSource;
	}
	
	
	 
	public void addPerson(Person person) {
		this.persons.add(person);
	}
	public boolean isFull() {
		return this.persons.size()>=this.size;
	}
	public void resetInfectionSource() {
		this.infectionSource=false;
		for(Person person:persons) {
			if(checkInfection(person) ) {
				this.infectionSource=true;
				break;
			}
		}
		
	}
	public abstract boolean checkInfection(Person person) ;
}
