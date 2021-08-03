package com.huawei.classroom.student.h11;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Home11 {

	public Home11() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开 请找出
	 * 哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔 测试的时候，商品名称可能增加新的商品，例如方便面、面包...
	 * 
	 * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
	 * @return 哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
	 */
	public String getFrequentItem(String content) {
		// 使用Map进行统计
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 首先按照;对列表商品组合进行分割存储到数组中，因此数组中的每一个元素是一种组合
		String[] comb = content.split(";");
		for (int i = 0; i < comb.length; i++) {
			// 取出其中一种组合，按照,分割存入到goods数组中
			// 因此goods数组中存储的某个商品
			String[] goods = comb[i].split(",");
			for (int j = 0; j < goods.length; j++) {
				for (int k = j + 1; k < goods.length; k++) {
					// 枚举两个商品的组合方案
					String tmp = goods[j] + "," + goods[k];
					if (map.containsKey(tmp)) {
						// 如果这个两个商品的组合已经存在了，那么就对map中的这种组合频率++
						int number = map.get(tmp);
						map.put(tmp, number + 1);
					} else {
						// 否则将这个商品组合放入到map中
						map.put(tmp, 1);
					}
				}
			}
		}
		// 获取map最大频率的组合
		Collection<Integer> coll = map.values();
		int max = Collections.max(coll);
		for (Map.Entry<String, Integer> it : map.entrySet()) {
			if (it.getValue() == max) {
				// 根据最大频率值返还Key从而找到对应的最高频率商品组合
				return it.getKey();
			}
		}
		return "Error";
	}
}
