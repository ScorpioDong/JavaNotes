package cn.scorpiodong.server.model;

/**
 * StudentSystemC - Student
 * 学生实体类
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/17 7:47 下午
 */
public class Student {

    // Fields

    private Integer id;
    private String name;
    private Boolean gender;
    private Integer age;
    private Integer mathScore;
    private Integer chnScore;
    private Integer engScore;
    private Integer totalScore;
    private Integer rank;

    // Constructors

    public Student() {}

    public Student(Integer id, String name, Boolean gender, Integer age, Integer mathScore,
                   Integer chnScore, Integer engScore, Integer totalScore, Integer rank) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mathScore = mathScore;
        this.chnScore = chnScore;
        this.engScore = engScore;
        this.totalScore = totalScore;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", mathScore=" + mathScore +
                ", chnScore=" + chnScore +
                ", engScore=" + engScore +
                ", totalScore=" + totalScore +
                ", rank=" + rank +
                '}';
    }

    // Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMathScore() {
        return mathScore;
    }

    public void setMathScore(Integer mathScore) {
        this.mathScore = mathScore;
    }

    public Integer getChnScore() {
        return chnScore;
    }

    public void setChnScore(Integer chnScore) {
        this.chnScore = chnScore;
    }

    public Integer getEngScore() {
        return engScore;
    }

    public void setEngScore(Integer engScore) {
        this.engScore = engScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
