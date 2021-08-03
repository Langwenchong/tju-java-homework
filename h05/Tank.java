package com.huawei.classroom.student.h05;

public class Tank {
	public int health;
	public int atk;

	public Tank() {
	};

	public Tank(int health, int atk) {
		this.health = health;
		this.atk = atk;
	}

	public Boolean isDestroyed() {
		if (this.health <= 0) {
			return true;
		} else
			return false;
	}

	public int getHealth() {
		return this.health;
	}

	public void attack(Soldier obj) {
		obj.health -= atk;
		if (obj instanceof RifleSoldier || obj instanceof RPGSoldier) {
			if (obj.isDestroyed()) {
				Soldier.subLivingSoldierCount();
			}
		}
	}

	public void attack(Tank obj) {
		obj.health -= atk;
		;
	}

	public void attack(Barrack obj) {
		obj.health -= atk;
	}

	public void attack(WarFactory obj) {
		obj.health -= atk;
	}
}