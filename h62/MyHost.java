package com.huawei.classroom.student.h62;

public class MyHost {

	private String username;
	private String password;
	public boolean isLogIn = false;

	public void setIp(String string) {
		// TODO Auto-generated method stub

	}

	public void setUsername(String name) {
		// TODO Auto-generated method stub
		this.username = name;
	}

	public void setPort(Object port) {
		// TODO Auto-generated method stub

	}

	public void setPassword(String psw) {
		// TODO Auto-generated method stub
		this.password = psw;
	}

	public void logIn() {
		if (Base.map.containsKey(username) && Base.map.get(username) == this.password) {
			this.isLogIn = true;
		} else {
			this.isLogIn = false;
		}
	}

}
