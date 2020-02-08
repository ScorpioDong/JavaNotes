class HomeWork13 {
    public static void main(String[] args) {
        /*
        整数逆序输出, 例如输入一个整数12345,输出54321
        */
        printOppositeOfInt(12345);
    }
    /*
        需求
            整数逆序输出
        分析
            public static：莫问
            返回值类型：void
            方法名printOppositeOfInt
            形参列表：(int num)
        声明
            public static void printOppositeOfInt(int num);
    */
    /**
     *  整数逆序输出
     * 
     * @param int int类型整数
    */
    public static void printOppositeOfInt(int num) {
        do {
            System.out.print(num % 10);
        } while ((num /= 10) > 0);
    }
}