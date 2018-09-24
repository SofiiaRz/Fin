package yahoo.sofiia.riazanova;

import java.io.Serializable;

public class Student extends Human implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int groupNumber;

	public Student(String firstName, String lastName, int age, String sex, int groupNumber) {
		super(firstName, lastName, age, sex);
		this.groupNumber = groupNumber;
	}

	public Student(String firstName, String lastName, int age, String sex) {
		super(firstName, lastName, age, sex);
	}

	public Student() {
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	@Override
	public String toString() {
		return "Student [groupNumber=" + groupNumber + "," + super.toString();
	}
}
