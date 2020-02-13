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
	private String name;
	
	// 鼻子灵敏度
	private float noseSensitivity;
	
	// 步数
	private int stepNumber;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getNoseSensitivity() {
		return noseSensitivity;
	}

	public void setNoseSensitivity(float noseSensitivity) {
		this.noseSensitivity = noseSensitivity;
	}

	public int getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}
	
	

}
