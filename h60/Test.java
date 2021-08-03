/**
 * 
 */
package com.huawei.classroom.student.h60;

/**
 * @author Administrator
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 在ChatServer,ChatClient中增加适当代码，并增加适当的类，完成一个简单的聊天室
		// user.txt中存放了所有用户的用户名和口令 用\t分割
		String ip = "127.0.0.1";
		int port = 9090;
		String passwordFile = "D://javacode/my_test/src/com/huawei/classroom/student/h60/user.txt";
		ChatServer server;
		try {
			server = new ChatServer(port, passwordFile);

			// 1 服务器启动监听
			server.startListen();
			// System.out.println("hahaha");
			ChatClient zhang = new ChatClient(ip, port);
			ChatClient li = new ChatClient(ip, port);
			ChatClient wang = new ChatClient(ip, port);

			// 2 客户1 登录成功
			if (zhang.login("zhang", "123")) {
				System.out.println("pass1");
			}
			// System.out.println(zhang.login("zhang", "123"));

			// 3 客户2 登录成功
			if (li.login("li", "456")) {
				System.out.println("pass2");
			}

			// 3 客户3 登录失败
			if (!wang.login("zhao", "123")) {
				System.out.println("pass3");
			}
			String str1 = "I am zhang";
			zhang.speak(str1);
			// 3 wang没有登录成功，所以读到的是null
			if (str1.equals(zhang.read()) && str1.equals(li.read()) && (null == wang.read())) {
				System.out.println("pass4");
			}

			zhang.logout();
			str1 = "I am li";
			li.speak(str1);
			// 4 zhang logout了
			if (str1.equals(li.read()) && (null == zhang.read()) && (null == wang.read())) {
				System.out.println("pass5");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
