package com.huawei.classroom.student.h19.q05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class StudentUtil {
	private BufferedReader in;
	private LinkedHashSet<String> names = new LinkedHashSet<>();
	private LinkedHashMap<String, Integer> ch = new LinkedHashMap<>();
	private LinkedHashMap<String, Integer> math = new LinkedHashMap<>();
	private LinkedHashMap<String, Integer> en = new LinkedHashMap<>();
	private LinkedHashMap<String, Integer> ph = new LinkedHashMap<>();
	private LinkedHashMap<String, Integer> total = new LinkedHashMap<>();

	public String findmax() {
		int Max = -80;
		String Name = "";
		for (String key : total.keySet()) {
			if (total.get(key) > Max) {
				Name = key;
				Max = total.get(key);
			} else if (total.get(key) == Max) {
				if (ch.get(key) > ch.get(Name))
					Name = key;
				else {
					if (math.get(key) > math.get(Name))
						Name = key;
					else {
						if (en.get(key) > en.get(Name))
							Name = key;
					}
				}
			}
		}
		return Name;
	}

	public LinkedList<String> sort(String fn) {
		try {
			this.in = new BufferedReader(new FileReader(fn));
			String line;
			String[] words;
			while ((line = in.readLine()) != null) {
				words = line.split(",");
				if (!names.contains(words[0])) {
					names.add(words[0]);
				}
				if (words[1].equals("语文")) {
					if (!ch.containsKey(words[0])) {
						ch.put(words[0], Integer.parseInt(words[2].split(";")[0]));
					}

				} else if (words[1].equals("数学")) {
					if (!math.containsKey(words[0])) {
						math.put(words[0], Integer.parseInt(words[2].split(";")[0]));
					}
				} else if (words[1].equals("英语")) {
					if (!en.containsKey(words[0])) {
						en.put(words[0], Integer.parseInt(words[2].split(";")[0]));
					}
				} else {
					if (!ph.containsKey(words[0])) {
						ph.put(words[0], Integer.parseInt(words[2].split(";")[0]));
					}
				}
			}
			// 迭代计算总分
			for (String s : names) {
				if (!total.containsKey(s)) {
					total.put(s, 0);
				}
				int ch_grade = 0, math_grade = 0, eng_grade = 0, phg_grade = 0;
				if (ch.containsKey(s)) {
					ch_grade = ch.get(s);
				}
				if (math.containsKey(s)) {
					math_grade = math.get(s);
				}
				if (en.containsKey(s)) {
					eng_grade = en.get(s);
				}
				if (ph.containsKey(s)) {
					phg_grade = ph.get(s);
				}
				total.put(s, ch_grade + math_grade + eng_grade + phg_grade);
			}
			LinkedList<String> ans = new LinkedList<>();
			while (total.size() > 0) {
				String name = findmax();
				total.remove(name);
				ans.add(name);
			}
			return ans;
		} catch (Exception e) {
			System.out.println("Error" + e);
			e.printStackTrace();
			return new LinkedList<>();
		}
	}
}
