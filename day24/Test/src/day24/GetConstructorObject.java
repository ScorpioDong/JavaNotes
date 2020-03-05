package day24;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * 操作Constructor
 */
public class GetConstructorObject {
	public static void main(String[] args) 
			throws ClassNotFoundException, 
			NoSuchMethodException, SecurityException, 
			InstantiationException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException {
		/*
		 * 根据指定的包名.类名，获取对应的Class对象
		 */
		Class<?> cls = Class.forName("day24.Person");
		
		/*
		 * 获取当前Person类内所有非私有化构造方法
		 */
		Constructor<?>[] constructors = cls.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		/* 
		 * 暴力反射，获取Person类内所有的构造方法，包括私有化构造方法
		 */
		Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			System.out.println(constructor);
		}
		
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		/*
		 * 根据指定参数类型获取public修饰的构造方法对象
		 * 如果没有指定参数的构造方法，运行异常java.lang.NoSuchMethodException
		 */
		Constructor<?> constructor1 = cls.getConstructor();
		Constructor<?> constructor2 = cls.getConstructor(int.class);
		Constructor<?> constructor3 = cls.getConstructor(int.class, String.class);
		System.out.println(constructor1);
		System.out.println(constructor2);
		System.out.println(constructor3);
		
		// Constructor<?> constructor = cls.getConstructor(String.class);
		// System.out.println(constructor);
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		/*
		 * 通过暴力反射可以获取任意权限修饰符，符合参数要求的构造方法对象
		 */
		Constructor<?> declaredConstructor1 = cls.getDeclaredConstructor();
		Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(String.class);
		System.out.println(declaredConstructor1);
		System.out.println(declaredConstructor2);
		
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		/*
		 * 通过无参数Constructor对象执行newInstance方法
		 * 这里明确是一个Person类型，可以使用强制类型转换
		 * 这里使用的是public修饰的构造方法
		 */
		Person p1 = (Person) constructor1.newInstance();
		System.out.println(p1);
		System.out.println(new Person());
		System.out.println(constructor3.newInstance(1, "骚磊"));
		
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		// 给予通过暴力反射获取到的非公开权限成员变量，成员方法，构造方法，操作权限
		// 暴力反射的为所欲为操作
		declaredConstructor2.setAccessible(true);
		Person p2 = (Person) declaredConstructor2.newInstance("骚磊");
		System.out.println(p2);
	}
}
