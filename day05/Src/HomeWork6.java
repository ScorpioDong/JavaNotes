import java.util.Scanner;

class HomeWork6 {
    public static void main(String[] args) {
        // 输入一个人的年份, 检测这个是否是80后,如果是输
        // 出YES,如果不是输出NO(1980-1989年)
        int year = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入年份：");
        year = sc.nextInt();

        if (isBetween1980s(year)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    /*
        需求：
            判断年龄是否是80后
        方法分析：
            public static：莫问
            返回值类型：boolean
            方法名：isBetween1980s
            形参列表： (int year)
        方法声明
            public static boolean isBetween1980s(int year);
    */
    /**
    * 判断年龄是否是80后
    *
    * @param year int类型数据 生年
    * @return boolean 如果year是80年代返回true，否则返回false
    */
    public static boolean isBetween1980s(int year) {
        return year >= 1980 && year <= 1989;
    }
}