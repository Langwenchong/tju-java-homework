package com.huawei.classroom.student.h62;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 本题目复杂度比较高，请大家耐心逐步完成,
			// 口令文件参见 my_user.txt
			// 测试目录参见 /test/
			// 构造一个能够用户socket访问和控制远程文件的项目
			// MyDaemon 服务器端
			// 服务器端启动的时候，配置信息存在MyDeamonConfigVo 中
			String remoteHome = "D://javacode/my_test/src/com/huawei/classroom/student/h62/test/";
			MyDeamonConfigVo config = new MyDeamonConfigVo();
			// 根目录在什么地方
			config.setRoot(remoteHome);
			// 监听端口号
			config.setPort(9999);
			// 存放了用户名 口令 的认证数据文件
			config.setPasswordFile("D://javacode/my_test/src/com/huawei/classroom/student/h62/my_user.txt");
			// 构造我的监听类
			MyDaemon deamon = new MyDaemon(config);
			// 启动
			deamon.start();

			System.out.println("第1步 启动远程deamon 完成 !");

			// 定义远程主机的类
			MyHost host = new MyHost();
			// IP
			host.setIp("127.0.0.1");
			// 端口，就是config里面订单端口
			host.setPort(config.getPort());
			// 用户名
			host.setUsername("a");
			// 口令
			host.setPassword("1");
			// 构造一个远程文件

			MyRemoteFile home = new MyRemoteFile(host, "/");
			// 按名字升序列出子目录和文件 ，dirByNameAsc() 按名字升序列出孩子(先列目录，然后列文件，按升序)，放到一个数组中
			MyRemoteFile[] children = home.dirByNameAsc();
			MyRemoteFile c0 = children[0];
			// System.out.println(c0.getPathFileName());
			MyRemoteFile c1 = children[1];
			MyRemoteFile c2 = children[2];
			for (int i = 0; i < children.length; i++) {
				System.out.println(children[i].getPathFileName());
				// System.out.println(children[i].isFile());
			}
			System.out.println("第2步 如果下面3个打印出来都是true dirByNameAsc 完成 !");
			// System.out.println(children);
			// isDirectory() 是否是目录； isFile()是否是文件; getPathFileName() 得到从remoteHome
			// 相对算其的路径+文件名 以/开头，路径分隔符用 /
			System.out.println(c0.isDirectory() && (!c0.isFile()) && "/dir1/".equals(c0.getPathFileName()));
			System.out.println(!c1.isDirectory() && (c1.isFile()) && "/a.txt".equals(c1.getPathFileName()));
			System.out.println(!c2.isDirectory() && (c2.isFile()) && "/b.txt".equals(c2.getPathFileName()));

			// 再次列出孩子
			children = c0.dirByNameAsc();
			MyRemoteFile c3 = children[0];
			System.out.println(c3.getPathFileName());
			System.out.println("第3步 如果下面打印出来都是true 则列孩子的 dirByNameAsc 完成 !");
			System.out.println(!c3.isDirectory() && (c3.isFile()) && "/dir1/c.txt".equals(c3.getPathFileName()));

			MyRemoteFile file2 = new MyRemoteFile(host, "/test.txt");

			String content = "abc";
			// 输入这个文件
			file2.writeByBytes(content.getBytes("UTF-8"));
			System.out.println(!file2.isDirectory() && (file2.isFile()) && "/test.txt".equals(file2.getPathFileName()));
			System.out.println("第4步 如果 上面打印出来是true , remoteHome 目录下存在/test.txt,且内容为content,  向远程写文件完成!");

			MyRemoteFile file3 = new MyRemoteFile(host, "/test.txt");

			// length()文件的大小
			// System.out.println(file3.length());
			if (file3.length() == content.getBytes().length) {
				System.out.println("第5步 检索远程文件信息通过!");
			}

			// 删除远程文件
			file2.delete();
			MyRemoteFile file4 = new MyRemoteFile(host, "/test.txt");
			if (!file4.exists() && file4.length() == 0) {
				System.out.println("第6步 删除远程文件信息通过!");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
