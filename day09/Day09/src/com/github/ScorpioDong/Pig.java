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
	private float foodWeight;
	
	// 体型
	private String shape;
	
	// 宝宝数量
	private int babyNumber;
	
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

	public float getFoodWeight() {
		return foodWeight;
	}

	public void setFoodWeight(float foodWeight) {
		this.foodWeight = foodWeight;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public int getBabyNumber() {
		return babyNumber;
	}

	public void setBabyNumber(int babyNumber) {
		this.babyNumber = babyNumber;
	}
	
}
