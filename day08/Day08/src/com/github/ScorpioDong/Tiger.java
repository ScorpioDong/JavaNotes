package com.github.ScorpioDong;

/**
 * 十二生肖 - 虎
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午8:55:02
 */
public class Tiger {
	// 年龄
	int age;
	
	// 爪子长度
	float clawLenght;
	
	// 动物园名字
	String zooName;
	
	public Tiger() {
		this.age = 2;
		this.clawLenght = 0.01F;
		this.zooName = "大马猴公园";
	}
	
	public Tiger(int age) {
		this.age = age;
		this.clawLenght = 0.01F;
		this.zooName = "大马猴公园";
	}
	
	public Tiger(int age, float clawLength) {
		this.age = age;
		this.clawLenght = clawLength;
		this.zooName = "大马猴公园";
	}
	
	/**
	 * 吃肉
	 */
	public void eatMeat() {
		System.out.println("吃肉");
	}
	
	/**
	 * 攻击
	 */
	public void attack() {
		System.out.println("攻击");
	}
	
	/**
	 * 表演
	 */
	public void play() {
		System.out.println("表演");
	}
}
