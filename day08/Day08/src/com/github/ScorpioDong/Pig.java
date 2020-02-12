package com.github.ScorpioDong;

/**
 * 十二生肖 - 猪
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午10:24:19
 */
public class Pig {
	// 食物重量
	float foodWeight;
	
	// 体型
	String shape;
	
	// 宝宝数量
	int babyNumber;
	
	public Pig() {
		this.shape = "肥胖";
	}
	
	public Pig(int babyNumber) {
		this.babyNumber = babyNumber;
		this.shape = "肥胖";
	}
	
	public Pig(int babyNumber, float foodWeight) {
		this.foodWeight = foodWeight;
		this.babyNumber = babyNumber;
		this.shape = "肥胖";
	}
	
	/**
	 * 吃
	 */
	public void eat() {
		System.out.println("吃");
	}
	
	/**
	 * 喝
	 */
	public void drink() {
		System.out.println("喝");
	}
	
	/**
	 * 拉
	 */
	public void drain() {
		System.out.println("拉");
	}
	
}
