package com.github.ScorpioDong;

/**
 * 十二生肖 - 猴
 * 
 * @author ScorpioDong
 *
 * 2020年2月12日 - 下午9:55:22
 */
public class Monkey {
	// 手指个数
	int numberOfFingers;
	
	// 拇指长度
	float thumbLength;
	
	// 历史名人
	String historicalCelebrities;
	
	public Monkey() {
		this.historicalCelebrities = "孙悟空";
	}
	
	public Monkey(int numberOfFingers) {
		this.numberOfFingers = numberOfFingers;
		this.historicalCelebrities = "孙悟空";
	}
	
	public Monkey(int numberOfFingers, float thumbLength) {
		this.numberOfFingers = numberOfFingers;
		this.thumbLength = thumbLength;
		this.historicalCelebrities = "孙悟空";
	}
	
	/**
	 * 演电视剧
	 */
	public void playTVDrama() {
		System.out.println("演电视剧");
	}
	
	/**
	 * 格斗
	 */
	public void combat() {
		System.out.println("格斗");
	}
	
	/**
	 * 玩耍
	 */
	public void play() {
		System.out.println("玩耍");
	}
}
