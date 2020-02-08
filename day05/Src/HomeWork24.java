class HomeWork24 {
    public static void main(String[] args) {
        // 利用循环完成15的阶乘
        System.out.println(getFactorialOfNumber(15));
    }
    /*
        需求
            返回num的阶乘
        分析
            public static：莫问
            返回值类型： long
            方法名：getFactorialOfNumber
            形参列表：（int num)
        声明
            public static long getFactorialOfNumber(int num);
    */
    /**
     * 返回num的阶乘
     * 
     * @param num int类型数据
     * @return long 返回num的阶乘
    */
    public static long getFactorialOfNumber(int num) {
        long ret = 1;
        for (int i = 1; i <= num; i++) {
            ret *= i;
        }
        return ret;
    }
}