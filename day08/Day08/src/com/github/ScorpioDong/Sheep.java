package com.github.ScorpioDong;

/**
 * 十二生肖 - 羊
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午9:40:20
 */
public class Sheep {
	// 毛长
	float hairLength;
	
	// 腿长
	int legLength;
	
	//武器
	String arms;
	
	public Sheep() {
		this.arms = "角";
	}
	
	public Sheep(int legLength) {
		this.legLength = legLength;
		this.arms = "角";
	}
	
	public Sheep(int legLength, float hairLength) {
		this.legLength = legLength;
		this.hairLength = hairLength;
		this.arms = "角";
	}
	
	/**
	 * 用角顶
	 */
	public void pushOn() {
		System.out.println("用角顶");
	}
	
	/**
	 * 走
	 */
	public void walk() {
		System.out.println("走");
	}
	
	/**
	 * 烧烤
	 */
	public void bbq() {
		System.out.println("烧烤");
	}

}
