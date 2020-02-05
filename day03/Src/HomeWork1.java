import java.util.Scanner;

class HomeWork1 {
    public static void main(String[] args) {

        /* 判断用户输入的字符是不是英文字符，如果是输出yes，不是输出no */
        char ch = '\0';

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符：");
        ch = sc.nextLine().charAt(0);

        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}