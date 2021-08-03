package com.huawei.classroom.student.h62;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyDeamonConfigVo {

	public void setRoot(String remoteHome) {
		// TODO Auto-generated method stub
		Base.root = remoteHome;
	}

	public void setPort(int port) {
		// TODO Auto-generated method stub
		Base.port = port;

	}

	public void setPasswordFile(String psw) {
		// TODO Auto-generated method stub
		Base.map.clear();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(psw));
			String line = reader.readLine();
			while (true) {
				if (line.startsWith("#")) {
					line = reader.readLine();
					continue;
				}
				if (line.trim() == null) {
					line = reader.readLine();
					continue;
				}
				String[] content = line.split("\t");
				if (Base.map.containsKey(content[0]) == false) {
					Base.map.put(content[0], content[1]);
				}
				line = reader.readLine();
				if (line == null)
					break;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Object getPort() {
		// TODO Auto-generated method stub
		return null;
	}

}
