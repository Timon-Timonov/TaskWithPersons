package it_academy;

import java.util.Random;

public class PersonsFieldsGenerator {

	private static Random rnd = new Random();

	public static int getRandAge() {
		return (rnd.nextInt(ConstantContainer.MAX_AGE - ConstantContainer.MIN_AGE + 1) + ConstantContainer.MIN_AGE);
	}

	public static String getRandName() {
		return ConstantContainer.names[rnd.nextInt(ConstantContainer.names.length)];
	}

	public static String getRandSurName() {
		return ConstantContainer.surNames[rnd.nextInt(ConstantContainer.surNames.length)];
	}
}
