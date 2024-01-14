package it_academy;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PersonGeneratorTest {

	public static final int COUNT_OF_ASSERTS = 1000;
	private List<Person> list = PersonsGenerator.generatePersons(COUNT_OF_ASSERTS);

	@Test
	void generatePersons() {

		assertEquals(COUNT_OF_ASSERTS, list.size());
		for (Person p : list) {
			assertNotNull(p);
		}
	}

	@Test
	void getRandAge() {
		for (int i = 0; i < COUNT_OF_ASSERTS; i++) {
			assertTrue(PersonsGenerator.getRandAge() >= ConstantContainer.MIN_AGE
					&& PersonsGenerator.getRandAge() <= ConstantContainer.MAX_AGE);
		}
	}
}