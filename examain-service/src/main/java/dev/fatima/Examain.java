package dev.fatima;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import dev.fatima.etudiantServiceConsumer.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Examain {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String matier;
	private float note;
	private long etudiantId;
	@Transient public Etudiant etudiant;
}
