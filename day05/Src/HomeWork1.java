import java.util.Scanner;

class HomeWork1 {
	public static void main(String[] args) {
		// 判断用户输入的字符是不是英文字符，如果是输出 yes，不是输出no	
		char ch = '\0';
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个字符：");
		ch = sc.nextLine().charAt(0);

		if (isEnglishCharacter(ch)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

	/*
		需求
			判断字符是否是英文字符
		方法分析
			public static: 莫问
			返回值类型： boolean 
			方法名： isEnglishCharacter
			形参列表：(char ch)
		方法声明
			public static boolean isEnglishCharacter(char ch);
	*/
	/**
	* 判断字符是否是英文字符 返回true or false
	*
	* @param ch char类型字符
	* @return boolean类型 ch是英文字符返回true，否则返回false
	*/
	public static boolean isEnglishCharacter(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	} 
}