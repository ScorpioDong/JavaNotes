class HomeWork22 {
    public static void main(String[] args) {
        // 将一个正整数进行分解质因数操作 例如: 输入90 结果 2*3*3*5
        printPrimeNumber(90);
    }
    /*
        需求
            将一个正整数进行分解质因数操作
        分析
            public static:莫问
            返回值类型： void
            方法名 printPrimeNumber
            形参列表：（int num）
        声明
            public static void printPrimeNumber(int num);
    */
    /**
     *  将一个正整数进行分解质因数
     * 
     * @param num int类型数据
    */
    public static void printPrimeNumber(int num) {
        for (int i = 2; i < Math.abs(num); i++) {
            if (num % i == 0) {
                System.out.print(i + " * ");
                num /= i;
                i--;
            }
        }
        System.out.print(num);
    }
}