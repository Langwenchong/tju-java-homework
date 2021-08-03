package com.huawei.classroom.student.h60;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServerThread extends ChatServer implements Runnable {

	Map<String, String> map = new HashMap<>();
	public Socket socket;

	public ChatServerThread(Socket socket) {
		this.socket = socket;
		this.map = ChatServer.map;
	}

	public void run() {
		try {
			BufferedReader in = null;
			BufferedWriter out = null;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String line = in.readLine();
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				// System.out.println(line);
				// System.out.println(this.map);
				if (line.substring(0, 5).equals("login")) {
					String arr[] = line.split(" ");
					if (this.map.containsKey(arr[1]) && arr[2].equals(this.map.get(arr[1]))) {
						out.write("login success!\r\n");
						out.flush();
						// System.out.println("respond");
					} else {
						out.write("login fail!\r\n");
						out.flush();
					}
					// close();
				} else if (line.equals("logout")) {
					out.write("logout success!\r\n");
					out.flush();
					break;
				} else if (line.substring(0, 5).equals("speak")) {
					String[] mes = line.split("\\+");
					ChatServer.message = mes[1];
					// System.out.println(ChatServer.message);
					// close();
				} else if (line.equals("read!")) {
					out.write(ChatServer.message + "\r\n");
					out.flush();
					// System.out.println("hhh");
					// close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
