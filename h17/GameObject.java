package com.huawei.classroom.student.h17;

//每一个游戏对象隶属于一个玩家
public class GameObject extends Player {
	private int health;
	private int attack;
	private int range;
	private int x;
	private int y;
	private EnumObjectType type;

	public EnumObjectType getType() {
		return this.type;
	}

	public void setType(EnumObjectType type) {
		this.type = type;
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getRange() {
		return this.range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public GameObject(String str, int health, int attack, int range, int x, int y, EnumObjectType type) {
		super(str);
		this.health = health;
		this.attack = attack;
		this.range = range;
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public boolean isDestroyed() {
		return this.health <= 0;
	}

	// 攻击指定目标
	public void attack(GameObject obj) {
		if (this.isDestroyed() || this.attack == 0 || obj.isDestroyed())
			return;
		// 计算距离
		double dis = Math.sqrt((double) (obj.x - this.x) * (obj.x - this.x) + (obj.y - this.y) * (obj.y - this.y));
		// 打不到
		if ((double) this.range < dis)
			return;
		obj.health -= this.attack;
		System.out.println(this + "攻击" + obj + "攻击后 health=" + obj.health);
	}

	// 攻击可以打到的最近非友军单位
	public void attack() {
		if (this.isDestroyed() || this.attack == 0)
			return;
		// 最小距离值
		double mindis = 0x3f3f3f3f;
		GameObject obj = null;
		for (int i = 0; i < BattleField.gameObjects.size(); i++) {
			GameObject tmp = BattleField.gameObjects.get(i);
			// 友军别打我^_^
			if (this.getPlayerName() == tmp.getPlayerName()) {
				continue;
			}
			if (tmp.isDestroyed()) {
				continue;
			}
			double dis = Math.sqrt((double) (tmp.x - this.x) * (tmp.x - this.x) + (tmp.y - this.y) * (tmp.y - this.y));
			if ((double) this.range < dis)
				continue;
			// 记录当前最近的非友军单位
			if (dis < mindis) {
				mindis = dis;
				obj = tmp;
			}
		}
		// 谁也打不到直接退出
		if (obj == null)
			return;
		obj.health -= this.attack;
		System.out.println(this + "攻击" + obj + "攻击后 health=" + obj.health);
	}
}
