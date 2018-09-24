package yahoo.sofiia.riazanova;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SaveFromToFile {

	public static void loadToFile(Group group, File folder) throws IOException {
		if (group == null || folder == null) {
			throw new IllegalArgumentException();
		}
		new GroupList().setFolder(folder);
		try (ObjectOutput oos = new ObjectOutputStream(
				new FileOutputStream(new File(folder, "group " + group.getGroupNumber())));) {
			oos.writeObject(group);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Group loadFromFile(File file) throws IOException, ClassNotFoundException {
		if (file == null) {
			throw new IllegalArgumentException();
		}
		try (ObjectInput ois = new ObjectInputStream(new FileInputStream(file));) {
			return (Group) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
