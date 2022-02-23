package fr.natsystem.tp.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.natsystem.tp.data.models.Couleur;

public interface CouleurRepository extends JpaRepository<Couleur, Long>, Serializable {

}
