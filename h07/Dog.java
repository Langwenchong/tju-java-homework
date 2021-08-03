package com.huawei.classroom.student.h07;

public class Dog extends GameObject {

	public Dog() {

		// super( Param.DOG_HEALTH,Param.DOG_STRENGTH);
		// TODO Auto-generated constructor stub
	}

	public Dog(int health, int strength, int range, int x, int y) {
		super(health, strength, range, x, y);
	}

	public void attack(Soldier soldier) {
		int dx = this.getX() - soldier.getX();
		int dy = this.getY() - soldier.getY();
		double dis = Math.pow(dx * dx + dy * dy, 0.5);
		if (this.getRange() < dis) {
			return;
		}
		if (soldier instanceof Soldier) {
			if (soldier.getHealth() > 0) {
				soldier.setHealth(0);
				Soldier.subLivingSoldierCount();
			}

		} else {
			soldier.setHealth(soldier.getHealth() - this.getStrength());
		}
	}

}
