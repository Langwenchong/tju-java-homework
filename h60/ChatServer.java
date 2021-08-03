package com.huawei.classroom.student.h60;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer extends Thread {
	/**
	 * 初始化 ， 根据情况适当抛出异常
	 * 
	 * @param port
	 * @param passwordFilename
	 *            所有用户的用户名 口令
	 */
	public int port;
	public static Map<String, String> map = new HashMap<>();
	public static String message = "";
	BufferedReader in = null;
	BufferedWriter out = null;
	ServerSocket server = null;
	Socket socket = null;

	public ChatServer() {
	}

	public ChatServer(int port, String passwordFilename) throws IOException {
		this.port = port;
		map.clear();
		try {
			List<String> txt = readLines(passwordFilename);
			for (String line : txt) {
				// System.out.println(line);
				String arr[] = line.split("\t");
				// System.out.println(arr[0]);
				if (!map.containsKey(arr[0])) {
					map.put(arr[0], arr[1]);
				}
			}
			// System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> readLines(String fsrc) {
		List<String> lines = new ArrayList<String>();
		try {
			Reader reader = new InputStreamReader(new FileInputStream(fsrc));
			// LineNumberReader 必须在其他流基础上构建
			LineNumberReader in = new LineNumberReader(reader);
			for (String line = ""; line != null; line = in.readLine()) {
				if (line.length() < 3 || line.charAt(0) == '#')
					continue;
				lines.add(line);
				// System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}

	/**
	 * 根据情况适当抛出异常 开始监听
	 */
	public void startListen() throws Exception {

		Thread serverThread = new Thread(this);
		serverThread.start();

	}

	public void run() {
		try {
			ServerSocket server = new ServerSocket(this.port);
			while (true) {
				Socket socket = server.accept();
				new Thread(new ChatServerThread(socket)).start();
				// System.out.println("create thread");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// public void run() {
	// try {
	// server = new ServerSocket(this.port);
	// socket = server.accept();
	// in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	// String line = in.readLine();
	// out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	// System.out.println(line);
	// if (line.substring(0, 5).equals("login")) {
	// String arr[] = line.split(" ");
	// if (this.map.containsKey(arr[1]) && arr[2].equals(map.get(arr[1]))) {
	// out.write("login success!\r\n");
	// out.flush();
	// // System.out.println("respond");
	// } else {
	// out.write("login fail!\r\n");
	// out.flush();
	// }
	// // close();
	// } else if (line.equals("logout")) {
	// out.write("logout success!");
	// out.flush();
	// // close();
	// } else if (line.substring(0, 5).equals("speak")) {
	// String mes[] = line.split("+");
	// message = mes[1];
	// // close();
	// } else {
	// out.write(this.message);
	// out.flush();
	// // close();
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

}
