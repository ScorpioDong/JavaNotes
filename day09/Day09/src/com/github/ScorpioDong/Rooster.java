package com.github.ScorpioDong;

/**
 * 十二生肖 - 鸡
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午10:07:20
 */
public class Rooster {
	// 喙长
	private int beakLength;
	
	// 价格
	private float price;
	
	// 冠颜色
	private char hatColor;
	
	public Rooster() {
		this.hatColor = '红';
	}
	
	public Rooster(int beakLength) {
		this.beakLength = beakLength;
		this.hatColor = '红';
	}
	
	public Rooster(int beakLength, float price) {
		this.beakLength = beakLength;
		this.price = price;
		this.hatColor = '红';
	}
	
	/**
	 * 鸡叫
	 */
	public void roosterCall() {
		System.out.println("鸡叫");
	}
	
	/**
	 * 巡逻
	 */
	public void patrol() {
		System.out.println("巡逻");
	}
	
	/**
	 * 下蛋
	 */
	public void layEggs() {
		System.out.println("下蛋");
	}

	public int getBeakLength() {
		return beakLength;
	}

	public void setBeakLength(int beakLength) {
		this.beakLength = beakLength;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public char getHatColor() {
		return hatColor;
	}

	public void setHatColor(char hatColor) {
		this.hatColor = hatColor;
	}
	
	
}
