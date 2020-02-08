class HomeWork18 {
    public static void main(String[] args) {
        /* 
                A
               ABA
              ABCBA
             ABCDCBA
            ABCDEDCBA
             ABCDCBA
              ABCBA
               ABA
                A
         */
        printEnglishRhombusOfNumber(9);
    }
    /*
        需求
            打印num行字母菱形
        分析
            public static: 莫问
            返回值类型： void
            方法名：printEnglishRhombusOfNumber
            形参列表：(int num)
        声明    
            public static void printEnglishRhombusOfNumber(int num);
    */
    /**
     * 打印num行菱形
     * @param num int类型数据 行数
    */
    public static void printEnglishRhombusOfNumber(int num) {
        if (num % 2 == 0) {
            System.out.println("请输入奇数！！");
            return;
        }

        for (int i = 1; i <= num; i++) {
            int center = num / 2 + 1;
            for (int j = 1; j <= Math.abs(center - i); j++) {
                System.out.print(' ');
            }

            int loopCenter = center - Math.abs(center - i);
            for (int j = 1; j <= loopCenter * 2 - 1; j++) {
                char ch = 'A';
                System.out.print(ch += (loopCenter - Math.abs(loopCenter - j) - 1));
            }
            System.out.println();
        }
    }
}