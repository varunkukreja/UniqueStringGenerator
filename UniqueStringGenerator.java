import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class UniqueStringGenerator {

	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	private static final String NUMBER = "0123456789";

	private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
	private static SecureRandom random = new SecureRandom();
	private static Set<String> uniqueStringSet = new HashSet<String>();

	public static void main(String[] args) {

		System.out.println("String : " + DATA_FOR_RANDOM_STRING);
		
		long numberofLines = Long.parseLong(args[0]);

		for (int i = 0; i < numberofLines; i++) {
			generateString();
		}
		
		System.out.println("stringSet  " + uniqueStringSet.size());

		writeData();

		
	}

	public static void generateString() {

		StringBuilder sb = new StringBuilder(100);

		for (int i = 0; i < 100; i++) {
			int randomCharIndex = random.nextInt(DATA_FOR_RANDOM_STRING.length());
			char randomChar = DATA_FOR_RANDOM_STRING.charAt(randomCharIndex);
			sb.append(randomChar);
		}

		String str = sb.toString();

		if (!uniqueStringSet.contains(str)) {
			uniqueStringSet.add(str);
		} else {
			generateString();
		}

	}

	public static void writeData() {
		
		try {
			
			FileWriter fileWriter = new FileWriter("filename.txt");
			for (String string : uniqueStringSet) {
				fileWriter.write(string + "\n");

			}
			fileWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
