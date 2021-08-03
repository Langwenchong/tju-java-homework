package com.huawei.classroom.student.h60;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatClient {

	/**
	 * 根据情况适当抛出异常
	 * 
	 * @param ip
	 * @param port
	 */
	public String ip;
	public int port;
	public boolean login = false;
	Socket client = null;
	BufferedReader in = null;
	BufferedWriter out = null;

	public ChatClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	/**
	 * 登录,成功返回true，否则返回false，根据情况适当抛出异常
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean login(String userName, String password) {
		try {
			client = new Socket(this.ip, this.port);
			out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			out.write("login " + userName + " " + password + "\r\n");
			out.flush();
			// System.out.println("login");
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String line = in.readLine();
			// System.out.println(line);
			if (line.equals("login success!")) {
				this.login = true;
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private void close() {
		// TODO Auto-generated method stub
		try {
			this.in.close();
			this.out.close();
			this.client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 退出，根据情况适当抛出异常
	 */
	public void logout() {
		try {
			client = new Socket(this.ip, this.port);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			out.write("logout\r\n");
			out.flush();
			String line = in.readLine();
			if (line.equals("logout success!")) {
				this.login = false;
				close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发言, 只有登录以后才能发言， 根据情况适当抛出异常 如果没有登录 抛出异常
	 * 
	 * @param str
	 */
	public void speak(String str) {
		try {
			// System.out.println("speak");
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			if (this.login) {
				// System.out.println("hhhh");
				out.write("speak+" + str + "\r\n");
				out.flush();
			}
			// close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取聊天室目前的发言，根据情况适当抛出异常 只有登录以后才可以读到,否则返回null
	 * 得到聊天室里面所有的发言（包括自己的），如果此时没有发言则立刻返回null，否则每次调用read的时候按队的方式返回一个句话
	 */
	public String read() {
		if (!this.login) {
			return null;
		}
		try {
			out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			out.write("read!\r\n");
			out.flush();
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String mes = in.readLine();
			// System.out.println(mes);
			// close();
			return mes;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
