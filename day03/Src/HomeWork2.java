import java.util.Scanner;

class HomeWork2 {
    public static void main(String[] args) {

        /* 判断用户输入的工资是不是在5000以上，如果是，输出需要缴税，如果不是，输出不需要缴税 */
        double salary = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入您的工资：");
        salary = sc.nextDouble();

        if (salary >= 5000) {
            System.out.println("需要缴税");
        } else {
            System.out.println("不需要缴税");
        }

    }
}