class HomeWork19 {
    public static void main(String[] args) {
        /*
            ###*###
            ##*#*##
            #*###*#
            *#####*
            #*###*#
            ##*#*##
            ###*###

        */
        printSolidRhombusOfNumber(21);
    }
    /*
        需求
            打印num行实心菱形
        分析
            public static: 莫问
            返回值类型： void
            方法名：printSolidRhombusOfNumber
            形参列表：(int num)
        声明    
            public static void printSolidRhombusOfNumber(int num);
    */
    /**
     * 打印num行菱形
     * @param num int类型数据 行数
    */
    public static void printSolidRhombusOfNumber(int num) {
        if (num % 2 == 0) {
            System.out.println("请输入奇数！！");
            return;
        }

        for (int i = 1; i <= num; i++) {
            int center = num / 2 + 1;
            for (int j = 1; j <= num; j++) {
                System.out.print('#');
            }

            int temp = center - Math.abs(center - i) - 1;
            for (int j = 1; j <= center - temp; j++) {
                System.out.print('\b');
            }
            System.out.print('*');

            for (int j = 1; j <= temp * 2 + 1; j++) {
                System.out.print('\b');
            }
            System.out.print('*');

            System.out.println();
        }
    }
}