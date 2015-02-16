package org.vaadin.artur.whatsnewinvaadin74.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Persons {

	public static List<Person> create(int nr) {
		Random r = new Random(1);
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < nr; i++) {
			Person p = new Person(r);
			persons.add(p);
		}
		return persons;
	}

}
