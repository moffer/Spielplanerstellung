package de.rmuselmann.logic.match;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import de.rmuselmann.logic.team.Team;

public class MatchLogic {
	private static final int BREAK_MINUTES = 5;
	private static final int PLAY_MINUTES = 10;
	// jeder gegen jeden
	private static final int ROBIN_ROUND_TEAM_COUNT = 5;
	private Date startDate;

	public MatchLogic() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 10);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		startDate = c.getTime();
	}

	public List<Match> generateMatches(List<Team> teams, List<MatchField> fields) {
		if (teams == null) {
			return null;
		}
		if (teams.size() <= ROBIN_ROUND_TEAM_COUNT) {
			return generateRobinRoundMatches(teams, fields, startDate, PLAY_MINUTES, BREAK_MINUTES);
		}
		return null;
	}

	private List<Match> generateRobinRoundMatches(List<Team> teams, List<MatchField> fields, Date startTime,
			int playMinutes, int breakMinutes) {

		int teamSize = teams.size();
		List<Match> matches = new ArrayList<Match>();

		Date currentTime = startTime;

		if (fields.size() == 1) {
			// for (int i = teamSize - 1; i >= 0; i--) {
			// for (int j = i - 1; j >= 0; j--) {
			// Match m = new Match(teams.get(i), teams.get(j), fields.get(0));
			// System.out.println(m);
			// matches.add(m);
			// }
			// }

			for (int maxX = teamSize - 2; maxX >= 0; maxX--) {
				int j = teamSize - 1;
				for (int i = maxX; i >= 0; i--) {
					Match m = new Match(teams.get(i), teams.get(j), fields.get(0), currentTime);
					matches.add(m);
					currentTime = new Date(currentTime.getTime() + playMinutes * 60 * 1000 + breakMinutes * 60 * 1000);
					j--;
				}
			}

		} else if (fields.size() == 2) {
			throw new IllegalStateException(
					"Es können in der aktuellen Implementierung kann die übergebene Anzahl der Felder nicht verwertet werden.");
		} else {
			throw new IllegalStateException(
					"Es können in der aktuellen Implementierung kann die übergebene Anzahl der Felder nicht verwertet werden.");
		}
		return matches;
	}
}
