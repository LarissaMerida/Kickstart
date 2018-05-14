package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Models.User;
import Resources.Category;
import Resources.Donation;
import Resources.Project;

public class ProjectTest {
	Project project;
	
	@Before
	public void setUp() throws Exception {
		project = new Project();
	}

	@Test
	public void testProject() {
		User user = new User("adm", "adm@gmail.com", "adm");
		Donation donation = new Donation(0);
		project = new Project(user, "ProjectTest", Category.ARTS, donation, "no more information");
		
		assertTrue(project.getName().equals("ProjectTest"));
		assertTrue(project.getCategory().equals(Category.ARTS));
		assertTrue(project.getAuthor().getName().equals(user.getName()));

	}

	@Test
	public void testGetDonation() {
		assertNull(project.getCategory());
	}
}
