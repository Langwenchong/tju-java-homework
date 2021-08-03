package com.huawei.classroom.student.h16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer extends Thread {
	public int port;

	public void startListen(int port) {
		// 获取端口号并创建服务线程运行
		this.port = port;
		Thread serverThread = new Thread(this);
		serverThread.start();
	}

	@Override
	public void run() {
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			server = new ServerSocket(this.port);
			// 等待客户端连接
			socket = server.accept();
			// 输入/输出流
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 使用处理流按行读入
			String line = in.readLine();
			// 不是bye就一直读
			while (!line.equals("bye")) {
				// 写到输出流发给客户端
				out.write(line + "\r\n");
				// 注意每一次都要清空缓存区
				out.flush();
				// 读下一行
				line = in.readLine();
			}
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				// 关闭
				in.close();
				out.close();
				socket.close();
				server.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
