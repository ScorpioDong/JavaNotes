import java.util.Scanner;

class HomeWork2 {
    public static void main(String[] args) {
        /* 
            将一个正整数进行分解质因数操作 例如: 输入90 结果 2*3*3*5
            一个合数的最小正因子必小于根号N。
         */

        int num = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个正整数：");
        num = sc.nextInt();

        if (num < 2) {
            System.out.println("不能分解！");
            System.exit(0);
        }

        System.out.print(num + " = ");

        if (num == 2) {
            System.out.print(2);
        } else {
            for (int i = 2; i < Math.sqrt(num); i++) {
                while (num != i) {
                    if (num % i == 0) {
                        System.out.print(i + " * ");
                        num /= i;
                    } else {
                        break;
                    }
                }
            }
            System.out.print(num);
        }
    }
}