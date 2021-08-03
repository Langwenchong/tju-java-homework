package com.huawei.classroom.student.h08;

public class Bank {
	private int money;

	public void save(int money) {
		this.money = money;
	}

	public void get(int money) throws NoMoneyException {
		if (this.money > money) {
			this.money -= money;
		} else {
			throw new NoMoneyException();
		}
	}
}
