package com.huawei.classroom.student.h17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class BattleField {
	// 每一个对象的原型
	public static class Origin {
		public int health;
		public int attack;
		public int range;

		public int getHealth() {
			return health;
		}

		public void setHealth(int health) {
			this.health = health;
		}

		public int getAttack() {
			return attack;
		}

		public void setAttack(int attack) {
			this.attack = attack;
		}

		public int getRange() {
			return range;
		}

		public void setRange(int range) {
			this.range = range;
		}
	}

	// ini文件初始化时有以下原型类
	public static String[] arr = { "heavyTank", "mediumTank", "rifleSoldier", "RPGSoldier", "dog", "barrack",
			"warFactory", "base" };

	// 创建原型的数组
	public static Origin[] basic = new Origin[arr.length];
	// 玩家表
	public static List<Player> Players = new ArrayList<>();
	// 游戏对象表，可以参考test.java的作用
	public static List<GameObject> gameObjects = new ArrayList<>();

	// 初始哈所有原型的基础属性值
	public static void init(String src) {
		for (int i = 0; i < arr.length; i++) {
			basic[i] = new Origin();
		}
		gameObjects.clear();
		// 读入ini初始化文件
		List<String> txt = readFile(src);
		// if (txt == null)
		// System.out.println("true");
		for (int i = 0; i < txt.size(); i++) {
			// 特判
			if (txt.get(i).length() <= 3 || txt.get(i).charAt(0) == '#') {
				continue;
			}
			// 按照.(要转义)和=切割每一行的句子
			String[] contents = txt.get(i).split("=|\\.");
			// System.out.println(contents[2]);
			// 计算属性数值
			int num = Str2Int(contents[2]);
			// 为相应的原型类设置属性值
			for (int j = 0; j < arr.length; j++) {
				if (contents[0].equals(arr[j])) {
					// System.out.println(contents[1]);
					switch (contents[1]) {
					case "health":
						basic[j].health = num;
						break;
					// 注意ini文件攻击力名字为strength
					case "strength":
						basic[j].attack = num;
						break;
					case "range":
						basic[j].range = num;
						break;
					default:
						System.out.println("Error！");
						break;
					}
				}
			}
			// for (int j = 0; j < contents.length; ++j)
			// System.out.print(contents[j]);
			// System.out.println();
		}
	}

	// 根据字符串计算相对应的数值
	private static int Str2Int(String str) {
		// TODO Auto-generated method stub
		int ans = 0;
		int l = 0, r = str.length() - 1;
		while (str.charAt(l) > '9' || str.charAt(l) < '0')
			l++;
		while (str.charAt(r) > '9' || str.charAt(r) < '0')
			r--;
		// r+1不会截取
		ans = Integer.valueOf(str.substring(l, r + 1));
		// System.out.println(ans);
		return ans;
	}

	// 读入初始化文件
	private static List<String> readFile(String src) {
		// TODO Auto-generated method stub
		// 存储读入的每一行
		List<String> lines = new ArrayList<>();
		try {
			// 使用按行读入
			Reader reader = new FileReader(src);
			BufferedReader in = new BufferedReader(reader);
			String line = in.readLine();
			while (line != null) {
				lines.add(line);
				line = in.readLine();
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Open Error");
			e.printStackTrace();
		}
		return lines;
	}

	public static void createPlayer(String str) {
		Players.add(new Player(str));
	}

	public static List<Player> getAllPlayer() {
		return Players;
	}

	public static GameBase createGameBase(Player player, int x, int y) {
		GameBase obj = new GameBase(player.getPlayerName(), basic[7].health, basic[7].attack, basic[7].range, x, y,
				EnumObjectType.base);
		gameObjects.add(obj);
		return obj;
	}
}
