package com.huawei.classroom.student.h17;

public class Barrack extends GameObject {
	public Barrack(String str, int health, int attack, int range, int x, int y, EnumObjectType type) {
		super(str, health, attack, range, x, y, type);
	}

	public GameObject traing(EnumObjectType type) {
		GameObject obj;
		switch (type) {
		case rifleSoldier:
			obj = new RifleSoldier(this.getPlayerName(), BattleField.basic[2].getHealth(),
					BattleField.basic[2].getAttack(), BattleField.basic[2].getRange(), this.getX(), this.getY(),
					EnumObjectType.rifleSoldier);
			break;
		case RPGSoldier:
			obj = new RPGSoldier(this.getPlayerName(), BattleField.basic[3].getHealth(),
					BattleField.basic[3].getAttack(), BattleField.basic[3].getRange(), this.getX(), this.getY(),
					EnumObjectType.RPGSoldier);
			break;
		case dog:
			obj = new Dog(this.getPlayerName(), BattleField.basic[4].getHealth(), BattleField.basic[4].getAttack(),
					BattleField.basic[4].getRange(), this.getX(), this.getY(), EnumObjectType.dog);
			break;
		default:
			obj = null;
			System.out.println("Error");
		}
		BattleField.gameObjects.add(obj);
		return obj;
	}
}
