package de.rmuselmann.logic.general;

public enum Age {

	CHILD(1L), TEENAGER(2L), ADULT(3L);

	private Long id;

	private Age(Long id) {
		this.setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Age fromId(Long id) {
		for (Age age : Age.values()) {
			if (age.getId().equals(id))
				return age;
		}

		throw new IllegalArgumentException("Es gibt kein Alter mit der ID " + id);
	}

}
