package com.huawei.classroom.student.h52;

import java.util.HashSet;
import java.util.Set;

public class NumDecompose {
	/**
	 * 将num进行质因数分解，将分解到的质因数放到Set里面返回
	 */
	public Set<Integer> decompose(int num) {
		Set ans = new HashSet();
		int i = 2;
		while (i <= num) {
			if (num % i == 0) {
				ans.add(i);
				num /= i;
				i = 2;
			} else {
				i++;
			}
		}
		return ans;
	}
}
