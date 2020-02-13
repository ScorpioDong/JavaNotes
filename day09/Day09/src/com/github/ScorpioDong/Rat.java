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
	private int tailLength;
	
	// 体重
	private float weigth;
	
	// 爱好
	private String hobby;
	
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

	public int getTailLength() {
		return tailLength;
	}

	public void setTailLength(int tailLength) {
		this.tailLength = tailLength;
	}

	public float getWeigth() {
		return weigth;
	}

	public void setWeigth(float weigth) {
		this.weigth = weigth;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}
