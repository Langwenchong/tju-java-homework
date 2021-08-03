package com.huawei.classroom.student.h10;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 把你作业的代码写到这个类里面 不可以修改类的名字、包名、和固有的几个方法名以及方法的可见性 可以增加其他方法、属性、类 可以引用jdk的类
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Home10 {
	public Home10() {
	}

	/**
	 * 将一个字符串中字符按出现频率的高到低排序返回，如果两个字符出现的频率一样，则将最先出现的字符排在前面 例如：orderChar(“abcdefg”)返回
	 * “abcdefg” orderChar(“abcdefgg”)返回 “gabcdef” orderChar(“abcdefgge”)返回
	 * “egabcdf” orderChar(“天津大学软件学院”)返回 “学天津大软件院”
	 * 
	 * @param content
	 * @return
	 */
	public String orderChar(String content) {
		// 字符串参数转字符数组
		char[] arr = content.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		// 必须是LinkedHashMap，这样保证存入的时候按照存入先后顺序存放
		// 存入map并统计每一个字符的出现频率
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int tmp = map.get(arr[i]);
				map.put(arr[i], tmp + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		// 设置列表，存入map的键值对集合
		List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());
		// 重写比较函数，按照频率从高到低排序，同频率的字符还保持插入的先后顺序
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> arg0, Map.Entry<Character, Integer> arg1) {
				return arg1.getValue() - arg0.getValue();
			}
		});
		// 答案变量
		StringBuffer ans = new StringBuffer();
		// Iterator迭代列表
		for (Map.Entry<Character, Integer> item : list) {
			char key = item.getKey();
			// ans加上这个字符
			ans.append(key);
		}
		// 转成字符串输出
		return ans.toString();
	}

}
