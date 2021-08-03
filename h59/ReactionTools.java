package com.huawei.classroom.student.h59;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReactionTools {
	Map<Set<String>, Set<String>> map = new HashMap<>();

	/**
	 * 根据reactionFile给出的一系列反应， 判断一个体系中根据init物质，判断出最后可能都存在什么物质
	 * 
	 * @param reactionFile
	 *            体系中初始反应物
	 * @param initComponents
	 *            体系中初始反应物
	 * @return 最后体系中存在的全部物质
	 */
	public Set<String> findAllComponents(String reactionFile, Set<String> initComponents) {
		List<String> list = readLines(reactionFile);
		// System.out.println(list);
		map.clear();
		for (String key : list) {
			// System.out.println(key);
			// 每一行方程式如"NaCl=Na+ + Cl-"
			Set<String> set1 = new HashSet<>();
			Set<String> set2 = new HashSet<>();
			// 按照=切割出反应物和生成物字符换
			String[] arr = key.split("=");
			// 反应物按照" "切割出反应物
			String[] fy_arr = arr[0].split(" ");
			// 生成物按照" "切割出生成物
			String[] sc_arr = arr[1].split(" ");
			// System.out.println(arr[0]);
			// System.out.println(arr[1]);
			// 存入set1,"+"和""不能存入
			for (int i = 0; i < fy_arr.length; i++) {
				if (fy_arr[i].equals("+") || fy_arr[i].equals(""))
					continue;
				set1.add(fy_arr[i]);
			}
			// System.out.println(set1);
			// 存入set2,"+"和""不能存入
			for (int i = 0; i < sc_arr.length; i++) {
				if (sc_arr[i].equals("+") || sc_arr[i].equals(""))
					continue;
				set2.add(sc_arr[i]);
			}
			// System.out.println(set2);
			// 存入map
			if (map.containsKey(set2)) {
				Set<String> tmp = map.get(set2);
				for (String b : set1) {
					tmp.add(b);
				}
				if (tmp != null)
					map.put(set2, tmp);
			} else {
				map.put(set2, set1);
			}
			if (map.containsKey(set1)) {
				Set<String> tmp = map.get(set1);
				for (String a : set2) {
					tmp.add(a);
				}
				if (tmp != null)
					map.put(set1, tmp);
			} else {
				map.put(set1, set2);
			}
		}
		System.out.println(map);
		// 迭代键集合，每一个键是一个集合Set
		for (int i = 0; i < map.size(); i++) {
			for (Set it : map.keySet()) {
				// 初始set包含it,就将其值集合吸收
				if (initComponents.containsAll(it)) {
					// System.out.println(it);
					// System.out.println(map.get(it));
					if (map.get(it) != null)
						initComponents.addAll(map.get(it));
				}
			}
		}

		return initComponents;
	}

	// 按行读入
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
}
