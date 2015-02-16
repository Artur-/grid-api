package org.vaadin.artur.whatsnewinvaadin74.data;

import java.util.Random;

public class Vaadiners {

	private static String[] firstNames = new String[] { "AMahdy", "Amir",
		"Anna", "Artem", "Artur", "Bogdan", "Denis", "Dmitrii", "Enver",
		"Felype", "Fredrik", "Guillermo", "Haijian", "Hannu", "Heikki",
		"Henri", "Henrik", "Jani", "Jarmo", "Jarno", "Jens", "Joacim",
		"Johannes", "John", "Jonas", "Jonatan", "Jonni", "Joonas", "Jouni",
		"Juho", "Jurka", "Juuso", "Kari", "Kim", "Leif", "Maciej",
		"Manuel", "Marc", "Marcus", "Marko", "Markus", "Marlon", "Matti",
		"Michael", "Mika", "Mikael", "Mikołaj", "Minna", "Murat", "Olli",
		"Patrik", "Pekka", "Peter", "Petri", "Petter", "Risto", "Rolf",
		"Sami", "Samuli", "Sauli", "Sebastian", "Sergey", "Tanja", "Tapio",
		"Teemu", "Teppo", "Thomas", "Tiina", "Tomi", "Ville" };

	private static String[] lastNames = new String[] { "Aali", "Abdelaziz",
		"Ahlroos", "Al-Majdalawi", "Alvarez", "Anisimov", "Budkin",
		"Carrasco Moñino", "Dahlström", "Ekblad", "Englund", "Eriksson",
		"Ferreira", "Godin", "Grankvist", "Granvik", "Grönroos", "Haase",
		"Heinonen", "Hellberg", "Helttula", "Hohti", "Holmström", "Hosio",
		"Hyvönen", "Häyry", "Ingman", "Jansson", "Kaitanen", "Kaksonen",
		"Kemppainen", "Kerola", "Koivisto", "Koivuviita", "Koskinen",
		"Kronqvist", "Kurki", "Laakso", "Lehtinen", "Lehto", "Leppänen",
		"Lindström", "Mattsson", "Murtojärvi", "Muurimaa", "Nakari",
		"Nurminen", "Nyholm", "Ohinmaa", "Olszewski", "Paul", "Penttilä",
		"Perälä", "Przepiora", "Päivärinne", "Pöntelin", "Rahikkala",
		"Rantala", "Repo", "Richert", "Rogozin", "Rönnlund", "Saarinen",
		"Salonen", "Sara", "Signell", "Skogström", "Smeds", "Suo-Anttila",
		"Tahvonen", "Tuikkala", "Tzukanov", "Tähkäpää", "Udrescu", "Valli",
		"Vappula", "Vesa", "Viitanen", "Virkki", "Virtanen", "Wang",
		"Wasberg", "Yamak", "Yrjänä", "Åstrand" };

	public static String getFirstName(Random r) {
		return firstNames[r.nextInt(firstNames.length)];
	}

	public static String getLastName(Random r) {
		return lastNames[r.nextInt(lastNames.length)];
	}

}
