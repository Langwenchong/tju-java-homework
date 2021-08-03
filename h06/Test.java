package com.huawei.classroom.student.h06;

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
		// HeavyTank 重型坦克 初始生命值200，攻击力 20,攻击范围10,初始x,y值就是兵工厂的x,y
		// Medium Tank 轻型坦克 初始生命值100，攻击力 10，攻击范围10,初始x,y值就是兵工厂的x,y
		// War Factroy 兵工厂 初始生命值100，无攻击力 ，初始x,y值在创建时指定
		// Barrack 兵营，可以训练出步枪兵、 RPG兵、军犬,初始生命值100，无攻击力，初始x,y值在创建时指定
		// Rifle soldier 步枪兵 初始生命值50(对战 军犬除外)，攻击力 5（对战军犬可以一次击毙军犬)，攻击范围5,初始x,y值就是兵营的x,y
		// Rocket soldier 火箭兵 初始生命值50(对战 军犬除外)，攻击力 10 ，攻击范围10，初始x,y值就是兵营的x,y
		// Dog 军犬 ,初始生命值50，攻击力5(对战人类时候一口毙命)，攻击范围5，初始x,y值就是兵营的x,y
		// 此外还要能通过Soldier.getLivingSoldierCount/getDeadedSoldierCount
		// 统计现在有多少个活着的和死去的士兵数量
		// 请遵循以上游戏规则，并根据如下测试代码设计代码
		// 作业批改的时候，方法可能不同组合
		// 例如让一个物体移动,超出或者进入攻击范围，判断是否攻击有效
		// 让一个物体制造出来以后，不移动，然后另一个物体攻击，判断该物体是否使用了默认的x,y

		// 未来可能分玩家，例如玩家A，玩家B，玩家C
		// 未来可能玩家A战斗单元不能攻击自己的战斗单元
		// 未来玩家之间可能要结盟、取消结盟
		// 未来坦克攻击以后，造成的杀伤可能不是点杀伤，而是一个杀伤范围
		// ....

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
		// 构造新的兵工厂
		WarFactory warFactory = (WarFactory) gameBase.building(EnumObjectType.warFactory, 30, 30);
		if (warFactory.getHealth() == 100) {
			System.out.println("ok6");
		}
		// building 建造各自型号坦克
		Tank mediumTank1 = (MediumTank) warFactory.building(EnumObjectType.mediumTank);
		if (mediumTank1.getHealth() == 100) {
			System.out.println("ok7");
		}

		Tank heavyTank1 = (HeavyTank) warFactory.building(EnumObjectType.heavyTank);
		if (heavyTank1.getHealth() == 200) {
			System.out.println("ok8");
		}

		// 移动的是坐标值增量
		// System.out.println(heavyTank1.x + " " + heavyTank1.y);
		// System.out.println(rifleSoldier1.x + " " + rifleSoldier1.y);
		// System.out.println(dog1.x + " " + dog1.y);
		heavyTank1.move(10, 10);
		rifleSoldier1.move(5, 5);
		// System.out.println(heavyTank1.x + " " + heavyTank1.y);
		// System.out.println(rifleSoldier1.x + " " + rifleSoldier1.y);
		dog1.move(0, 0);
		mediumTank1.attack(heavyTank1);

		// 攻击无效，距离太远，health
		if (heavyTank1.getHealth() == 200) {
			System.out.println("ok9");
		}

		mediumTank1.attack(rifleSoldier1);
		if (rifleSoldier1.getHealth() == 40) {
			System.out.println("ok10");
		}
		// System.out.println(Soldier.getLivingSoldierCount());
		if (Soldier.getLivingSoldierCount() == 2) {
			System.out.println("ok11");
		}

	}

}
