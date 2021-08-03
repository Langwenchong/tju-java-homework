/**
 * 
 */
package com.huawei.classroom.student.h02;

/**
 * 
 * 作业
 * @author Administrator
 *
 */
public class Home02 {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		if(Math.abs(calcArea(1)-3.14)<0.1) {
			System.out.println(" calcArea pass!");
		} 
		if(Math.abs((getSum(1,100)-5050)/5050)<0.1) {
			System.out.println(" getSum pass!");
		} 
		if(isTriangle(1,1,1)) {
			System.out.println(" isTriangle pass!");
		} 
		if(isEq(0.1f,0.10000000001f)) {
			System.out.println(" isEq pass!");
		} 
		if(getGrade(84)=='B') {
			System.out.println(" getGrade pass!");
		} 
		if(isPrime(13) ) {
			System.out.println(" isPrime pass!");
		} 
		if(getEvenSum(0,4)==6 ) {
			System.out.println(" getEvenSum pass!");
		} 
		if(getMax(1,-1,8)==8 ) {
			System.out.println(" getMax pass!");
		} 
		
	}
	
	/**
	 * 修改代码
	 * 计算圆的面积
	 * 难度系数1星
	 * @param radius
	 * @return
	 */
	public static float calcArea(final float radius) {
		/**可修改代码开始，以下部分代码存在错误，请修正***/
		final float pi=(float)3.14  ;
		return pi*radius*radius;
		/**可修正代码结束****/
	}

	
	/**
	 * 修改代码
	 * 计算a+ a+1 + .... b的和
	 * 难度系数1星
	 * @return
	 */
	public static double getSum(final int a,final int b  ) {
		/**可修改代码开始，以下部分代码存在错误，请修正***/
		double sum=0;
		for(int i=a;i<=b;i++) {
			sum=sum+i;
		}
		return sum;
		/**可修正代码结束****/
	}
	
	/**
	 * 完成代码
	 * 判断a,b,c是否能够构成三角形的三个边
	 * 难度系数1星
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */

	public static boolean isTriangle(final int a,final int b,final int c) {
		//完成本函数里面的代码
		if(a+b<=c||a+c<=b||b+c<=a)
			return false; 
		else 
			return true;
	}	
	
	/**
	 *  完成代码
	 * 判断两个浮点数是否相等，一般认为如果两个浮点数的差值小于0.0001，即认为相等
	 * 难度系数1星
	 * @param f1
	 * @param f2
	 * @return
	 */
	public static boolean isEq(final float f1, final float f2) {
		//完成本函数里面的代码
		if(Math.abs(f1-f2)>=0.0001)
			return false; 
		else
			return true;
	}
	/**
	 *  完成代码
	 * 将学生百分之成绩变换为A(>=90,B>=80且非A,C>=70且非B,D>=60且非C,E 其他)
	 * 难度系数1星
	 * @param score
	 * @return
	 */
	public static char getGrade(final int score) {
		//完成本函数里面的代码
		if(score>=90)
			return 'A';
		else if(score>=80&&score<90)
			return 'B';
		else if(score>=70&&score<80)
			return 'C';
		else if(score>=60&&score<70)
			return 'D';
		else
			return 'E';
	}
	/**
	 *  完成代码
	 * 判断一个数字是否是质数，如果是质数返回true，否则false
	 * 难度系数1星
	 * @param i
	 * @return
	 */
	public static boolean isPrime(final int i) {
		// 完成本函数里面的代码
		boolean v=true;
		for(int k=2;k<=i-1;k++) {
			if(i%k==0) {
				v=false;
				break;
			}
		}
		if(v)
			return true;
		else
			return false;
	}
	
	
	
	/**
	 *  完成代码
	 * 返回大于等于i，且小于等于j的所有的偶数的加和
	 * 难度系数1星
	 * @param i
	 * @param j
		 * @return
	 */
	public static int getEvenSum(final int i,final int j) {
		// 完成本函数里面的代码
		int sum=0;
		for(int k=i;k<=j;k++) {
			if(k%2==0)
				sum+=k;
		}
		return sum;
	}
	
	/**
	 *  完成代码
	 * 返回i,j,k中的最大值
	 * 难度系数1星
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	public static int getMax(final int i,final int j,final int k) {
		// 完成本函数里面的代码
		final int tmp=Math.max(i, j);
		return Math.max(tmp, k);
	}
	

}
