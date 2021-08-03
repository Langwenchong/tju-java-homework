package com.huawei.classroom.student.h19.q03;

public class ArrayUtil {
	public int getMin(int[] arr) {
		int min=1000;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) min=arr[i];
		}
		return min;
	}
}
