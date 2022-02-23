package fr.natsystem.tp.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.natsystem.tp.data.models.Bouteille;

public interface BouteilleRepository extends JpaRepository<Bouteille, Long>, Serializable {

}
