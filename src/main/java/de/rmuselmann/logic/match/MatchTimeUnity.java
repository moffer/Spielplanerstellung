package de.rmuselmann.logic.match;

import java.util.Date;
import java.util.List;

/**
 * Klasse zur Darstellung eines Spielzeit.
 * 
 * @author Internet
 *
 */
public class MatchTimeUnity {
	private Date matchTime;
	private List<Match> fields;

	public Date getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	public List<Match> getFields() {
		return fields;
	}

	public void setFields(List<Match> fields) {
		this.fields = fields;
	}
}
