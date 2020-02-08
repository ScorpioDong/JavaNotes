class HomeWork20 {
    public static void main(String[] args) {
        // 打印心形
        printHeart(2);
    }
    /*
        需求 
            打印心形
        分析
            public static: 莫问
            返回值类型： void
            方法名： printHeart
            形参列表：（double scale)
        声明
            public static void printHeart(double scale);
    */
    /**
     * 打印心形
     * 
     * @param scale 心形缩放比例
    */
    public static void printHeart(double scale) {
        scale = 1 / scale;
        for (double y = 1.5; y > -1.5; y -= (0.1 * scale)) {
            for (double x = -1.5; x < 1.5; x += (0.05 * scale)) {
                double a = x * x + y * y - 1;
                if (a * a * a - x * x * y * y * y <= 0){
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println("");
        }
    }
}