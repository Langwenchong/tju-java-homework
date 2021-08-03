package com.huawei.classroom.student.h07;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 某一款游戏，其主要角色如下:
		// 游戏中每个对象有当前 x,y坐标，坐标值 取值范围为整数。
		// 非建筑物可以通过move(dx,dy)来移动坐标值,dx,dy表示x轴,y轴增量, 取值范围为整数。
		// 对象A攻击B的时候，要满足两个对象之间直线距离小于等于A的攻击范围,否则攻击无效（被攻击方不减健康值）
		// 任何对象有getHealth() 方法，返回当前生命值，如果已经死亡则返回 <=0的一个数字
		// 任何对象有isDestroyed() 方法，如果生命值<=0则true,否则false

		// GameBase 玩家基地 初始生命值500，无攻击力，初始x,y值在创建时指定
		// Barrack 兵营，可以训练出步枪兵、 RPG兵、军犬,初始生命值100，无攻击力，初始x,y值在创建时指定
		// Rifle soldier 步枪兵 初始生命值50(对战 军犬除外)，攻击力 5（对战军犬可以一次击毙军犬)，攻击范围5,初始x,y值就是兵营的x,y
		// RPG soldier 火箭兵 初始生命值50(对战 军犬除外)，攻击力 10 ，攻击范围10，初始x,y值就是兵营的x,y
		// Dog 军犬 ,初始生命值50，攻击力5(对战人类时候一口毙命)，攻击范围5，初始x,y值就是兵营的x,y
		// 此外还要能通过Soldier.getLivingSoldierCount/getDeadedSoldierCount
		// 统计现在有多少个活着的和死去的士兵数量
		// 请遵循以上游戏规则，并根据如下测试代码设计代码
		// 作业批改的时候，方法可能不同组合
		// 例如让一个物体移动,超出或者进入攻击范围，判断是否攻击有效
		// 让一个物体制造出来以后，不移动，然后另一个物体攻击，判断该物体是否使用了默认的x,y

		//////////////// h07作业内容 /////////////////////////////////
		// 本作业给出了一部分代码，但是这些代码实现有错误，要么无法编译通过，要么存在错误
		// 不许修改现有类的名字，不许修改现有的继承关系，不许增加新的类，可以在现在代码基础上改动
		// 使得作业代码能够完成本作业要求的测试

		GameBase gameBase = GameBase.createGameBase(10, 10);

		if (gameBase.getHealth() == 500) {
			System.out.println("ok1");
		}
		Barrack barrack = (Barrack) gameBase.building(EnumObjectType.barrack, 20, 20);
		if (barrack.getHealth() == 100) {
			System.out.println("ok2");
		}
		// traing 训练出新的士兵或者狗
		RifleSoldier rifleSoldier1 = (RifleSoldier) barrack.traing(EnumObjectType.rifleSoldier);
		if (rifleSoldier1.getHealth() == 50) {
			System.out.println("ok3");
		}
		RPGSoldier rPGSoldier1 = (RPGSoldier) barrack.traing(EnumObjectType.RPGSoldier);
		if (rPGSoldier1.getHealth() == 50) {
			System.out.println("ok4");
		}
		Dog dog1 = (Dog) barrack.traing(EnumObjectType.dog);
		if (dog1.getHealth() == 50) {
			System.out.println("ok5");
		}

		// 移动的是坐标值增量
		rPGSoldier1.move(10, 10);
		rifleSoldier1.attack(rPGSoldier1);
		// 攻击无效，距离太远，health
		if (rPGSoldier1.getHealth() == 50) {
			System.out.println("ok6");
		}

		rifleSoldier1.move(7, 6);
		rifleSoldier1.attack(rPGSoldier1);
		// System.out.println(rPGSoldier1.getHealth());
		if (rPGSoldier1.getHealth() == 45) {
			System.out.println("ok7");
		}

		dog1.attack(rPGSoldier1);
		if (rPGSoldier1.getHealth() == 45) {
			System.out.println("ok8");
		}

		dog1.move(10, 10);
		rPGSoldier1.attack(dog1);
		if (dog1.getHealth() == 40) {
			System.out.println("ok9");
		}

		dog1.attack(rPGSoldier1);
		dog1.attack(rPGSoldier1);
		// System.out.println(rPGSoldier1.getHealth());
		if (rPGSoldier1.isDestroyed()) {
			System.out.println("ok10");
		}

		rifleSoldier1.attack(dog1);
		if (dog1.isDestroyed()) {
			System.out.println("ok11");
		}
		// System.out.println(Soldier.getDeadedSoldierCount());
		if (Soldier.getDeadedSoldierCount() == 1) {
			System.out.println("ok12");
		}
		if (Soldier.getLivingSoldierCount() == 1) {
			System.out.println("ok13");
		}

		if (gameBase instanceof GameObject) {
			System.out.println("ok14");
		}

		if (rifleSoldier1 instanceof GameObject) {
			System.out.println("ok15");
		}
		if (barrack instanceof Building) {
			System.out.println("ok16");
		}

	}

}
