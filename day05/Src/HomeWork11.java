class HomeWork11 {
    public static void main(String[] args) {
        // 打印26个小写字母
        printLowerEnglishCharacter();
    }

    /* 
        需求
            打印26个小写字母
        分析
            public static: 莫问
            返回值类型：void
            方法名：printLowerEnglistCharacter
            形参列表：()
        声明
            public static void printLowerEnglishCharacter();
    */
    /**
     * 打印26个小写字母
    */
    public static void printLowerEnglishCharacter() {
         char ch = 'a';
        // for (int i = 0; i < 'z' - 'a'; i++) {
        //     System.out.print(ch++);
        // }
        // do {
        //     System.out.print(ch++);
        // } while (ch <= 'z');
        while (ch <= 'z') {
            System.out.print(ch++);
        }
    }
}