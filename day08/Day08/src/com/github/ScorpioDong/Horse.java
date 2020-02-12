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
	int speed;
	
	// 颜色
	char color;
	
	// 行走的方式
	String howToWalk;
	
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
}
