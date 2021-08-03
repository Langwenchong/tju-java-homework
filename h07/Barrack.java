package com.huawei.classroom.student.h07;

public class Barrack extends Building {

	public Barrack(int x, int y) {

		super(100, 0, 0, x, y);
		// super( Param.BARRACK_HEALTH,Param.BARRACK_STRENGTH);

		// TODO Auto-generated constructor stub
	}

	public GameObject traing(EnumObjectType type) {
		GameObject gameObject = null;

		if (type == EnumObjectType.rifleSoldier) {
			gameObject = new RifleSoldier(50, 5, 5, this.getX(), this.getY());
			Soldier.addLivingSoldierCount();
		} else if (type == EnumObjectType.RPGSoldier) {
			gameObject = new RPGSoldier(50, 10, 10, this.getX(), this.getY());
			Soldier.addLivingSoldierCount();
		} else if (type == EnumObjectType.dog) {
			gameObject = new Dog(50, 5, 5, this.getX(), this.getY());
		}
		return gameObject;
	}

}
