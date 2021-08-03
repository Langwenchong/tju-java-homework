package com.huawei.classroom.student.h17;

public class WarFactory extends GameObject {
	public WarFactory(String str, int health, int attack, int range, int x, int y, EnumObjectType type) {
		super(str, health, attack, range, x, y, type);
	}

	public GameObject building(EnumObjectType type) {
		GameObject obj;
		switch (type) {
		case heavyTank:
			obj = new HeavyTank(this.getPlayerName(), BattleField.basic[0].getHealth(),
					BattleField.basic[0].getAttack(), BattleField.basic[0].getRange(), this.getX(), this.getY(),
					EnumObjectType.heavyTank);
			break;
		case mediumTank:
			obj = new MediumTank(this.getPlayerName(), BattleField.basic[1].getHealth(),
					BattleField.basic[1].getAttack(), BattleField.basic[1].getRange(), this.getX(), this.getY(),
					EnumObjectType.mediumTank);
			break;
		default:
			obj = null;
			System.out.println("Error");
		}
		BattleField.gameObjects.add(obj);
		return obj;
	}
}
