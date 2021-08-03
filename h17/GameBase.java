package com.huawei.classroom.student.h17;

public class GameBase extends GameObject {
	public GameBase(String str, int health, int attack, int range, int x, int y, EnumObjectType type) {
		super(str, health, attack, range, x, y, type);
	}

	// 创建兵营或者兵工厂
	public GameObject building(EnumObjectType type, int x, int y) {
		GameObject obj;
		switch (type) {
		case barrack:
			obj = new Barrack(this.getPlayerName(), BattleField.basic[5].getHealth(), BattleField.basic[5].getAttack(),
					BattleField.basic[5].getRange(), x, y, EnumObjectType.barrack);
			break;
		case warFactory:
			obj = new WarFactory(this.getPlayerName(), BattleField.basic[6].getHealth(),
					BattleField.basic[6].getAttack(), BattleField.basic[6].getRange(), x, y, EnumObjectType.warFactory);
			break;
		default:
			obj = null;
			System.out.println("Error");
		}
		BattleField.gameObjects.add(obj);
		return obj;
	}
}
