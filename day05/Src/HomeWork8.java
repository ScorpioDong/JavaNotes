class HomeWork8 {
    public static void main(String[] args) {
        // 展示0 ~ 100以内的所有奇数
        showOddBetween(0, 100);
    }

    /*
        需求
            展示范围内的奇数
        分析
            public static:
            返回值类型：void
            方法名：showOddBetween()
            形参列表：(int start, int end)
        声明
            public static void showOddBetween(int start, int end);
    */
    /**
     * 展示范围内的奇数
     * 
     * @param start 范围起始值
     * @param end   范围结束值
    */
    public static void showOddBetween(int start, int end) {
        if (end <= start) {
            System.out.println("数据有误!");
            return;
        }
        if (start % 2 != 1) {
            start++;
        }

        for (int i = start; i <= end; i += 2) {
            System.out.print(i + " ");
        }
    }
}