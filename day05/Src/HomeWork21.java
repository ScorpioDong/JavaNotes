class HomeWork21 {
    public static void main(String[] args) {
        // 完成一个9*9乘法表
        printListOfMultiplication(9);
    }
    /*
        需求
            打印num * num乘法表
        分析
            public static: 莫问
            返回值类型： void
            方法名： printListOfMultiplication
            形参列表（int num）
        声明
            public static void printListOfMultiplication(int num);
    */
    /**
     * 打印 num*num乘法表
     * 
     * @param num int类型数据
    */
    public static void printListOfMultiplication(int num) {
        for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(String.format("%d * %d = %-4d", j, i, i * j));
			}
			System.out.println();
		}
    }
}