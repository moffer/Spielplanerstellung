package de.rmuselmann.logic.team;

import java.util.ArrayList;
import java.util.List;

public class TeamName {

	private static List<String> names = new ArrayList<>();

	private static boolean init = false;

	public static String randomName() {
		if (!init) {
			names.add("Ottifanten");
			names.add("Namenlosen");
			names.add("Breathless");
			names.add("Die Toten Handballer");
			names.add("Forever young");
			names.add("Victorious Secret");
			names.add("Wii Not Fit");
			names.add("Here for Beer");
			names.add("e-LEMON-ators");
			names.add("One Hit Wonders");
			names.add("Super Heroes In Training");
			names.add("The Untouchables");
			names.add("Die taffen Giraffen");
			names.add("Gegengegengegen");
			names.add("Auffallen durch Umfallen");
			names.add("Stil vor Talent");
			names.add("Topp, die Fette grillt!");
			names.add("Gut und aussehend");
			init = true;
		}
		int randomNumber = (int) (Math.random() * names.size());
		String name = names.get(randomNumber);
		names.remove(randomNumber);
		return name;
	}
}
