package yahoo.sofiia.riazanova;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String[] goods = new String[] { "Coffee", "Tea", "Water", "Wine", "Milk" };
		int[] prices = new int[] { 30, 15, 20, 200, 40 };
		int[] count = new int[] { 150, 200, 53, 23, 40 };
		String report = getReport(goods, prices, count);
		File file1 = new File("report.cvs");
		saveStringToFile(report, file1);
	}

	public static String getReport(String[] goods, int[] prices, int[] count) {
		String report = "";
		for (int i = 0; i < goods.length; i++) {
			report += goods[i] + ", " + prices[i] + ", " + count[i] + System.lineSeparator();
		}

		return report;
	}

	public static void saveStringToFile(String text, File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
