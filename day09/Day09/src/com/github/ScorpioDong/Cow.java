package com.github.ScorpioDong;

/**
 * 十二生肖 - 牛
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午8:45:28
 */
public class Cow {
	
	// 牛角长度
	private int hornLength;
	// 身高
	private float height;
 
	// 性别
	private char gender;
	
	public int getHornLength() {
		return hornLength;
	}

	public void setHornLength(int hornLength) {
		this.hornLength = hornLength;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Cow() {
		this.hornLength = 10;
		this.height = 0.9F;
		this.gender = '雌';
	}
	
	public Cow(int hornLength) {
		this.hornLength = hornLength;
		this.height = 0.9F;
		this.gender = '雌';
	}
	
	public Cow(int hornLength, float height) {
		this.hornLength = hornLength;
		this.height = height;
		this.gender = '雌';
	}
	
	/**
	 * 吃草
	 */
	public void graze() {
		System.out.println("吃草");
	}
	
	/**
	 * 产奶
	 * @return float 产奶量
	 */
	public float getMilk() {
		return 0.5F;
	}
	
	/**
	 * 睡觉
	 */
	public void sleep() {
		System.out.println("睡觉");
	}
	
	
}
