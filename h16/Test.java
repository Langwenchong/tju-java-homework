package com.huawei.classroom.student.h16;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Test {

	public static boolean testEcho(BufferedReader in, PrintWriter out, String line) throws IOException {
		out.write(line + "\r\n");
		out.flush();
		String echoline = in.readLine();
		if (line.equals(echoline)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 端口号测试的时候随机给
		int port = 8088;
		// 要求完成MyServer类
		new MyServer().startListen(port);
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			socket = new Socket("127.0.0.1", port);
			out = new java.io.PrintWriter(socket.getOutputStream());
			// 获得输入流
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 随机测试向服务器端输入几句话，要求服务器端原封不动返回
			if (testEcho(in, out, "hellow")) {
				System.out.println("ok 1");
			}
			if (testEcho(in, out, "haha")) {
				System.out.println("ok 2");
			}
			// 向服务器端输入bye，断开表示断开连接
			out.write("bye" + "\r\n");
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(in);
			close(out);
			close(socket);
		}
	}

	public static void close(Closeable inout) {
		if (inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
