package day24;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * Method成员方法涉及到的内容
 */
public class GetMethodObject {
	public static void main(String[] args) 
			throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/*
		 * 根据指定的包名.类名，获取对应的Class对象
		 */
		Class<?> cls = Class.forName("day24.Person");
		
		/*
		 * 获取类内所有public修饰的成员方法，包括从父类继承而来的方法
		 */
		Method[] methods = cls.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		/*
		 * 获取类内所有成员方法，包括私有化成员方法，但是不包括父类继承而来的方法
		 */
		Method[] declaredMethods = cls.getDeclaredMethods();
		
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
		
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		/*
		 * 根据指定的方法名和参数类型，获取类内public修饰的成员方法
		 */
		Method game1 = cls.getMethod("game");
		Method game2 = cls.getMethod("game", String.class);
		// Method game3 = cls.getMethod("game", int.class);
		
		System.out.println(game1);
		System.out.println(game2);
		// System.out.println(game3);
		
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		/*
		 * 根据指定的方法名和参数类型，获取类内private修饰的成员方法
		 * 暴力反射
		 */
		Method declaredMethod1 = cls.getDeclaredMethod("testPrivate");
		Method declaredMethod2 = cls.getDeclaredMethod("testPrivate",String.class);
		
		System.out.println(declaredMethod1);
		System.out.println(declaredMethod2);

		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		Object obj = cls.getConstructor().newInstance();
		/*
		 * 执行public修饰的成员方法
		 */
		game1.invoke(obj);
		game2.invoke(obj, "WOT");
		
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		/*
		 * 给予暴力反射操作权限的情况下，执行私有化成员方法
		 */
		declaredMethod1.setAccessible(true);
		declaredMethod1.invoke(obj);
		
		declaredMethod2.setAccessible(true);
		declaredMethod2.invoke(obj, "烤羊排");
	}
}












