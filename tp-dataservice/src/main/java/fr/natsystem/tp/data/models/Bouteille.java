package fr.natsystem.tp.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_Bouteille")
public class Bouteille {

	@Id
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "nom")
	@Size(min = 1, max = 255, message = "La taille du nom est limite a 255 est min 1")
	private String nom;

	@Column(name = "nb_bouteilles")
	private Long nbBouteilles;

	@Column(name = "contenance")
	private Long contenance;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "region_rf")
	private Region regionRf;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "couleur_rf")
	private Couleur couleurRf;

	public Bouteille() {
		super();
	}

	public Bouteille(String nom) {
		super();
		this.nom = nom;
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

	public Long getNbBouteilles() {
		return nbBouteilles;
	}

	public void setNbBouteilles(Long nbBouteilles) {
		this.nbBouteilles = nbBouteilles;
	}

	public Long getContenance() {
		return contenance;
	}

	public void setContenance(Long contenance) {
		this.contenance = contenance;
	}

	public Region getRegionRf() {
		return regionRf;
	}

	public void setRegionRf(Region regionRf) {
		this.regionRf = regionRf;
	}

	public Couleur getCouleurRf() {
		return couleurRf;
	}

	public void setCouleurRf(Couleur couleurRf) {
		this.couleurRf = couleurRf;
	}

}
