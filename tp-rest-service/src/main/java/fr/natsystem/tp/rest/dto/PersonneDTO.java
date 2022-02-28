package fr.natsystem.tp.rest.dto;

import java.time.LocalDate;

import fr.natsystem.tp.data.validation.PrenomCommenceParX;

public class PersonneDTO {

	private Long id;
	private String nom;

	@PrenomCommenceParX(message = "La personne nest pas un extraterestre")
	private String prenom;

//	@JsonDeserialize(using = LocalDateDeserializerUtil.class)
//	@JsonSerialize(using = LocalDateSerializerUtil.class)
	private LocalDate dateNaissance;

	public PersonneDTO() {
		super();
	}

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
