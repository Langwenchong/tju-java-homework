package com.huawei.classroom.student.h07;

public class GameBase extends GameObject {
	public static GameBase createGameBase(int x, int y) {
		GameBase gameBase = new GameBase();
		gameBase.setHealth(500);
		return gameBase;
	}

	public Building building(EnumObjectType type, int x, int y) {
		if (type == EnumObjectType.barrack) {
			Barrack barrack = new Barrack(x, y);
			barrack.setHealth(100);
			return barrack;
		} else
			return null;
	}
}
