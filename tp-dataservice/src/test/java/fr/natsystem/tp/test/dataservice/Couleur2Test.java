package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.tp.data.models.Couleur2;
import fr.natsystem.tp.data.repository.Couleur2Repository;
import fr.natsystem.tp.data.utilities.CouleurEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")
public class Couleur2Test {

	@Autowired
	private Couleur2Repository repo;

	@Test
	public void testSaveCouleur() {
		Couleur2 couleur = new Couleur2(CouleurEnum.ROUGE_ENUM, Boolean.FALSE);
		Couleur2 result = repo.save(couleur);
		assertNotNull(result);
	}

}
