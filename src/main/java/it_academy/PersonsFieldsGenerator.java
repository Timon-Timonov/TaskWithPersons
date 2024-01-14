package it_academy;

import java.util.Random;

public class PersonsFieldsGenerator {

	private static Random rnd = new Random();

	public static int getRandAge() {
		int min = ConstantContainer.MIN_AGE;
		int max = ConstantContainer.MAX_AGE;
		return (rnd.nextInt(max - min + 1) + min);
	}

	public static String getRandName() {
		return ConstantContainer.names[rnd.nextInt(ConstantContainer.names.length)];
	}

	public static String getRandSurName() {
		return ConstantContainer.surNames[rnd.nextInt(ConstantContainer.surNames.length)];
	}
}
