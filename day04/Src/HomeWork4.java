class HomeWork4 {
    public static void main(String[] args) {
        /* 利用循环完成15的阶乘 */
        int sum = 1;
        for (int i = 1; i<= 15; i++) {
            sum *= i;
        }
        System.out.println("15! = " + sum);
    }
}