package it_academy;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
	public static final String PATH = "src\\test\\java\\it_academy\\file.bin";
	public static final int COUNT_OF_ASSERTS = 1000;

	private List<Person> list = App.generatePersons(COUNT_OF_ASSERTS);

	@Test
	void writeAndReadPersonsInFile() {
		File file = new File(PATH);
		App.writePersonsInFile(list, PATH);

		List<Person> listFromFile = App.readPersonsFromFile(PATH);

		assertEquals(listFromFile.size(), list.size());
		for (int i = 0; i < list.size(); i++) {
			assertEquals(listFromFile.get(i), list.get(i));
		}

		if (file.exists()) {
			file.delete();
		}
	}

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
			assertTrue(App.getRandAge() >= ConstantContainer.MIN_AGE
					&& App.getRandAge() <= ConstantContainer.MAX_AGE);
		}
	}
}