import java.util.Scanner;

class HomeWork5 {
    public static void main(String[] args) {
        // 输入一个数, 判断是否是偶数,如果是偶数,输出 YES,如果是奇数.输出NO
        int num = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        num = sc.nextInt();

        if (isEven(num)) {
            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }
    }

    /*
        需求：
            判断数字是不是偶数
        方法分析：
            public static：莫问
            返回值类型：boolean
            方法名：isEven
            形参列表： (int num)
        方法声明
            public static boolean isEven(int num);
    */
    /**
    * 判断数字是不是偶数
    *
    * @param num int类型数据
    * @return boolean 如果num是偶数返回true，否则返回false
    */
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}