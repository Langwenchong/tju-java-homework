package com.huawei.classroom.student.h06;

public class Barrack extends GameBase {
	public Barrack(int x, int y) {
		super(100, 0, 0, x, y);
	}

	public Soldier traing(EnumObjectType type) {
		Soldier obj;
		switch (type) {
		case rifleSoldier:
			obj = new RifleSoldier(this.x, this.y);
			Soldier.addLivingSoldierCount();
			break;
		case RPGSoldier:
			obj = new RPGSoldier(this.x, this.y);
			Soldier.addLivingSoldierCount();
			break;
		case dog:
			obj = new Dog(this.x, this.y);
			break;
		default:
			obj = new Soldier();
			break;
		}
		return obj;
	}
}
