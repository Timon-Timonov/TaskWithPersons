package it_academy;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static it_academy.PersonsFieldsGenerator.*;

public class App {

	public static void main(String[] args) {

		List<Person> personList = IntStream.range(0, ConstantContainer.COUNT_OF_PERSONS)
				.mapToObj(i -> new Person(
						getRandName(),
						getRandSurName(),
						getRandAge()))
				.collect(Collectors.toList());

		System.out.println("Persons with age less then " + ConstantContainer.FILTER_MAX_AGE_EXCLUDE + " years:");
		AtomicInteger i = new AtomicInteger(1);
		List<Person> shotList = personList
				.stream()
				.filter((P) -> (P.getAge() < ConstantContainer.FILTER_MAX_AGE_EXCLUDE))
				.peek((person -> System.out.println(i.getAndIncrement() + ") " + person.toString())))
				.sorted(Comparator.comparing(Person::getSurName)
						.thenComparing(Person::getName))
				.distinct()
				.collect(Collectors.toList());

		writePersonsInFile(shotList, ConstantContainer.PATH_TO_FILE);

		List<Person> personsFromFile = readPersonsFromFile(ConstantContainer.PATH_TO_FILE);

		List<String> names = personsFromFile.stream()
				.map((person -> person.getSurName() + " " + person.getName()))
				.collect(Collectors.toList());

		System.out.println();
		System.out.println("Persons from file:");
		i.set(1);
		names.forEach((str) -> System.out.println(i.getAndIncrement() + ") " + str));
	}

	public static List<Person> readPersonsFromFile(String path) {

		List<Person> list = new ArrayList<>();

		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path))) {

			while (true) {
				Person p;
				try {
					p = (Person) oi.readObject();
					list.add(p);
				} catch (EOFException e) {
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void writePersonsInFile(List<Person> list, String path) {

		try (ObjectOutputStream oo = new ObjectOutputStream(
				new FileOutputStream(path))) {
			list.forEach((P) -> {
				try {
					oo.writeObject(P);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
