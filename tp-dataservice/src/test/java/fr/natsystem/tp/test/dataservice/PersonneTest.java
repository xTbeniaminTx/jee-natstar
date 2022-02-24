package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
		List<Personne> result = personneDataService.getPersonnesParNomEtDateNaissance("AA", 2000L);

		for (Personne personne : result) {
			System.out.println(personne);
		}

		assertNotNull(result);

	}

	@Test
	public void testPagination() {
		Page<Personne> result = personneDataService.getListePersonnesPaginee(0, 10);

		for (Personne personne : result) {
			System.out.println(personne);
		}

		assertNotNull(result);

	}

}
