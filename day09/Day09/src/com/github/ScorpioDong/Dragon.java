package com.github.ScorpioDong;

/**
 * 十二生肖 - 龙
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午9:11:34
 */
public class Dragon {
	// 飞行速度
	private float flySpeed;
	
	// 翼展长度
	private int wingLength;
	
	// 阵营
	private String camp;
	
	public Dragon() {
		this.flySpeed = 99.9F;
	}
	
	public Dragon(int wingLength) {
		this.flySpeed = 99.9F;
		this.wingLength = wingLength;
	}
	
	public Dragon(int wingLength, String camp) {
		this.flySpeed = 99.9F;
		this.wingLength = wingLength;
		this.camp = camp;
	}
	
	/**
	 * 飞
	 */
	public void fly() {
		System.out.println("飞");
	}
	
	/**
	 * 降雨
	 */
	public void rainfall() {
		System.out.println("降雨");
	}
	
	/**
	 * 生娃
	 */
	public void bornBaby() {
		System.out.println("生娃");
	}

	public float getFlySpeed() {
		return flySpeed;
	}

	public void setFlySpeed(float flySpeed) {
		this.flySpeed = flySpeed;
	}

	public int getWingLength() {
		return wingLength;
	}

	public void setWingLength(int wingLength) {
		this.wingLength = wingLength;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}
	
	
}
