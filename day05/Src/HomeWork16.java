class HomeWork16 {
    public static void main(String[] args) {
        /*
            *
           ***
          *****
         *******
        *********
        */
        printPyramidOfNumber(5);
    }
    /*
        需求
            打印num行金字塔
        分析
            public static: 莫问
            返回值类型： void
            方法名：printPyramidOfNumber
            形参列表：(int num)
        声明    
            public static void printPyramidOfNumber(int num);
    */
    /**
     * 打印num行金字塔
     * @param num int类型数据 行数
    */
    public static void printPyramidOfNumber(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print(' ');
            }

            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}