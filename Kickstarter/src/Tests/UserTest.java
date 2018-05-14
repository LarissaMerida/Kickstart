package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Models.User;

public class UserTest extends User{
	public User user;
	@Before
	public void setUp() throws Exception {
		user = new User();
	}
	
	@Test
	public void testProject() {
		user = new User("adm", "adm@ic.ufal.br", "adm");
		
		assertTrue(user.getName().equals("adm"));
		assertTrue(user.getEmail().equals("adm@ic.ufal.br"));
		assertTrue(user.getPassword().equals("adm"));
	}
	
	@Test
	public void testSearchUserArrayListOfUserStringString() {
		ArrayList<User> users = new ArrayList<User>();
		
		User user = new User("adm", "adm@ic.ufal.br", "adm");
		users.add(user);
		
		User user1 = new User("ana", "a@gmail.com", "123");
		users.add(user1);
		
		User realized = searchUser(users, "bruno", "123");
		assertNull(realized);	
	}

	@Test
	public void testSearchUserArrayListOfUserString() {
		ArrayList<User> users = new ArrayList<User>();
		
		User user = new User("adm", "adm@ic.ufal", "adm");
		users.add(user);
		
		User user1 = new User("ana", "a@gmail.com", "123");
		users.add(user1);
		
		User expected = user;
		
		User realized = searchUser(users, "adm");
		assertNotNull(realized);
		assertEquals(realized, expected);
	}

}
