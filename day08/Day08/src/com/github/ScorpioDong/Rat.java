package com.github.ScorpioDong;

/**
 * 十二生肖 - 鼠
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午7:53:22
 */
public class Rat {
	// 尾巴长度
	int tailLength;
	
	// 体重
	float weigth;
	
	// 爱好
	String hobby;
	
	public Rat() {
		this.tailLength = 5;
		this.weigth = 0.3F;
		this.hobby = "偷东西";
	}
	
	public Rat(int tailLength) {
		this.tailLength = tailLength;
		
	}
	
	public Rat(int tailLength, String hobby) {
		this.tailLength = tailLength;
		this.hobby = hobby;
	}
	
	/**
	 * 偷油
	 */
	public void stealOil() {
		System.out.println("偷油");
	}
	
	/**
	 * 散步
	 */
	public void takeAWalk() {
		System.out.println("散步");
	}
	
	/**
	 * 逃跑
	 */
	public void escape() {
		System.out.println("逃跑");
	}
}
