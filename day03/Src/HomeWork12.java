import java.util.Scanner;

class HomeWork12 {
    public static void main(String[] args) {
        /* 
            输入 5  8；
            计算 5 + 6 + 7 + 8；
            输出 26.
         */
        int num1 = 0;
        int num2 = 0;
        int sum = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个整数：");
        num1 = sc.nextInt();

        System.out.println("请输入第二个整数：");
        num2 = sc.nextInt();

        while (num1 <= num2) {
            sum += num1;
            num1++;
        }

        System.out.println(sum);
    }
}