package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.services.PersonneDataService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")
public class PersonneTest {
	
	@Autowired
	private PersonneDataService personneDataService;
	
	@Test
	public void testGetPersonne() {
		List<Personne> result = personneDataService.getPersonnesParNomEtDateNaissance("A", 1998L);
		assertNotNull(result);
	}


}
