import java.util.Scanner;

class HomeWork6 {
    public static void main(String[] args) {

        /* 
            输入一个人的年份, 检测这个是否是80后,如果是输出YES,
            如果不是输出NO(1980-1989年) 
        */
        int year = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入出生年份：");
        year = sc.nextInt();

        if (year >= 1980 && year <= 1989) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}