package com.saucedemo.utilities;

import java.util.Random;

public class RandomUtility {

	public static int randomNumberGeneration() {
		Random rand = new Random();
		// int rand_int1 = rand.nextInt(1000);
		int rand_int2 = rand.nextInt(1000);
		// System.out.println("Random Integers: " + rand_int1);
		// System.out.println("Random Integers: " + rand_int2);
		return rand_int2;
	}

	public static String randomTextGen() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;

	}

	public static String randomEmail() {
		String SALTCHARS = "FGHIJKLMNTUVWXYZABCDEPQ567890RSO1234";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr + "@gmail.com";
	}
}
