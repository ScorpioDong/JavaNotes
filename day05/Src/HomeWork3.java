import java.util.Scanner;

class HomeWork3 {
    public static void main(String[] args) {
        //用户输入一个年份，判断这个年份是不是一个闰年
        int year = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个年份：");
        year = sc.nextInt();

        if (isLeapYear(year)) {
            System.out.println("闰年");
        } else {
            System.out.println("平年");
        }
    }

    /*
        需求：
            判断年份是不是闰年
        方法分析：
            public static：莫问
            返回值类型：boolean
            方法名：isLeapYear
            形参列表： (int year)
        方法声明
            public static boolean isLeapYear(int year);
    */
    /**
    * 判断年份是否是闰年
    *
    * @param year int类型 年份
    * @return boolean 如果year是闰年返回true，否则返回false
    */
    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}