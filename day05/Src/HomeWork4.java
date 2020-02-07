import java.util.Scanner;

class HomeWork4 {
    public static void main(String[] args) {
        // 输入两个整数，打印两数之差的绝对值
        int num1 = 0;
        int num2 = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入两个整数：");
        num1 = sc.nextInt();
        num2 = sc.nextInt();

        System.out.println("两数之差的绝对值为：" + getAbsOfTwoNumber(num1, num2));
    }
    /*
        需求：
            求两个int类型数的差的绝对值
        方法分析：
            public static：莫问
            返回值类型：int
            方法名：getAbsOfTwoNumber
            形参列表： (int num1, int num2)
        方法声明
            public static int getAbsOfTwoNumber(int num1, int num2);
    */
    /**
    * 求两个int类型数的差的绝对值
    *
    * @param num1 int类型数据
    * @param num2 int类型数据
    * @return int类型返回值 返回两个int类型数据的差的绝对值
    */
    public static int getAbsOfTwoNumber(int num1, int num2) {
        return num1 > num2 ? num1 - num2 : num2 - num1;
    }
}