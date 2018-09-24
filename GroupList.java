package yahoo.sofiia.riazanova;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class GroupList implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private Group[] groupsList = new Group[10];
	private File folder;

	public GroupList(Group[] groupsList, File folder) {
		super();
		this.groupsList = groupsList;
		this.folder = folder;
	}

	public GroupList() {
		super();
	}

	public Group[] getGroupsList() {
		return groupsList;
	}

	public void setGroupsList(Group... groupsList) {
		this.groupsList = groupsList;
	}

	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}

	@Override
	public String toString() {
		return "GroupList [groupsList=" + Arrays.toString(groupsList) + ", folder=" + folder + "]";
	}

	public void addGrouptoList(Group group) {
		if (group == null) {
			throw new IllegalArgumentException("Null group");
		}
		for (int i = 0; i < groupsList.length; i++) {
			if (groupsList[i] == null) {
				groupsList[i] = group;
			}
			if (i == groupsList.length - 1) {
				groupsList = Arrays.copyOf(groupsList, groupsList.length + 1);
				groupsList[groupsList.length - 1] = group;
				break;
			}
		}
	}

	public boolean deleteGroup(int groupNumber) {
		boolean check = false;
		for (int i = 0; i < groupsList.length; i++) {
			if (groupsList[i] != null && groupsList[i].getGroupNumber() == groupNumber) {
				check = true;
				new File(folder, "group " + groupNumber).delete();
				break;
			}
		}
		return check;
	}

	public Group findGroupByNumber(int groupNumber) {
		for (Group group : groupsList) {
			if (groupNumber == group.getGroupNumber()) {
				return group;
			}
		}
		return null;
	}

	public boolean addGroupToFile(int groupNumber) throws IOException {
		if (findGroupByNumber(groupNumber) == null) {
			return false;
		}
		try {
			SaveFromToFile.loadToFile(findGroupByNumber(groupNumber), this.folder);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean saveGroupListToFiles() throws IOException {
		boolean check = false;
		try {
			for (int i = 0; i < groupsList.length; i++) {
				SaveFromToFile.loadToFile(groupsList[i], this.folder);
				check = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return check;
	}
}
