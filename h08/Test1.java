
package com.huawei.classroom.student.h08;


/**
 * 在本包下增加合适的类和方法，使得Test类能够测试通过
 * 不能通过修改Test的代码使得测试通过
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
 
public class Test1 {

	/**
	 * 
	 */
	public Test1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 完成Dog 类
		Dog dog=new Dog();
		
		try{
			//Dog最多只能调用feed()3次 第4次抛异常
			//
			dog.feed();
			dog.feed();
			dog.feed();
			System.out.println("做对了第1步");
			//做对了第1步
			//狗要撑死了
			dog.feed();
			//如果程序还能执行到这里 就要扣分了
			System.out.println("第2步做错了");
		
		}catch(Exception e){
			if(e.getMessage().equals("I can not eat more!")){
				System.out.println("做对了第2步");
				//做对了第2步
			}
		}
		

	}

}
