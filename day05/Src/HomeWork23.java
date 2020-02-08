class HomeWork23 {
    public static void main(String[] args) {
        // 使用循环完成30位以内的斐波那契数列
        printFibonacciSeries(20);
    }
    /*
        需求
            打印 num 位的菲波那切数列
        分析
            public static ：莫问
            返回值类型： void
            方法名：printFibonacciSeries
            形参列表 ：（int num)
        声明
            public static void printFibonacciSeries(int num);
    */
    /**
     * 打印 num 位的菲波那切数列
     * 
     * @param num int类型数据
    */
    public static void printFibonacciSeries(int num) {
        int num1 = 1;
        int num2 = 1;
        System.out.print("1 1 ");

        for (int i = 2; i < num; i++) {
            int temp = num2;
            num2 += num1;
            num1 = temp;
            System.out.print(num2 + " ");
        }
    }
}