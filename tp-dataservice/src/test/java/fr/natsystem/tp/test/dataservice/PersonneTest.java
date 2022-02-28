package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.tp.data.embedded.IdentitePk;
import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.services.PersonneDataService;
import fr.natsystem.tp.data.services.ValidationService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")
public class PersonneTest {

	@Autowired
	private PersonneDataService personneDataService;
	
	@Inject
	private ValidationService validator;
	
	@Test
	public void testAnnotation() {
		IdentitePk identite = new IdentitePk();
		identite.setNom("AAAAAAAA");
		identite.setPrenom("BBBBBBBBB");
		identite.setDateNaissance(LocalDate.of(1998, 12, 15));
				
		
		Personne personne = new Personne();
		personne.setIdentite(identite);
		personne.setId(100L);
		
		Personne result = personneDataService.createPersonne(personne);
		
		assertNotNull(result);
		
	}

}
