package com.huawei.classroom.student.h06;

public class WarFactory extends GameBase {
	public WarFactory(int x, int y) {
		// TODO Auto-generated constructor stub
		super(100, 0, 0, x, y);
	}

	public Tank building(EnumObjectType type) {
		Tank obj;
		switch (type) {
		case mediumTank:
			obj = new MediumTank(this.x, this.y);
			break;
		case heavyTank:
			obj = new HeavyTank(this.x, this.y);
			break;
		default:
			obj = new Tank();
			break;
		}
		return obj;
	}
}
