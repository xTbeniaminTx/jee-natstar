package fr.natsystem.tp.rest.dto;

public class RegionDTO {

	private Long id;
	private String nom;

	public RegionDTO() {
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

	@Override
	public String toString() {
		return "RegionDTO [id=" + id + ", nom=" + nom + "]";
	}

}
