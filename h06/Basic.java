package com.huawei.classroom.student.h06;

public class Basic {
	public int health;
	public int atk;
	public int len;
	public int x;
	public int y;

	public Basic() {
	};

	public Basic(int health, int atk, int len, int x, int y) {
		this.health = health;
		this.atk = atk;
		this.len = len;
		this.x = x;
		this.y = y;
	}

	public int getHealth() {
		return this.health;
	}

	public Boolean isDestroyed() {
		if (this.health <= 0)
			return true;
		else
			return false;
	}

	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public Boolean judge(int enemy_x, int enemy_y) {
		int dx = Math.abs(this.x - enemy_x);
		int dy = Math.abs(this.y - enemy_y);
		double dis = Math.sqrt(dx * dx + dy * dy);
		if (dis > (double) this.len) {
			return false;
		} else {
			return true;
		}
	}

	public void attack(Basic obj) {
		int enemy_x = obj.x;
		int enemy_y = obj.y;
		if (judge(enemy_x, enemy_y)) {
			obj.changeHealth(this.atk);
		}
	}

	public void changeHealth(int strength) {
		int beforeHealth = this.getHealth();
		this.health = this.health - strength;
		if (beforeHealth > 0 && this.health <= 0) {
			Soldier.subLivingSoldierCount();
		}
	}
}
