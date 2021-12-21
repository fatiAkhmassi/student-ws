package dev.fatima.etudiantServiceConsumer;

import lombok.Data;

@Data
public class Etudiant {
	private long id;
	private String name;
	private int age;
	private long roomId;
}
