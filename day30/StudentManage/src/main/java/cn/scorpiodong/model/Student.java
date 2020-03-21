package cn.scorpiodong.model;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;

/**
 * StudentManage - Student
 * 学生管理系统 - 学生模型
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/14 9:45 AM
 */
public class Student {

    // Fields

    private int id;
    private String name;
    private int age;
    private char gender;
    private int mathScore;
    private int chnScore;
    private int engScore;
    private int totalScore;
    private int rank;
    private long creationDate;
    private long modificationDate;
    /**
     * 类对象计数器
     */
    private static int count = 0;

    // 构造代码块，初始化类对象id
    {
        this.id = count++;
        this.creationDate = System.currentTimeMillis();
        this.modificationDate = this.creationDate;
    }

    // Constructors

    public Student() {}

    public Student(String name, int age, char gender, int mathScore,
                   int chnScore, int engScore) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.mathScore = mathScore;
        this.chnScore = chnScore;
        this.engScore = engScore;
        this.totalScore = mathScore + chnScore + engScore;
    }

    // Methods

    /**
     * 返回代表本对象的json字符串
     * @return String 本对象的json字符串
     */
    public String toJsonString() {
        return JSON.toJSONString(this);
    }

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
                ", creationDate='" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(creationDate) + '\'' +
                ", modificationDate='" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(modificationDate) + '\'' +
                '}';
    }

    // Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.modificationDate = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.modificationDate = System.currentTimeMillis();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.modificationDate = System.currentTimeMillis();
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
        this.modificationDate = System.currentTimeMillis();
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.totalScore = this.totalScore - this.mathScore + mathScore;
        this.mathScore = mathScore;
        this.modificationDate = System.currentTimeMillis();
    }

    public int getChnScore() {
        return chnScore;
    }

    public void setChnScore(int chnScore) {
        this.totalScore = this.totalScore - this.chnScore + chnScore;
        this.chnScore = chnScore;
        this.modificationDate = System.currentTimeMillis();
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.totalScore = this.totalScore - this.engScore + engScore;
        this.engScore = engScore;
        this.modificationDate = System.currentTimeMillis();
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
        this.modificationDate = System.currentTimeMillis();
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
        this.modificationDate = System.currentTimeMillis();
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public long getModificationDate() {
        return modificationDate;
    }
}
