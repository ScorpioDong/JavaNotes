import java.util.Scanner;

class HomeWork3 {
    public static void main(String[] args) {

        /* 用户输入一个年份，判断这个年份是不是一个闰年 */
        short year = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入年份：");
        year = sc.nextShort();

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("闰年");
        } else {
            System.out.println("平年");
        }

    }
}