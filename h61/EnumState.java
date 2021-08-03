package com.huawei.classroom.student.h61;

//一个人可能的状态
public enum EnumState {
	// 健康，潜伏期，带病在家（此时已经脱离了潜伏期），带病在医院（同样已经脱离了潜伏期），治愈产生了免疫，死亡
	health, latent, ill_home, ill_hospital, cured, dead;
}
