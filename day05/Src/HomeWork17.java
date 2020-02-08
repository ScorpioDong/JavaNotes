class HomeWork17 {
    public static void main(String[] args) {
        /*
                *
               ***
              *****
             *******
            *********
             *******
              *****
               ***
                *
        */
        printRhombusOfNumber(9);
    }

    /*
        需求
            打印num行菱形
        分析
            public static: 莫问
            返回值类型： void
            方法名：printRhombusOfNumber
            形参列表：(int num)
        声明    
            public static void printRhombusOfNumber(int num);
    */
    /**
     * 打印num行菱形
     * @param num int类型数据 行数
    */
    public static void printRhombusOfNumber(int num) {
        if (num % 2 == 0) {
            System.out.println("请输入奇数！！");
            return;
        }

        for (int i = 1; i <= num; i++) {
            int center = num / 2 + 1;
            for (int j = 1; j <= Math.abs(center - i); j++) {
                System.out.print(' ');
            }

            for (int j = 1; j <= (center - Math.abs(center - i)) * 2 - 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}