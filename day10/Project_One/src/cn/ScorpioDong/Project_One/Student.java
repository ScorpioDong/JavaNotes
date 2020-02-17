package cn.ScorpioDong.Project_One;

/**
 * 学生管理系统 - 学生类
 * 
 * @author ScorpioDong
 *
 * 2020年2月15日 - 下午4:26:41
 */
public class Student {

	// Field

	private int id;

	private String name;

	private int age;

	private char gender;

	private float mathScore;

	private float chnScore;

	private float engScore;

	private float totalScore;

	private int rank;

	// Constructor

	public Student() {}

	public Student(int id, String name, int age, char gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Student(int id, String name, int age, char gender, float mathScore, 
			float chnScore, float engScore) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mathScore = mathScore;
		this.chnScore = chnScore;
		this.engScore = engScore;
	}

	// Static Method
	/**
	 * 	计算学生的总成绩，成绩存储在Student类对象的totalScore成员方法中
	 * 
	 * @param student Student类型对象
	 */
	public static void calculateTotalScore(Student student) {
		float totalScore = student.getMathScore() + student.getChnScore() + student.getEngScore();
		student.setTotalScore(totalScore);
	}

	// Getter and Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public float getMathScore() {
		return mathScore;
	}

	public void setMathScore(float mathScore) {
		this.mathScore = mathScore;
	}

	public float getChnScore() {
		return chnScore;
	}

	public void setChnScore(float chnScore) {
		this.chnScore = chnScore;
	}

	public float getEngScore() {
		return engScore;
	}

	public void setEngScore(float engScore) {
		this.engScore = engScore;
	}

	public float getTotalScore() {
		return totalScore;
	}

	private void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
