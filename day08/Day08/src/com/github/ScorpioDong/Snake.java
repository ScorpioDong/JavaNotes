package com.github.ScorpioDong;

/**
 * 十二生肖 - 蛇
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午9:20:32
 */
public class Snake {
	// 舌头长度
	float tongueLength;
	
	// 宽度
	int width;
	
	// 同名的明星
	String starOfSameName;
	
	public Snake() {
		this.starOfSameName = "张伟";
	}
	
	public Snake(int width) {
		this.width = width;
		this.starOfSameName = "张伟";
	}
	
	public Snake(int width, String starOfSameName) {
		this.width = width;
		this.starOfSameName = starOfSameName;
	}
	
	/**
	 * 游泳
	 */
	public void swimming() {
		System.out.println("游泳");
	}
	
	/**
	 * 捕食
	 */
	public void predation() {
		System.out.println("捕食");
	}
	
	/**
	 * 吞
	 */
	public void swallowElephant() {
		System.out.println("吞象");
	}
}
