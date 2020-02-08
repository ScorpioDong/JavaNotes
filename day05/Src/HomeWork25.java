import java.util.Scanner;

class HomeWork25 {
    public static void main(String[] args) {
        // 点菜系统
        int total = 0;
        int choose = 0;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        do {
            printMenu();
            choose = sc.nextInt();
            if (choose == 0) {
                System.out.println("您下单菜品的总价为" + total + "$");
                flag = true;
            }
            total += getPrice(choose);

        } while (!flag);
        
    }

    /*
        需求
            打印菜单
        分析
            返回值类型 void
            方法名 printMenu
            形参列表 （）
        声明
            public static void printMenu();         
    */
    /**
     * 打印菜名
    */
    public static void printMenu() {
        System.out.println("------------------");
        System.out.println(" 1. A        30RMB");
        System.out.println(" 2. B        50RMB");
        System.out.println(" 3. C        4 RMB");
        System.out.println(" 4. D        70RMB");
        System.out.println(" 5. E        90RMB");
        System.out.println(" 0. EXIT          ");
        System.out.println("------------------");
    }
    /**
     * 返回菜价
     * 
     * @param choose 菜序号
     * @return int 菜价
    */
    public static int getPrice(int choose) {
        int price = 0;
        switch (choose) {
            case 1:
                price = 30;
                break;
            case 2:
                price = 50;
                break;
            case 3:
                price = 4;
                break;
            case 4:
                price = 70;
                break;
            case 5:
                price = 90;
                break;
            default:
                break;
        }
        return price;
    }
}