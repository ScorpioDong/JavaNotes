import java.util.Scanner;

class HomeWork4 {
    public static void main(String[] args) {

        /* 输入两个整数，打印两数之差的绝对值 */
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个整数：");
        num1 = sc.nextInt();

        System.out.println("请输入第二个整数：");
        num2 = sc.nextInt();

        num3 = num1 - num2;

        System.out.print("您输入的两整数的绝对值为：");

        if (num3 >=0) {
            System.out.println(num3);
        } else {
            System.out.println(-num3);
        }

    }
}