package de.rmuselmann.gui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.rmuselmann.logic.general.Age;
import de.rmuselmann.logic.general.Person;
import de.rmuselmann.logic.team.TeamLogic;

public class TestMain {
	public static void main(String[] args) {
		TeamLogic teamLogic = new TeamLogic();
		Map<Age, List<Person>> personAgeList = new HashMap<>();
		
		
		teamLogic.generateTeams(personAgeList);
	}
}
