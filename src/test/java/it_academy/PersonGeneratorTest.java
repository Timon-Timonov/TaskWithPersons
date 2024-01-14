package it_academy;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static it_academy.PersonsFieldsGenerator.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonGeneratorTest {

	public static final int COUNT_OF_ASSERTS = 1000;
	private List<Person> personList = IntStream.range(0, ConstantContainer.COUNT_OF_PERSONS)
			.mapToObj(i -> new Person(
					getRandName(),
					getRandSurName(),
					getRandAge()))
			.collect(Collectors.toList());


	@Test
	void getRandAgTest() {
		for (int i = 0; i < COUNT_OF_ASSERTS; i++) {
			assertTrue(PersonsFieldsGenerator.getRandAge() >= ConstantContainer.MIN_AGE
					&& PersonsFieldsGenerator.getRandAge() <= ConstantContainer.MAX_AGE);
		}
	}
}