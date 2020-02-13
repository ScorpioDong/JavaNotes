package com.github.ScorpioDong;

/**
 * 十二生肖 - 马
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午9:31:39
 */
public class Horse {
	// 速度
	private int speed;
	
	// 颜色
	private char color;
	
	// 行走的方式
	private String howToWalk;
	
	public Horse() {
		this.howToWalk = "马走日";
	}
	
	public Horse(int speed) {
		this.speed = speed;
		this.howToWalk = "马走日";
	}
	
	public Horse(int speed, char color) {
		this.speed = speed;
		this.color = color;
		this.howToWalk = "马走日";
	}
	
	/**
	 * 奔跑
	 */
	public void running() {
		System.out.println("奔跑");
	}
	
	/**
	 * 嘶吼
	 */
	public void swing() {
		System.out.println("嘶吼");
	}
	
	/**
	 * 笑
	 */
	public void laugh() {
		System.out.println("笑");
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public String getHowToWalk() {
		return howToWalk;
	}

	public void setHowToWalk(String howToWalk) {
		this.howToWalk = howToWalk;
	}
	
}
