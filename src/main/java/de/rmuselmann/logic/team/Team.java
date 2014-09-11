package de.rmuselmann.logic.team;

import java.util.ArrayList;
import java.util.List;

import de.rmuselmann.logic.general.Person;

public class Team {

	private List<Person> members = new ArrayList<>();

	public void addMember(Person person) {
		members.add(person);
	}

	public List<Person> getMembers() {
		return members;
	}

	public void setMembers(List<Person> members) {
		this.members = members;
	}

}
