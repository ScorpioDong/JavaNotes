package com.github.ScorpioDong;

public class HomeWork1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, 1, 4, 5, 7, 12, 15, 66, 89};
		
		System.out.println(findIndex(arr, 66));
	}
	/* 
	 * 二分法查找
	 * public static 
	 * 返回值类型 int
	 * 方法名 findIndex
	 * 形参列表 (int[] arr, int find)
	 */
	/**
	 * 二分法查找
	 * 
	 * @param arr int类型数组
	 * @param find int类型数据
	 * @return int 返回查找到的下标，未找到返回-1
	 */
	public static int findIndex(int[] arr, int find) {
		int index = -1;
		int high = arr.length - 1;
		int low = 0;
		
		while (low <= high) {
			int middle = (high + low) / 2;
			if (find == arr[middle]) {
				index = middle;
				break;
			}
			if (find > arr[middle]) {
				low = middle + 1;
				continue;
			}
			if (find < arr[middle]) {
				high = middle - 1;
				continue;
			}
		}
		return index;
	}
}
