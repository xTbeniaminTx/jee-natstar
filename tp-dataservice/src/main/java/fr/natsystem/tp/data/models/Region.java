package fr.natsystem.tp.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_REGION")
public class Region {

	@Id
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "nom")
	@Size(min = 1, max = 255, message = "La taille du nom est limite a 255 est min 1")
	private String nom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
