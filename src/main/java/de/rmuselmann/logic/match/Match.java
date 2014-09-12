package de.rmuselmann.logic.match;

import java.util.Date;

import de.rmuselmann.logic.team.Team;

public class Match {
	private Team teamA;
	private Team teamB;
	private int resultA;
	private int resultB;

	private Date date;

	private MatchField field;

	public Match(Team teamA, Team teamB, MatchField field, Date date) {
		this.setTeamA(teamA);
		this.setTeamB(teamB);
		this.setField(field);
		this.date = date;
	}

	public Match() {
	}

	public Team getWinningTeam() {
		if (getResultA() - getResultB() > 0) {
			return getTeamA();
		} else {
			return getTeamB();
		}
	}

	@Override
	public String toString() {
		return "Match[TeamA: " + teamA + ", TeamB: " + teamB + "]";
	}

	public MatchField getField() {
		return field;
	}

	public void setField(MatchField field) {
		this.field = field;
	}

	public int getResultB() {
		return resultB;
	}

	public void setResultB(int resultB) {
		this.resultB = resultB;
	}

	public int getResultA() {
		return resultA;
	}

	public void setResultA(int resultA) {
		this.resultA = resultA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
