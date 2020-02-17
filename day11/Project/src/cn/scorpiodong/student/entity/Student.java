package cn.scorpiodong.student.entity;


/**
 * 学生管理系统 - 学生类
 *
 * @author ScorpioDong
 */
public class Student {
    /**
     * 学生id，唯一的
     */
    private int id;

    private String name;

    private int age;

    private char gender;

    private int mathScore;

    private int chnScore;

    private int engScore;

    /**
     * 学生总成绩为三项成绩之和
     */
    private int totalScore;

    /**
     * 学生成绩排名
     */
    private int rank;

    /**
     * 对象计数器
     */
    private static int count = 1;

    // 构造代码块
    {
        id = count++;
    }

    public Student() {
    }

    public Student(String name, int age, char gender, int mathScore, int chnScore, int engScore) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.mathScore = mathScore;
        this.chnScore = chnScore;
        this.engScore = engScore;

        this.totalScore = this.mathScore + this.chnScore + this.engScore;
    }

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

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.totalScore -= this.mathScore;
        this.totalScore += mathScore;
        this.mathScore = mathScore;
    }

    public int getChnScore() {
        return chnScore;
    }

    public void setChnScore(int chnScore) {
        this.totalScore -= this.chnScore;
        this.totalScore += chnScore;
        this.chnScore = chnScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.totalScore -= this.engScore;
        this.totalScore += engScore;
        this.engScore = engScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * 将学生的信息整合成字符串返回
     *
     * @return String类型
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", mathScore=" + mathScore +
                ", chnScore=" + chnScore +
                ", engScore=" + engScore +
                ", totalScore=" + totalScore +
                ", rank=" + rank +
                '}';
    }
}
