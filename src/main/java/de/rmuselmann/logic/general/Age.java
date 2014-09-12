package de.rmuselmann.logic.general;


public enum Age {

	CHILD(1L, "Kind"), TEENAGER(2L, "Jugendlicher"), ADULT(3L, "Erwachsener");

	private Long id;
	private String name;

	private Age(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Age fromId(Long id) {
		for (Age age : Age.values()) {
			if (age.getId().equals(id))
				return age;
		}

		throw new IllegalArgumentException("Es gibt kein Alter mit der ID " + id);
	}

	public String getName() {
		return name;
	}

}
