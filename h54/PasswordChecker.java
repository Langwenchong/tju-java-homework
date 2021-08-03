/**
 * 
 */
package com.huawei.classroom.student.h54;

/**
 * @author Administrator
 *
 */
public class PasswordChecker {
	/**
	 * 判断一个口令是否是一个复杂度合法的口令，复杂度合法的口令有如下要求： 1 长度>=8 2 最少包含一个数字 3 最少包含一个小写英文字母 4
	 * 虽少包含一个大写英文字母 5 最少包含一个特殊字符 特殊字符定义为 ~!@#$%^&*()_+
	 * 
	 * 
	 */
	public boolean isValidPassword(String password) {
		int len = password.length();
		if (len < 8)
			return false;
		char arr[] = password.toCharArray();
		boolean numok = false;
		boolean upperCok = false;
		boolean lowerCok = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - '0' >= 0 && arr[i] - '0' <= 9)
				numok = true;
			if (arr[i] >= 'a' && arr[i] <= 'z')
				lowerCok = true;
			if (arr[i] >= 'A' && arr[i] <= 'Z')
				upperCok = true;
		}
		if (numok && lowerCok && upperCok)
			return true;
		else
			return false;
	}
}
