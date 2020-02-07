import java.util.Scanner;

class HomeWork2 {
    public static void main(String[] args) {
        //判断用户输入的工资是不是在5000以上，如果是， 输出需要缴税，如果不是，输出不需要缴税
		int salary = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入您的工资：");
		salary = sc.nextInt();

		if (isMoreThan5000(salary)) {
			System.out.println("需要交税!");
		} else {
			System.out.println("不需要交税!");
		}
    }

    /*
		需求
			判断int数据是否大于5000
		方法分析
			public static: 莫问
			返回值类型： boolean 
			方法名： isMoreThan5000
			形参列表：(int num)
		方法声明
			public static boolean isMoreThan5000(int num);
	*/
	/**
	* 判断int数据是否大于5000
	*
	* @param num int类型数据
	* @return boolean num如果大于5000返回true，否则返回false
	*/
    public static boolean isMoreThan5000(int num) {
        return num > 5000;
    }
}