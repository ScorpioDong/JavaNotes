package day24;

class Type1 {
	static {
		System.out.println("静态代码块");
	}
}

public class Demo1 {
	public static void main(String[] args) {
		new Type1();
		System.out.println("main方法");
	}
}
