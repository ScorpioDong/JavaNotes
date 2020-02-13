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
	private float hairLength;
	
	// 腿长
	private int legLength;
	
	//武器
	private String arms;
	
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

	public float getHairLength() {
		return hairLength;
	}

	public void setHairLength(float hairLength) {
		this.hairLength = hairLength;
	}

	public int getLegLength() {
		return legLength;
	}

	public void setLegLength(int legLength) {
		this.legLength = legLength;
	}

	public String getArms() {
		return arms;
	}

	public void setArms(String arms) {
		this.arms = arms;
	}

}
