package day24;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
 * 获取成员变量Field对象
 */
public class GetFieldObject {
	public static void main(String[] args) 
			throws ClassNotFoundException, 
			NoSuchFieldException, SecurityException, 
			InstantiationException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException {
		/*
		 * 根据指定的包名.类名，获取对应的Class对象
		 */
		Class<?> cls = Class.forName("day24.Person");
		
		Field[] fields = cls.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		Field[] declaredFields = cls.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field);
		}
		
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		Field field = cls.getField("test");
		System.out.println(field);
		
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		Field id = cls.getDeclaredField("id");
		Field name = cls.getDeclaredField("name");
		
		System.out.println(id);
		System.out.println(name);
		
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		Object obj = cls.getConstructor().newInstance();
		System.out.println(obj);
		
		field.set(obj, 20);
		System.out.println(obj);
		
		id.setAccessible(true);
		name.setAccessible(true);
		
		id.set(obj, 1);
		name.set(obj, "骚磊");
		
		System.out.println(obj);
		
		System.out.println(field.get(obj));
		System.out.println(id.get(obj));
		System.out.println(name.get(obj));
	}
}
