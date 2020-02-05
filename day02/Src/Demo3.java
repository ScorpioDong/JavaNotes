class Demo3 {
    public static void main(String[] args) {
        /* 转义字符 */
        char ch1 = '\'';

        System.out.println(ch1);
        System.out.println("测试\t测试\n测试\\\\测试");

        /* 强制类型转换 【谨慎使用】 */
        double num1 = 3.99999999999999999999999;
        int num2 = (int) num1;

        System.out.println(num2);

        /* 算数运算符 */
        int value1 = 10;
        int value2 = 20;

        value2 = value2 + value1; //value2 += value1;
        System.out.println(value2);

        value2 = value2 - value1; //value2 -= value1;
        System.out.println(value2);

        value2 = value2 * value1; //value2 *= value1;
        System.out.println(value2);

        value2 = value2 / value1; //value2 /= value1;
        System.out.println(value2);

    }
}