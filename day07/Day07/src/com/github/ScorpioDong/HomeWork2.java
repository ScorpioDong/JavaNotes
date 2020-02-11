package com.github.ScorpioDong;

public class HomeWork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 3, 5, 6, 3, 7, 3, 9, 2 };

		int[] indexArr = new int[array.length];

		int count = allIndexOf(array, 3, indexArr);

		for (int i = 0; i < count; i++) {
			System.out.println(indexArr[i]);
		}
	}

	/*
	 * 返回元素所有下标 public static 返回值类型 int 方法名 allIndexOf 形参列表 (int[] arr, int find,
	 * int[] indexArr)
	 */
	/**
	 * 返回所有下标
	 * 
	 * @param arr      int类型数组
	 * @param find     int类型数据
	 * @param indexArr int类型数组，存储下标
	 * @return int 返回查找到的个数
	 */
	public static int allIndexOf(int[] arr, int find, int[] indexArr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == find) {
				indexArr[count] = i;
				count++;
			}
		}
		return count;
	}

}
