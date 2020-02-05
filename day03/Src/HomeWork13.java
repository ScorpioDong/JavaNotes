import java.util.Scanner;

class HomeWork13 {
    public static void main(String[] args) {
        /* 整数逆序输出：例如输入一个整数12345,输出5 4 3 2 1 */
        int num = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        num = sc.nextInt();

        String numStr = Integer.toString(num);
        int length = numStr.length();
        
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(numStr.charAt(i));
        }
    }
}