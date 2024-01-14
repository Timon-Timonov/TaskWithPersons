package it_academy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PersonsGenerator {

	private static Random rnd = new Random();

	public static List<Person> generatePersons(int count) {
		return IntStream.range(0, count)
				.mapToObj(i -> new Person(
						getRandName(),
						getRandSurName(),
						getRandAge()))
				.collect(Collectors.toList());
	}

	public static int getRandAge() {
		int min = ConstantContainer.MIN_AGE;
		int max = ConstantContainer.MAX_AGE;
		return (rnd.nextInt(max - min + 1) + min);
	}

	private static String getRandName() {
		return ConstantContainer.names[rnd.nextInt(ConstantContainer.names.length)];
	}

	private static String getRandSurName() {
		return ConstantContainer.surNames[rnd.nextInt(ConstantContainer.surNames.length)];
	}
}
