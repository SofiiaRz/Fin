package yahoo.sofiia.riazanova;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class Group implements Voenkom, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private transient Scanner sc = new Scanner(System.in);
	private Student[] students = new Student[10];
	private int groupNumber;

	public Group(Student[] students, int groupNumber) {
		super();
		this.students = students;
		this.groupNumber = groupNumber;
	}

	public Group() {
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public void addStudent(Student student) throws OversizedException {
		if (student == null) {
			throw new IllegalArgumentException("Please input details about student");
		}
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				student.setGroupNumber(this.groupNumber);
				students[i] = student;
				break;
			}
			if (students[students.length - 1] != null && i == students.length - 1) {
				throw new OversizedException();
			}
		}
	}

	public void addStudentTyping() throws OversizedException {
		Student student = new Student();
		student.setFirstName(getFirstName());
		student.setLastName(getLastName());
		student.setSex(getSex());
		student.setAge(getAge());
		addStudent(student);
	}

	private String getFirstName() {
		System.out.println("Input first name and press Enter");
		String fn = sc.nextLine();
		if (fn.equals("")) {
			throw new NullPointerException("Enter name");
		}
		return fn;
	}

	private String getLastName() {
		System.out.println("Input last name and press Enter");
		String ln = sc.nextLine();
		if (ln.equals("")) {
			throw new NullPointerException("Enter name");
		}
		return ln;
	}

	private String getSex() {
		System.out.println("Input sex (m or f) and press Enter");
		String s = sc.nextLine();
		if (s.equals("")) {
			throw new NullPointerException("Enter sex");
		}
		if (!s.equals("m") && !s.equals("f")) {
			throw new IllegalArgumentException("Enter correct sex");
		}
		return s;
	}

	private int getAge() {
		System.out.println("Input age and press Enter");
		int a = sc.nextInt();
		sc.close();
		if (a < 14 || a > 100) {
			throw new IllegalArgumentException("Enter correct age");
		}
		return a;
	}

	public boolean deleteStudent(String name) {
		boolean check = false;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getLastName().equals(name)) {
				check = true;
				students[i] = null;
				System.arraycopy(students, i + 1, students, i, students.length - i - 1);
				students[students.length - 1] = null;
				break;
			}
		}
		return check;
	}

	public Student searchStudent(String name) {
		int a = -1;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getLastName().equals(name)) {
				a = i;
				break;
			}
		}
		if (a != -1) {
			System.out.println("The number of student in " + groupNumber + " group is " + a);
			return students[a];
		} else {
			System.out.println("There is no such student in group # " + groupNumber);
			return null;
		}
	}

	@Override
	public Student[] goToArmy() {
		int quantity = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getAge() > 17 && students[i].getSex().equals("m")) {
				quantity = quantity + 1;
			}
		}
		Student[] a = new Student[quantity];
		int b = 0;
		for (int j = 0; j < students.length; j++) {
			if (students[j] != null && students[j].getAge() > 17 && students[j].getSex().equals("m")) {
				a[b] = students[j];
				b++;
			}
		}
		return a;
	}

	public void sortByName() {
		Arrays.sort(students, (nOne, nTwo) -> {
			if (nOne == null && nTwo != null)
				return 1;
			else if (nOne != null && nTwo == null)
				return -1;
			else if (nOne == null && nTwo == null)
				return 0;
			else
				return nOne.getLastName().compareTo(nTwo.getLastName());
		});
	}

	@Override
	public String toString() {
		return "Group " + groupNumber + " {students=" + Arrays.toString(students);
	}
}