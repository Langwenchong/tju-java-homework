package com.huawei.classroom.student.h07;

public class GameObject {
	private int range;
	private int x;
	private int strength;

	private int y;

	private int health = 0;

	private int defaultStrength;

	public GameObject() {
		this.strength = defaultStrength;
	};

	public GameObject(int health, int strength, int range, int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setHealth(health);
		this.setStrength(strength);
		this.setRange(range);
	}

	public void attack(GameObject obj) {
		int dx = this.x - obj.x;
		int dy = this.y - obj.y;
		double dis = Math.pow(dx * dx + dy * dy, 0.5);
		if (this.range < dis) {
			return;
		}

		obj.health = obj.health - this.strength;
	}

	public void attack(Soldier soldier) {
		int dx = this.x - soldier.getX();
		int dy = this.y - soldier.getY();
		double dis = Math.pow(dx * dx + dy * dy, 0.5);
		if (this.range < dis) {
			return;
		}
		soldier.changeHealth(this.strength);
	}

	public void changeHealth(int strength) {
		int beforeHealth = this.getHealth();
		this.health = this.health - strength;
		if (beforeHealth > 0 && this.health <= 0) {
			this.dead();
			// System.out.println(strength);
			// System.out.println("Dead");
		}
	}

	public void dead() {
		Soldier.subLivingSoldierCount();
	}

	public int getHealth() {
		return health;
	}

	public int getRange() {
		return range;
	}

	public int getStrength() {
		return strength;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isDestroyed() {
		if (this.getHealth() <= 0)
			return true;
		else
			return false;
	}

	public void move(int dx, int dy) {
		this.x = this.x + dx;
		this.y = this.y + dy;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
