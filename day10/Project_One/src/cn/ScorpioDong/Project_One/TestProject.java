package cn.ScorpioDong.Project_One;

public class TestProject {

	public static void main(String[] args) {
		
		final Manage manage = new Manage();
		
		manage.add(new Student(1, "A", 16, '男', 100, 100, 100));
		//manage.add(new Student(1, "B", 16, '男', 99, 100, 100));
		manage.add(new Student(2, "B", 16, '男', 99, 100, 100));
		manage.add(new Student(3, "C", 16, '男', 98, 100, 100));
		manage.add(new Student(4, "D", 16, '男', 97, 100, 100));
		
		System.out.println(manage.search(1).getRank());
		System.out.println(manage.search(2).getRank());
		System.out.println(manage.search(3).getRank());
		System.out.println(manage.search(4).getRank());
		
		manage.delete(2);
		
		System.out.println(manage.search(1).getRank());
		//System.out.println(manage.search(2).getRank());
		System.out.println(manage.search(3).getRank());
		System.out.println(manage.search(4).getRank());
		
		manage.update(3, new Student(3, "C", 16, '男', 98, 96, 100));
		
		System.out.println(manage.search(1).getRank());
		//System.out.println(manage.search(2).getRank());
		System.out.println(manage.search(3).getRank());
		System.out.println(manage.search(4).getRank());
	}

}
