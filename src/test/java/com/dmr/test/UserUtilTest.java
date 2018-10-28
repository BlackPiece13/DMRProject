package com.dmr.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dmr.dao.PersonDAO;
import com.dmr.dao.UserDAO;
import com.dmr.model.Author;
import com.dmr.model.Person;
import com.dmr.model.User;

public class UserUtilTest {

	static PersonDAO personDAO;
	static UserDAO userDao;

	@BeforeClass
	public static void init() {
		personDAO = new PersonDAO();
		userDao = new UserDAO();
		personDAO.intialiazeSession();
		userDao.intialiazeSession();
	}

	@Test
	public void isAdded() {
		Person person = new Author();
		person.setFirstName("aouadene");
		person.setLastName("hamza");
		assertTrue(personDAO.save(person));
	}

	@Test
	public void isFound() {
		Person person = new User();
		personDAO.save(person);
		Person foundPerson = personDAO.findByID(person.getid());
		personDAO.remove(person);
		assertNotNull(foundPerson);
	}

	@Test
	public void isUpdated() {
		Person person = new User();
		person.setFirstName("mahler");
		personDAO.save(person);
		person.setFirstName("modifiedFirstName");
		personDAO.update(person);
		Person foundPerson = personDAO.findByID(person.getid());

		assertTrue(foundPerson.getFirstName().equals("modifiedFirstName"));
	}

	@Test
	public void isDeleted() {
		List<Person> listPersons = personDAO.findAll();
		Person person = personDAO.findByID(listPersons.get(0).getid());
		assertNotNull(person);
		personDAO.remove(person);
		assertNull(personDAO.findByID(person.getid()));
	}

	@Test
	public void isFoundAll() {
		List<Person> listPersons = personDAO.findAll();
		assertNotNull(listPersons);
	}

	@Test
	public void isFoundByMail() {
		User user = new User("login", "password", "admin", "mail");
		userDao.save(user);
		List<User> users = userDao.findByMail("mail");
		userDao.remove(user);
		assertTrue(!users.isEmpty());
	}

	@Test
	public void isFoundByName() {
		Person person = new User();
		person.setFirstName("firstName");
		person.setLastName("lastName");
		personDAO.save(person);
		List<Person> persons = personDAO.findByName(person.getFirstName(), person.getLastName());
		personDAO.remove(person);
		assertTrue(!persons.isEmpty());
	}

	@AfterClass
	public static void afterAll() {
		personDAO.closeSession();
		userDao.closeSession();
	}

}
