package day24;


/**
 * @author scorpio
 */
public class GetClassObject {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println(123456);
		
		Class<?> forName = Class.forName("day24.Person");
		
		Class<day24.Person> cls = Person.class;
		
		Class<? extends Person> class1 = new Person().getClass();
		
		/*
		 * 请问这个三个Class对象是不是同一个Class对象???
		 * 		Class对象对应的是在内存代码区的.class文件占用的内存空间
		 * 		Class引用数据类型变量保存的就是当前空间首地址，
		 * 		Java程序中，.class字节码文件有且之加载一次
		 * 		.class文件占用的空间独一份，不管通过哪一种方式获取对应的Class类对象
		 * 		都是同一个对象
		 */
		System.out.println(forName == cls);
		System.out.println(class1 == cls);
		System.out.println(class1 == forName);
		
		System.out.println("-------------------------");
		
		System.out.println(forName);
		System.out.println(cls);
		System.out.println(class1);
		System.out.println(int.class);
	}
}
