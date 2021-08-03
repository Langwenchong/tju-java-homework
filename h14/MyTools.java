package com.huawei.classroom.student.h14;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 在本包下增加合适的类和方法， 本程序不但要测试通过，还需要写适当的注释
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class MyTools {

	/**
	 * 
	 * @param studentListFile
	 *            存放学生名单的文件名
	 * @param picDir
	 *            图片存放的目录（不会包含子目录）
	 */
	public MyTools() {
		// TODO Auto-generated constructor stub
	}

	// 存储学生对象的列表
	public List<Student> list = new ArrayList<Student>();
	// 存储最终没有交照片的学生的id
	public Set<String> ans = new HashSet<String>();

	public Set<String> copyToTargetDirAndReturnNoExist(String studentListFile, String srcDir, String target)
			throws Exception {
		// 按行读入students.txt
		// 这里写的不好，最好用readline();
		StringBuffer sb = new StringBuffer();
		char[] arr = new char[4096];
		Reader in = new InputStreamReader(new FileInputStream(studentListFile));
		int len = in.read(arr);
		while (len != -1) {
			sb.append(arr, 0, len);
			len = in.read(arr);
		}
		// 按照换行符切割得到每一个学生的信息
		String[] studentInfo = sb.toString().split("\n");
		for (String it : studentInfo) {
			// 注意这里还需要按照回车字符切割一次
			// 如果是readline()就不会出现这么麻烦的操作
			String[] info = it.split("[\\t,\\r]");
			// 根据信息创建学生对象
			Student obj = new Student(info[0], info[1], info[2]);
			list.add(obj);
		}
		// 创建srcDir的对象和targetDir的对象
		File srcDirectory = new File(srcDir);
		File targetDirectory = new File(target);
		if (!targetDirectory.exists()) {
			// 如果不存在需要创建
			boolean success = targetDirectory.mkdir();
			// System.out.println(success);
		}
		if (srcDirectory.isDirectory()) {
			// 将srcDir中的所有照片以名称字符串形式存储
			String[] picNames = srcDirectory.list();
			// 迭代每一个照片
			for (String pic : picNames) {
				// 对于每一个照片按照.切割得到id和jpg后缀
				String names[] = pic.split("\\.");
				// System.out.println(names[0]);
				// 寻找这个照片对应的学生
				Student student = Find(list, names[0]);
				// 如果未找到，说明这个照片不属于任何一个学生
				if (student != null) {
					// 找到了对应的学生
					// 创建照片对应的班级文件夹
					File classDirectory = new File(target + student._class);
					// System.out.println(target + student._class);
					if (!classDirectory.exists()) {
						Boolean success = classDirectory.mkdir();
						// System.out.println(success);
					}
					// 创建这名学生照片的文件指向对象
					File srcFile = new File(srcDir + pic);
					// System.out.println(target + student._class + "/" + student.id + "_" +
					// student.name + ".jpg");
					// 创建要拷贝到班级文件夹的照片对象
					File destFile = new File(target + student._class + "/" + student.id + "_" + student.name + ".jpg");
					// 复制
					copyFile(srcFile, destFile);
				}
			}
		}

		// 迭代每一个学生
		for (Student l : list) {
			// 如果未提交照片，就放入ans
			if (!l.isSubmit) {
				ans.add(l.id);
			}
		}
		return ans;
	}

	// 复制照片函数
	private void copyFile(File srcFile, File destFile) throws Exception {
		// TODO Auto-generated method stub
		if (!destFile.exists()) {
			// 首先创建这个要复制到的dest照片文件
			boolean sc = destFile.createNewFile();
			if (sc) {
				try {
					// 复制
					Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (Exception e) {
					System.out.println("Error!");
					e.printStackTrace();
				}
			}
		}
	}

	// 寻找照片对应的学生
	public Student Find(List<Student> list, String id) {
		for (Student key : list) {
			if (id.equals(key.id)) {
				// 找到了说明该学生提交了照片，更新submit
				key.isSubmit = true;
				return key;
			}
		}
		return null;
	}

}
