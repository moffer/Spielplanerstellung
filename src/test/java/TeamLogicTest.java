import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import de.rmuselmann.logic.general.Age;
import de.rmuselmann.logic.general.Person;
import de.rmuselmann.logic.team.Team;
import de.rmuselmann.logic.team.TeamLogic;

public class TeamLogicTest {

	@Test
	public void generationTest() {
		TeamLogic teamLogic = new TeamLogic();
		Map<Age, List<Person>> personAgeList = new HashMap<Age, List<Person>>();
		List<Person> children = new ArrayList<Person>();
		children.add(new Person("Alf", Age.CHILD));
		children.add(new Person("Yannik", Age.CHILD));
		children.add(new Person("Timo", Age.CHILD));
		children.add(new Person("Felix", Age.CHILD));
		children.add(new Person("Jonas", Age.CHILD));
		children.add(new Person("Malte", Age.CHILD));
		children.add(new Person("Hannes", Age.CHILD));
		children.add(new Person("Max", Age.CHILD));

		personAgeList.put(Age.CHILD, children);

		List<Person> teenager = new ArrayList<Person>();
		teenager.add(new Person("Vic", Age.TEENAGER));
		teenager.add(new Person("Rafael", Age.TEENAGER));
		teenager.add(new Person("Marcel", Age.TEENAGER));

		personAgeList.put(Age.TEENAGER, teenager);

		List<Person> adult = new ArrayList<Person>();
		adult.add(new Person("Sigrid", Age.ADULT));
		adult.add(new Person("Walter", Age.ADULT));
		adult.add(new Person("Alexandra", Age.ADULT));
		adult.add(new Person("Manfred", Age.ADULT));

		personAgeList.put(Age.ADULT, adult);
		List<Team> teams = teamLogic.generateTeams(personAgeList);
		Assert.assertNotNull(teams);
		Assert.assertEquals(2L, teams.size());
		Assert.assertEquals(8L, teams.get(0).getMembers().size());
		Assert.assertEquals(7L, teams.get(1).getMembers().size());
	}

}
