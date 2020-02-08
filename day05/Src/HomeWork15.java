class HomeWork15 {
    public static void main(String[] args) {
        /*
            *
            **
            ***
            ****
            *****
        */
        printLadderStarOfNumber(5);
    }
    /*
        需求
            打印阶num行阶梯状*结构
        分析
            public static：莫问
            返回值类型：void
            方法名：printLadderStarOfNumber
            形参列表：（int num)
        声明
            public static void printLadderStarOfNumber(int num);
    */
    /**
     * 打印阶num行阶梯状*结构
     * 
     * @param num int类型数据 行数
    */
    public static void printLadderStarOfNumber(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}