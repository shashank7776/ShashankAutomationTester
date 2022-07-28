package utilities;

import java.util.Random;

import org.apache.commons.text.RandomStringGenerator;

public class MainUtilities {
	
	/**
	 * Method to generate random string of given length
	 *
	 * @param length
	 *            - length of string you want to generate
	 * @return generated random string
	 */
	public static String generateRandomString(int length) {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
		return generator.generate(length);
	}

	/**
	 * This method used to get random digit of required length.
	 *
	 * @param n
	 *            n
	 * @return number
	 */
	public static long generateRandomDigits(int n) {
		int m = (int) Math.pow(10, n - Double.valueOf(1));
		return m + (long) new Random().nextInt(9 * m);
	}

	/**
	 * This method used to get random email id.
	 *
	 * @return email
	 */
	public static String generateRandomEmail() {
		return generateRandomString(5) + "@test.com";
	}

	/**
	 * This method used to generate IP address.
	 * 
	 * @return ip address
	 */
	public static String generateIpAddress() {
		Random random = new Random();
		return String.valueOf(random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) + "."
				+ random.nextInt(256));
	}

	/**
	 * This method used to generate random web URL.
	 * 
	 * @return URL
	 */
	public static String generateWebURL() {
		return "http://" + generateRandomString(7) + generateRandomDigits(4) + ".com";
	}
}
