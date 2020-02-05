import java.util.Scanner;

class HomeWork5 {
    public static void main(String[] args) {

        /* 输入一个数, 判断是否是偶数,如果是偶数,输出YES,如果是奇数.输出NO */
        int num = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}