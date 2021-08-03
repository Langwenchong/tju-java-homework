package com.huawei.classroom.student.h19.q04;

public class StrUtil {
	public Object removeDulpicatedChar(String s) {
		StringBuffer b=new StringBuffer();
		for(int i=0;i<s.length();i++) {
			if(s.indexOf(s.charAt(i))==i) {
				b.append(s.charAt(i));
			}
		}
		return b.toString();
	}
}
