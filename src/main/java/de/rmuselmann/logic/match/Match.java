package de.rmuselmann.logic.match;

import de.rmuselmann.logic.team.Team;

public class Match {
	private Team teamA;
	private Team teamB;
	private int resultA;
	private int resultB;

	public Team getWinningTeam() {
		if (resultA - resultB > 0) {
			return teamA;
		} else {
			return teamB;
		}
	}
}
