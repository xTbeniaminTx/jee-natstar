package fr.natsystem.tp.data.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fr.natsystem.tp.data.embedded.IdentitePk;

@Entity
@Table(name = "t_personne")
public class Personne {

	@Column(name = "id")
	@NotNull(message = "L'id doit etre reinseigne")
	private Long id;

	@EmbeddedId
	private IdentitePk identite;

	public Personne() {
		super();
	}

	public Personne(IdentitePk identite) {
		super();
		this.identite = identite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public IdentitePk getIdentite() {
		return identite;
	}

	public void setIdentite(IdentitePk identite) {
		this.identite = identite;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", identite=" + identite + "]";
	}

}
