import java.io.File;

/**
 * 
 */

/**
 * @author Chinmay
 *
 */
public class Fragmentor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String directoryPath = System.getProperty("user.dir");
		File dir = new File(directoryPath);
		String[] files = dir.list();
		for (int i = 0; i < files.length; i++) {
			if (files[i].endsWith(".txt")) {
				File tempFile = new File(directoryPath + File.separator+ files[i]);
				System.out.println(tempFile);
			}
		}
	}

}
