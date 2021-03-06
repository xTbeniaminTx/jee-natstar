package fr.natsystem.tp.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_COULEUR")
public class Couleur {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_couleur")
	@SequenceGenerator(name = "SQ_couleur", sequenceName = "SQ_couleur", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "couleur")
	@Size(min = 1, max = 255, message = "La taille est limite a 255 est min 1")
	private String couleur;

	@Column(name = "petillant")
	@Size(max = 3, message = "La taille max est 3 char")
	private String petillant;

	public Couleur() {
		super();
	}

	public Couleur(String couleur, String petillant) {
		super();
		this.couleur = couleur;
		this.petillant = petillant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getPetillant() {
		return petillant;
	}

	public void setPetillant(String petillant) {
		this.petillant = petillant;
	}

}
