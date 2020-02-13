package com.github.ScorpioDong;

/**
 * 十二生肖 - 兔
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午9:03:04
 */
public class Rabbit {
	
	// 耳朵长度
	private int earLength;
	
	// 牙齿长度
	private float toothLength;
	
	// 讨厌的动物
	private String disgustingAnimal;
	
	public Rabbit() {
		this.earLength = 20;
		this.disgustingAnimal = "乌龟";
	}
	
	public Rabbit(int earLength) {
		this.earLength = earLength;
		this.disgustingAnimal = "乌龟";
	}
	
	public Rabbit(int earLength, String disgustingAnimal) {
		this.earLength = 20;
		this.disgustingAnimal = disgustingAnimal;
	}
	
	/**
	 * 获得速度
	 * 
	 * @return int 速度
	 */
	public int getSpeed() {
		return 20;
	}
	
	/**
	 * 打比赛
	 */
	public void playAMatch() {
		System.out.println("打比赛");
	}
	
	/**
	 * 跳跃
	 */
	public void jump() {
		System.out.println("跳跃");
	}

	public int getEarLength() {
		return earLength;
	}

	public void setEarLength(int earLength) {
		this.earLength = earLength;
	}

	public float getToothLength() {
		return toothLength;
	}

	public void setToothLength(float toothLength) {
		this.toothLength = toothLength;
	}

	public String getDisgustingAnimal() {
		return disgustingAnimal;
	}

	public void setDisgustingAnimal(String disgustingAnimal) {
		this.disgustingAnimal = disgustingAnimal;
	}
	
}
