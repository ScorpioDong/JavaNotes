package com.github.ScorpioDong;

/**
 * 十二生肖 - 狗
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午10:14:47
 */
public class Dog {
	
	//名字
	String name;
	
	// 鼻子灵敏度
	float noseSensitivity;
	
	// 步数
	int stepNumber;
	
	public Dog() {
		this.noseSensitivity = 198.2F;
	}
	
	public Dog(int stepNumber) {
		this.stepNumber = stepNumber;
		this.noseSensitivity = 198.2F;
	}
	
	public Dog(int stepNumber, String name) {
		this.name = name;
		this.stepNumber = stepNumber;
		this.noseSensitivity = 198.2F;
	}
	
	/**
	 * 握手
	 */
	public void handshake() {
		System.out.println("握手");
	}
	
	/**
	 * 摇尾巴
	 */
	public void wagTail() {
		System.out.println("摇尾巴");
	}
	
	/**
	 * 犬吠
	 */
	public void barking() {
		System.out.println("犬吠");
	}

}
