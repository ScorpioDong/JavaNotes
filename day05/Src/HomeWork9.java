class HomeWork9 {
    public static void main(String[] args) {
        // 计算1 - 150 的和
        long sum = 0;
        sum = getSumBetween(1, 150);
        
        System.out.println(sum);
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