package cn.ScorpioDong.Project_One;

import java.util.Arrays;

/**
 * 学生管理系统 - 管理类
 * 
 * @author ScorpioDong
 *
 * 2020年2月15日 - 下午4:47:10
 */
public class Manage {

	// Field

	private Student[] students;

	// Constructor
	public Manage() {
		students = new Student[0];
	}

	// Getter and Setter
	
	// Method
	
	/**
	 * 添加学生对象
	 * 
	 * @param student Student类型对象
	 * @return	boolean类型数据
	 */
	public boolean add(Student student) {
		if (!checkId(student.getId())) {
			System.out.println("Id已存在！！");
			return false;
		}
		
		Student.calculateTotalScore(student);
		Student[] temp = Arrays.copyOf(this.students, this.students.length + 1);
		temp[this.students.length] = student;
		this.students = temp;
		
		rank();	
		return true;
	}
	
	/**
	 * 删除学生对象
	 * 
	 * @param id int类型 ，学生的id
	 * @return boolean类型数据
	 */
	public boolean delete(int id) {
		int index = getIndexById(id);
		if (-1 == index) {
			return false;
		}
		
		Student[] temp = new Student[this.students.length - 1]; 
		System.arraycopy(this.students, 0, temp, 0, index);
		System.arraycopy(this.students, index + 1, temp, index, this.students.length - index - 1);
		this.students = temp;
		
		rank();
		return true;
	}
	
	/**
	 * 更新学生数据
	 * 
	 * @param id int类型，学生id
	 * @param student Student类型对象
	 * @return boolean类型数据
	 */
	public boolean update(int id, Student student) {
		int index = getIndexById(id);
		if (-1 == index) {
			return false;
		}
		
		Student.calculateTotalScore(student);
		this.students[index] = student;
		
		rank();
		return true;
	}
	
	/** 
	 * 查询学生数据 
	 * 
	 * @param id int类型数据，学生id
	 * @return Student类型对象 返回学生对象，可能返回null
	 */
	public Student search(int id) {
		int index = getIndexById(id);
		if (-1 == index) {
			System.out.println("输入的id不正确！！！");
			return null;
		}
		
		return this.students[index];
	}

	/**
	 * 计算得到所有
	 */
	private void rank() {
		int counter = 0;
		
		// students排序
		for (int i = 0; i < this.students.length; i++) {
			int maxIndex = counter;
			for (int j = counter; j < this.students.length; j++) {
				if (this.students[maxIndex].getTotalScore() < this.students[j].getTotalScore()) {
					maxIndex = j;
				}
			}
			
			Student temp = this.students[maxIndex];
			this.students[maxIndex] = this.students[counter];
			this.students[counter] = temp;

			counter++;
		}
		
		// 确定student对象的rank
		for (int i = 0; i < this.students.length; i++) {
			this.students[i].setRank(i + 1);
		}
	}
	
	/**
	 * 获取id对应的学生的下标索引
	 * 
	 * @param id int类型数据，学生的id
	 * @return int类型数据，下标
	 */
	private int getIndexById(int id) {
		for (int i = 0; i < this.students.length; i++) {
			if (id == this.students[i].getId()) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 检查id是否重复
	 * 
	 * @param id int类型数据，学生的id
	 * @return boolean类型 重复返回false
	 */
	private boolean checkId(int id) {
		for (int i = 0; i < this.students.length; i++) {
			if (id == this.students[i].getId()) {
				return false;
			}
		}
		return true;
	}
}
