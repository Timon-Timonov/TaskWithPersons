package it_academy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {
	public static final String NAME = "Bred";
	public static final String SUR_NAME = "Pit";
	public static final int AGE = 45;
	public static final int AGE_0 = 0;
	public static final int NEGATIVE_VALUE = -1;

	private Person person1 = new Person(NAME, SUR_NAME, AGE);
	private Person person2 = new Person(NAME, SUR_NAME, AGE);

	@Test
	void getAge() {
		assertEquals(AGE, person1.getAge());
		assertEquals(person2.getAge(), person1.getAge());
	}

	@Test
	void getName() {
		assertEquals(NAME, person1.getName());
		assertEquals(person2.getName(), person1.getName());
	}

	@Test
	void getSurName() {
		assertEquals(SUR_NAME, person1.getSurName());
		assertEquals(person2.getSurName(), person1.getSurName());
	}


	@Test
	void testEquals() {
		assertEquals(person1, person2);
	}

	@Test
	void testHashCode() {
		assertEquals(person1.hashCode(), person2.hashCode());
	}

	@Test
	void compareTo() {
		assertEquals(0, person1.compareTo(person2));
		int age = AGE;
		person2.setAge(++age);
		assertTrue(0 > person1.compareTo(person2));
		person2.setAge(AGE);
		person2.setName("A" + NAME);
		assertTrue(0 < person1.compareTo(person2));
		person2.setName(NAME);
		person2.setSurName("A" + SUR_NAME);
		assertTrue(0 < person1.compareTo(person2));
		person2.setSurName(SUR_NAME);
	}


	@Test
	void setName() {
		person1.setName(SUR_NAME);
		assertEquals(SUR_NAME, person1.getName());
	}

	@Test
	void setSurName() {
		person2.setSurName(NAME);
		assertEquals(NAME, person2.getSurName());
	}

	@Test
	void setAge() {
		person1.setAge(AGE_0);
		person2.setAge(AGE_0);
		assertEquals(AGE_0, person1.getAge());
		assertEquals(person2.getAge(), person1.getAge());
		person1.setAge((AGE * NEGATIVE_VALUE));
		assertEquals(AGE_0, person1.getAge());
	}

	@Test
	void testToString() {
		person1.setAge(AGE_0);
		person1.setSurName(SUR_NAME);
		person1.setName(NAME);
		assertEquals("Person{surName='Pit', name='Bred', age=0}", person1.toString());
	}
}