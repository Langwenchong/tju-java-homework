package com.huawei.classroom.student.h06;

public class GameBase extends Basic {
	public GameBase() {
	};

	public GameBase(int x, int y) {
		super(500, 0, 0, 0, 0);
	}

	public GameBase(int health, int atk, int len, int x, int y) {
		super(health, atk, len, x, y);
	}

	public static GameBase createGameBase(int x, int y) {
		return new GameBase(x, y);
	}

	public GameBase building(EnumObjectType type, int x, int y) {
		switch (type) {
		case barrack:
			return new Barrack(x, y);
		case warFactory:
			return new WarFactory(x, y);
		default:
			return new GameBase(x, y);
		}
	}

}
