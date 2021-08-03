package com.huawei.classroom.student.h12;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Home12 {
	public Home12() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开 请找出
	 * 哪n(n>=1)个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回
	 * 
	 * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
	 * @param n
	 * @return 哪n个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回 不会出现并列的情况
	 */
	public Set<String> getFrequentItem(String content, int n) {
		// map统计商品组合的频率
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 拆分出每一次购买的物品组合
		String[] comb = content.split(";");
		for (int i = 0; i < comb.length; i++) {
			// 拆分出每一件商品
			String[] goods = comb[i].split(",");
			// dfs枚举所有n个物品的组合
			dfs(map, goods, "", 0, 0, n);
		}
		// 获取最高频率的组合的字符串形式
		Collection<Integer> coll = map.values();
		int max = Collections.max(coll);
		String tmp = null;
		for (Map.Entry<String, Integer> it : map.entrySet()) {
			if (it.getValue() == max) {
				// 捕捉
				tmp = it.getKey();
			}
		}
		// 拆分出商品并存入数
		String[] ans = tmp.split(",");
		// 逐位放入set
		Set<String> set = new HashSet<String>();
		for (int k = 0; k < ans.length; k++) {
			set.add(ans[k]);
		}
		return set;
	}

	public void dfs(Map<String, Integer> map, String[] arr, String s, int idx, int num, int max) {
		// 达到n个商品的组合了
		if (num == max) {
			// 使用map统计
			if (map.containsKey(s)) {
				int number = map.get(s);
				map.put(s, number + 1);
			} else
				map.put(s, 1);
			return;
		}
		// 还未达到n个商品组合就枚举完了，不符合条件退出
		if (idx >= arr.length)
			return;
		// 不选这个商品
		dfs(map, arr, s, idx + 1, num, max);
		// 选这个商品
		s = s + arr[idx] + ",";
		dfs(map, arr, s, idx + 1, num + 1, max);
	}
}
