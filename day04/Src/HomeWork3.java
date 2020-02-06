import java.util.Scanner;

class HomeWork3 {
    public static void main(String[] args) {
        /* 使用循环完成30位以内的斐波那契数列 */

        int num1 = 0;
        int num2 = 1;
        int temp = 0;

        while (num2 <= 30) {
            System.out.print(num2 + " ");
            temp = num2;
            num2 += num1;
            num1 = temp;
        }
    }
}