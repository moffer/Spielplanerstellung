package de.rmuselmann.logic.team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.rmuselmann.logic.general.Age;
import de.rmuselmann.logic.general.Person;

public class TeamLogic {
	private static int minTeamSize = 7;

	public List<Team> generateTeams(Map<Age, List<Person>> personAgeList) {
		int countOfPerson = 0;
		for (Age age : personAgeList.keySet()) {
			List<Person> persons = personAgeList.get(age);
			countOfPerson += persons.size();
		}
		int countOfTeams = countOfPerson / minTeamSize;
		List<Team> teams = new ArrayList<>();

		for (int i = 0; i < countOfTeams; i++) {
			teams.add(new Team());
		}
		for (Entry<Age, List<Person>> entry : personAgeList.entrySet()) {
			int currentTeamIndex = 0;
			for (Person person : entry.getValue()) {
				teams.get(currentTeamIndex).addMember(person);
				currentTeamIndex = currentTeamIndex < countOfTeams - 1 ? ++currentTeamIndex : 0;
			}
		}
		return teams;
	}
}
