package com.huawei.classroom.student.h05;

//barrack
public class Barrack {
	public int health = 100;

	public int getHealth() {
		return this.health;
	}

	public Boolean isDestroyed() {
		if (this.health <= 0) {
			return true;
		} else
			return false;
	}

	public Soldier traing(EnumObjectType x) {
		Soldier obj;
		switch (x) {
		case rifleSoldier:
			obj = new RifleSoldier();
			Soldier.addLivingSoldierCount();
			break;
		case RPGSoldier:
			obj = new RPGSoldier();
			Soldier.addLivingSoldierCount();
			break;
		case dog:
			obj = new Dog();
			break;
		default:
			obj = new Soldier();
			break;
		}
		return obj;
	}
}
