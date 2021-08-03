package com.huawei.classroom.student.h62;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MyRemoteFile {
	public MyHost myHost;
	public String fileAddr;
	public Map<String, MyRemoteFile> dirMap = new TreeMap<>();
	public Map<String, MyRemoteFile> fileMap = new TreeMap<>();

	public MyRemoteFile(MyHost host, String string) {
		this.myHost = host;
		this.fileAddr = string;
	}

	public MyRemoteFile[] dirByNameAsc() {
		this.dirMap.clear();
		this.fileMap.clear();
		File f = new File(Base.root + this.fileAddr);
		if (f.isDirectory()) {
			for (File temp : f.listFiles()) {
				if (temp.isDirectory()) {
					this.dirMap.put(temp.getName(),
							new MyRemoteFile(this.myHost, this.fileAddr + temp.getName() + "/"));
				}
				if (temp.isFile()) {
					this.fileMap.put(temp.getName(), new MyRemoteFile(this.myHost, this.fileAddr + temp.getName()));
				}
			}
		}
		MyRemoteFile[] result = new MyRemoteFile[f.listFiles().length];
		int index = 0;
		Iterator<Entry<String, MyRemoteFile>> it_dir = this.dirMap.entrySet().iterator();
		while (it_dir.hasNext()) {
			Entry<String, MyRemoteFile> en = it_dir.next();
			result[index] = en.getValue();
			index++;
		}
		Iterator<Entry<String, MyRemoteFile>> it_file = this.fileMap.entrySet().iterator();
		while (it_file.hasNext()) {
			Entry<String, MyRemoteFile> en = it_file.next();
			result[index] = en.getValue();
			index++;
		}
		return result;
	}

	public boolean isDirectory() {
		File f = new File(Base.root + this.fileAddr);
		if (f.isDirectory())
			return true;
		return false;
	}

	public boolean isFile() {
		File f = new File(Base.root + this.fileAddr);
		if (f.isFile())
			return true;
		return false;
	}

	public Object getPathFileName() {
		return this.fileAddr;
	}

	public void writeByBytes(byte[] bytes) {
		File f = new File(Base.root + this.fileAddr);
		if (f.exists() == false) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		OutputStream out;
		try {
			out = new FileOutputStream(f, false);
			out.write(bytes);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int length() {
		File file = new File(Base.root + this.fileAddr);
		return (int) file.length();
	}

	public void delete() {
		File f = new File(Base.root + this.fileAddr);
		f.delete();
	}

	public boolean exists() {
		return false;
	}

}
