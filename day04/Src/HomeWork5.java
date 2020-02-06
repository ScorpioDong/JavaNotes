import java.util.Scanner;

class HomeWork5 {
    public static void main(String[] args) {
        /*
         * 5. 使用do - while循环和switch - case 完成点菜功能 要求: 
         *      a. 展示菜单 
         *      b. 自动计算总价 
         *      c. 用户选择下单后退出循环
         */

        Scanner sc = new Scanner(System.in);

        String list = "";
        int sum = 0;
        int choose = 0;
        boolean finish = false;

        System.out.println("今日菜单：");
        System.out.println("---------------------------------");
        System.out.println("    1. 酱牛肉               45￥");
        System.out.println("    2. 地三鲜               18￥");
        System.out.println("    3. 醋溜土豆丝            12￥");
        System.out.println("    4. 烤羊排               70￥");
        System.out.println("    5. 北京二锅头            30￥");
        System.out.println("                               ");
        System.out.println("    9. 结束点餐                 ");

        do {

            System.out.println("---------------------------------");
            System.out.println(String.format("已点：%-10s  总计：%d ￥", list, sum));
            System.out.println("---------------------------------");
            System.out.println("请选择您要点的菜品（一次选一个）：");

            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    sum += 45;
                    list += "酱牛肉 ";
                    break;
                case 2:
                    sum += 18;
                    list += "地三鲜 ";
                    break;
                case 3:
                    sum += 12;
                    list += "醋溜土豆丝 ";
                    break;
                case 4:
                    sum += 70;
                    list += "烤羊排 ";
                    break;
                case 5:
                    sum += 30;
                    list += "北京二锅头 ";
                    break;
                case 9:
                    finish = true;
                    System.out.println("---------------------------------");
                    System.out.println(String.format("已点：%-10s  总计：%d ￥", list, sum));
                    System.out.println("用餐愉快！                        ");
                    break;
                default:
                    break;
            }

        } while (!finish);
    }
}