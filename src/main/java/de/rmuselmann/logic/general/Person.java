package de.rmuselmann.logic.general;

public class Person {

	private String name;
	private Age age;

	public Person(String name, Age age) {
		this.age = age;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person[name: " + name + "]";
	}

}
