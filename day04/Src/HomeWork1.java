class HomeWork1 {
	public static void main(String[] args) {
		/* 完成一个9*9乘法表 */

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(String.format("%d * %d = %-4d", j, i, i * j));
			}
			System.out.println();
		}
	}
}