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

	public void addGrouptoListAndFile(Group group) throws IOException {
		if (group == null) {
			throw new IllegalArgumentException("Null group");
		}
		if (groupsList[groupsList.length - 1] != null) {
			groupsList = Arrays.copyOf(groupsList, groupsList.length + 1);
		}
		for (int i = 0; i < groupsList.length; i++) {
			if (groupsList[i] == null) {
				groupsList[i] = group;
				break;
			}
			try {
				SaveFromToFile.loadToFile(group, this.folder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Group findGroupByNumber(int groupNumber) {
		try {
			for (Group group : groupsList) {
				if (groupNumber == group.getGroupNumber()) {
					return group;
				}
			}
		} catch (NullPointerException e) {
		}
		return null;
	}

	public void saveGroupListToFiles() throws IOException {
		try {
			for (int i = 0; i < groupsList.length; i++) {
				if (groupsList[i] == null) {
					throw new IllegalArgumentException("Null group");
				}
				SaveFromToFile.loadToFile(groupsList[i], this.folder);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean deleteGroup(int groupNumber) {
		boolean check = false;
		for (int i = 0; i < groupsList.length; i++) {
			if (groupsList[i] != null && groupsList[i].getGroupNumber() == groupNumber) {
				check = true;
				System.arraycopy(groupsList, i + 1, groupsList, i, groupsList.length - i - 1);
				groupsList[groupsList.length - 1] = null;
				new File(folder, "group " + groupNumber).delete();
				break;
			}
		}
		return check;
	}
}
