package yahoo.sofiia.riazanova;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Group one = new Group();
		one.setGroupNumber(1);
		Student a = new Student("Katya", "Ivanova", 19, "f");
		Student b = new Student("Tanya", "Ketrova", 21, "f");
		Student c = new Student("Katya", "Pyj", 19, "f");
		Student d = new Student("Alisa", "Cuchek", 20, "f");
		Student e = new Student("Aleksey", "Ivanov", 19, "m");
		Student f = new Student("Igor", "Petrov", 18, "m");
		Student g = new Student("Jenya", "Petrov", 18, "m");
		try {
			one.addStudent(a);
			one.addStudent(b);
			one.addStudent(c);
			one.addStudent(d);
		} catch (OversizedException exception) {
			System.out.println(exception.getMessage());
		}
		Group two = new Group();
		two.setGroupNumber(2);
		try {
			two.addStudent(e);
			two.addStudent(f);
			two.addStudent(g);
		} catch (OversizedException e1) {
			e1.printStackTrace();
		}
		GroupList glOne = new GroupList();
		File folder = new File("List");
		folder.mkdirs();
		glOne.setFolder(folder);
		try {
			glOne.addGrouptoListAndFile(two);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		System.out.println(glOne.findGroupByNumber(4));
		System.out.println(glOne);
		GroupList glTwo = new GroupList();
		File folderTwo = new File("List2");
		folderTwo.mkdirs();
		glTwo.setGroupsList(one, two);
		glTwo.setFolder(folderTwo);
		try {
			glTwo.saveGroupListToFiles();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Group glThree = new Group();
		try {
			glThree = SaveFromToFile.loadFromFile(new File(folder, "group 1"));
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(glThree);
		glTwo.deleteGroup(1);
		System.out.println(glTwo);
	}
}
