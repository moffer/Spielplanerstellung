package de.rmuselmann.logic.team;

import java.util.ArrayList;
import java.util.List;

import de.rmuselmann.logic.general.Person;

public class Team {

	private List<Person> members = new ArrayList<>();
	private int teamNumber;

	public Team(int teamNumber) {
		this.setTeamNumber(teamNumber);
	}

	public void addMember(Person person) {
		members.add(person);
	}

	@Override
	public String toString() {
		return "Team[teamNumber: " + teamNumber + "]";
	}

	public List<Person> getMembers() {
		return members;
	}

	public void setMembers(List<Person> members) {
		this.members = members;
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

}
