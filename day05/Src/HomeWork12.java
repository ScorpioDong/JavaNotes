class HomeWork12 {
    public static void main(String[] args) {
        /*
            输入 5 8;
            计算 5 + 6 + 7 + 8; 
            输出 26.
        */
        System.out.println(getSumBetween(5, 8));
    }
    /*
        需求
            计算范围内的所有整数和
        分析
            public static:
            返回值类型：long
            方法名：getSumBetween()
            形参列表：(int start, int end)
        声明
            public static long getSumBetween(int start, int end);
    */
    /**
     * 计算范围内的所有整数和 
     * 
     * @param start 范围起始值
     * @param end   范围结束值
    */
    public static long getSumBetween(int start, int end) {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}