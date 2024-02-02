package it_academy;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable, Comparable<Person> {

	private String name;
	private String surName;
	private int age;

	public Person(String name, String surName, int age) {
		this.name = name;
		this.surName = surName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} else this.age = 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Person)) return false;
		Person person = (Person) o;
		return getAge() == person.getAge() &&
				Objects.equals(getName(), person.getName()) &&
				Objects.equals(getSurName(), person.getSurName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getSurName(), getAge());
	}

	@Override
	public String toString() {
		return "Person{" +
				"surName='" + surName + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public int compareTo(Person o) {
		if (this.getSurName().compareTo(o.getSurName()) == 0) {
			if (this.getName().compareTo(o.getName()) == 0) {
				return this.getAge() - o.getAge();
			}
			return this.getName().compareTo(o.getName());
		}
		return this.getSurName().compareTo(o.getSurName());
	}
}
