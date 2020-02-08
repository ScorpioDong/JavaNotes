class HomeWork14 {
    public static void main(String[] args) {
        /*
            *****
            *****
            *****
            *****
            *****
        */
        printStarOfNumber(5);
    }
    /*
        需求
            打印num*num的*矩阵
        分析
            public static:莫问
            返回值类型：void
            方法名：printStarOfNumber
            形参列表:(int num)
        声明
            public static void printStarOfNumber(int num);
    */
    /**
     * 打印num*num的*矩阵
     * 
     * @param num int类型数据，打印*的行数和列数
    */
    public static void printStarOfNumber(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}