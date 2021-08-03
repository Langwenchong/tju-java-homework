package com.huawei.classroom.student.h05;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 某一款游戏，其主要角色如下:
		// Tank HeavyTank 重型坦克 初始生命值200，攻击力 20
		// Medium Tank 轻型坦克 初始生命值100，攻击力 10
		// War Factroy 兵工厂 初始生命值100，无攻击力
		// Barrack 兵营，可以训练出步枪兵、 RPG兵、军犬,初始生命值100，无攻击力
		// Rifle soldier 步枪兵 初始生命值50(对战 军犬除外)，攻击力 5（对战军犬可以一次击毙军犬)
		// Rocket soldier 火箭兵 初始生命值50(对战 军犬除外)，攻击力 10
		// Dog 军犬 ,初始生命值50，攻击力5(对战人类时候一口毙命)
		// 此外还要能通过Soldier.getLivingSoldierCount/getDeadedSoldierCount
		// 统计现在有多少个活着的和死去的士兵数量
		// 请遵循以上游戏规则，并根据如下测试代码设计代码
		// 作业批改的时候，除了如下调用的方法以外，不会增加新的调用方法，但是可能有不同的组合方式
		// 例如让一个Dog反复攻击HeavyTank，判断HeayTank.getHealth()
		// 任何对象有getHealth() 方法，返回当前生命值，如果已经死亡则返回 <=0的一个数字
		Barrack barrack = new Barrack();
		if (barrack.getHealth() == 100) {
			System.out.println("ok1");
		}
		// traing 训练出新的士兵或者狗
		RifleSoldier rifleSoldier1 = (RifleSoldier) barrack.traing(EnumObjectType.rifleSoldier);
		if (rifleSoldier1.getHealth() == 50) {
			System.out.println("ok2");
		}
		RPGSoldier rPGSoldier1 = (RPGSoldier) barrack.traing(EnumObjectType.RPGSoldier);
		if (rPGSoldier1.getHealth() == 50) {
			System.out.println("ok3");
		}
		Dog dog1 = (Dog) barrack.traing(EnumObjectType.dog);
		if (dog1.getHealth() == 50) {
			System.out.println("ok4");
		}
		// 构造新的兵工厂
		WarFactory warFactory = new WarFactory();
		if (warFactory.getHealth() == 100) {
			System.out.println("ok5");
		}
		// building 建造各自型号坦克
		Tank mediumTank1 = (MediumTank) warFactory.building(EnumObjectType.mediumTank);
		if (mediumTank1.getHealth() == 100) {
			System.out.println("ok6");
		}

		Tank heavyTank1 = (HeavyTank) warFactory.building(EnumObjectType.heavyTank);
		if (heavyTank1.getHealth() == 200) {
			System.out.println("ok7");
		}
		mediumTank1.attack(rifleSoldier1);
		// 被mediumTank1攻击一次，health-10
		if (rifleSoldier1.getHealth() == 40) {
			System.out.println("ok8");
		}

		dog1.attack(rifleSoldier1);
		// 被 dog 攻击一次，health<=0
		if (rifleSoldier1.isDestroyed()) {
			System.out.println("ok9");
		}

		mediumTank1.attack(dog1);
		// 被攻击后 health-10
		if (dog1.getHealth() == 40) {
			System.out.println("ok10");
		}
		RifleSoldier rifleSoldier2 = (RifleSoldier) barrack.traing(EnumObjectType.rifleSoldier);
		// 被RifleSoldier攻击 一击毙命
		rifleSoldier2.attack(dog1);
		if (dog1.isDestroyed()) {
			System.out.println("ok11");
		}
		// Soldier 当前活着的数量2（rifleSoldier2，rPGSoldier1），死亡的数量1（rifleSoldier1）
		if (Soldier.getLivingSoldierCount() == 2 && Soldier.getDeadedSoldierCount() == 1) {
			System.out.println("ok12");
		}
	}

}
