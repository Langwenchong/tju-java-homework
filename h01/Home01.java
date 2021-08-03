/**
 * 
 */
package com.huawei.classroom.student.h01;

/**
 * 本程序存在错误，请修改本程序存在的错误，完成hello world程序
 * 
 * @author Administrator
 *
 */
public class Home01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("hello world");
		// int a[] = new int[6];
		// System.out.println(a[5]);
		// String str = "123";
		// Object obj = str;
		// // 那么很明显此时obj不光是Object的实例化对象，同时它也属于String
		// if (obj instanceof String) {
		// System.out.println("ok");
		// } // true
		Son son = new Son();
		System.out.println(son.health);
		System.out.println(son.age);
		System.out.println(son.getHealth());
	}
}