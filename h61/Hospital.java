package com.huawei.classroom.student.h61;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//新建Hospital类
//用来模拟医院的情况
/*
 * 包括的属性有：
 * size:医院可容纳的人数，即医院的病床数
 * Set<Person>:存放接受治疗的患者
 * List<Person>:存放当冰川不够时等待的患者
 */
public class Hospital {
	private int size;
	private Set<Person> patients=new HashSet<Person>();
    private List<Person> waitingPatients=new LinkedList<Person>(); 
    
    public Set<Person> getPatients() {
		return patients;
	}
	public List<Person> getWaitingPatients() {
		return waitingPatients;
	}
	public Hospital(int size) {
		super();
		this.size = size;
	}
	//当有新的患者到医院时
	//根据医院当时情况处理
	//若还有空余病床，则加入到patients中
	//否则加入到waitingPatients中
	public void appendPatients(Person person) {
    	if(patients.size()<size) {
    		patients.add(person);
    		person.setState(Enum_States.ill_hospital);
    	}else {
    		waitingPatients.add(person);
    	}
    }
	//
    public void clearBed() {
    	Iterator<Person> it = patients.iterator();
    	while(it.hasNext()) {
    		Person person=it.next();
    		if(person.getState()!=Enum_States.ill_hospital) {
    			it.remove();
    		}    		
    	}
    	it = waitingPatients.iterator();
    	while(it.hasNext()) {
    		Person person=it.next();
    		if(person.getState()!=Enum_States.ill_home) {
    			it.remove();
    		}
    		
    	}
    	while(waitingPatients.size()>0&&patients.size()<size) {
    		Person person=waitingPatients.get(0);
    		patients.add(person);
    		person.setState(Enum_States.ill_hospital);
    		waitingPatients.remove(0);
    	}
    	 
    }
    
}
