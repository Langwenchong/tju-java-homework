package com.huawei.classroom.student.h58;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VoteRecord {
	/**
	 * fileName是一个投票的明细记录，里面逐行存放了 投票的时间（yyyy-MM-dd HH:mm:ss 格式） +\t+投票的微信ID+\t+候选人
	 * 存放按时间递增（但是可能出现同一秒出现若干条记录的情况） 现在需要完成投票统计的过程，具体要求如下： 1个微信ID 1分钟内 最多投1票 多余的票数无效
	 * 1个微信ID 10分钟内 最多只能投5票 多余的票无效 其中微信ID不固定，候选人姓名不固定 测试的时候要求10万行记录处理时间不超过3秒
	 * 
	 * @param fileName
	 * @return 返回一个map，其中key是候选人名字，value的票数
	 */
	Map<String, List<String>> map = new LinkedHashMap();
	Map<String, Integer> ans = new LinkedHashMap();

	public Map<String, Integer> calcRecording(String fileName) {
		map.clear();
		List<String> txt = readLines(fileName);
		for (String key : txt) {
			// System.out.println(key);
			String[] arr = key.split("\t| ");
			// System.out.println(arr[3]);
			String time = arr[0] + " " + arr[1];
			// System.out.println(time);
			String id = arr[2];
			// System.out.println(id);
			String cand = arr[3];
			// System.out.println(cand);
			if (!map.containsKey(id)) {
				List<String> data = new ArrayList();
				data.clear();
				map.put(id, data);
			}
			check(id, time, cand);
		}
		return ans;
	}

	private void check(String id, String time, String cand) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (map.get(id).size() < 5) {
			flag = onemin_check(id, time);
		} else {
			flag = onemin_check(id, time) & tenmin_check(id, time);
		}
		if (flag) {
			map.get(id).add(time);
			if (ans.containsKey(cand)) {
				int num = ans.get(cand);
				num += 1;
				ans.put(cand, num);
			} else
				ans.put(cand, 1);
		}
	}

	private boolean tenmin_check(String id, String time) {
		// TODO Auto-generated method stub
		String ref = map.get(id).get(map.get(id).size() - 5);
		if (!ref.substring(0, 10).equals(time.substring(0, 10)))
			return true;
		String arr1[] = ref.split(" ");
		String[] time1 = arr1[1].split(":");
		// System.out.println(time1[0]);
		String arr2[] = time.split(" ");
		String[] time2 = arr2[1].split(":");
		// System.out.println(time2[0]);
		int num1 = Integer.valueOf(time1[0]) * 3600 + Integer.valueOf(time1[1]) * 60 + Integer.valueOf(time1[2]);
		int num2 = Integer.valueOf(time2[0]) * 3600 + Integer.valueOf(time2[1]) * 60 + Integer.valueOf(time2[2]);
		if (num2 - num1 >= 600)
			return true;
		else
			return false;
	}

	private boolean onemin_check(String id, String time) {
		// TODO Auto-generated method stub
		if (map.get(id).size() <= 0)
			return true;
		String ref = map.get(id).get(map.get(id).size() - 1);
		if (!ref.substring(0, 10).equals(time.substring(0, 10)))
			return true;
		String arr1[] = ref.split(" ");
		// for (int i = 0; i < arr1.length; i++)
		// System.out.println(arr1[i]);
		String[] time1 = arr1[1].split(":");
		String arr2[] = time.split(" ");
		String[] time2 = arr2[1].split(":");
		int num1 = Integer.valueOf(time1[0]) * 3600 + Integer.valueOf(time1[1]) * 60 + Integer.valueOf(time1[2]);
		int num2 = Integer.valueOf(time2[0]) * 3600 + Integer.valueOf(time2[1]) * 60 + Integer.valueOf(time2[2]);
		if (num2 - num1 >= 60)
			return true;
		else
			return false;
	}

	public static List<String> readLines(String fsrc) {
		List<String> lines = new ArrayList<String>();
		try {
			Reader reader = new InputStreamReader(new FileInputStream(fsrc));
			// LineNumberReader 必须在其他流基础上构建
			LineNumberReader in = new LineNumberReader(reader);
			for (String line = ""; line != null; line = in.readLine()) {
				if (line.length() < 3 || line.charAt(0) == '#' || line.equals(""))
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
