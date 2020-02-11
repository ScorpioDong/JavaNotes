package com.github.ScorpioDong;

import java.util.Arrays;

public class HomeWork {
	public static void main(String[] args) {
		int[] array = { 1, 3, 5, 6, 3, 7, 3, 9, 2 };
		
		selectSort(array);
		System.out.println(Arrays.toString(array));
	}
	/*
	 * 实现选择排序算法
	 */
	/**
	 * 选择排序
	 * 
	 * @param arr int类型数组
	 */
	public static void selectSort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {	
			
			int index = i;
			
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] < arr[j]) {
					index = j;
				}
			}
			
			if (index != i) {
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
