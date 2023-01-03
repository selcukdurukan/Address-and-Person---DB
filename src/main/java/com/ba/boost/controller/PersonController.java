package com.ba.boost.controller;

import java.util.ArrayList;
import java.util.List;

import com.ba.boost.dao.IDatabaseCrud;
import com.ba.boost.model.Person;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;

public class PersonController implements IDatabaseCrud<Person> {

	@Override
	public void create(Person entity) {
		try (Session session = databaseConnection();) {
			session.getTransaction().begin();

			session.persist(entity);

			session.getTransaction().commit();
			System.out.println("Person data was ADDED to DB at this " + session);

		} catch (Exception e) {
			System.out.println("Some problem occured while ADDING person to DB");
		}

	}

	@Override
	public List<Person> retrive() {
		ArrayList<Person> persons = null;
		try (Session session = databaseConnection();) {

			String hql = "SELECT p FROM Person As p";

			TypedQuery<Person> typedQuery = session.createQuery(hql, Person.class);
			persons = (ArrayList<Person>) typedQuery.getResultList();

			for (Person p : persons) {
				System.out.println(p);
			}

		} catch (Exception e) {
			System.out.println("Some problem occured while RETRIVING all of persons from DB.");
		}
		return persons;
	}

	@Override
	public Person update(long id, Person entity) {
		Person updatePerson = find(id);

		try (Session session = databaseConnection();) {
			updatePerson.setFirstName(entity.getFirstName());
			updatePerson.setLastName(entity.getLastName());
			updatePerson.setAddress(entity.getAddress());

			session.getTransaction().begin();
			session.merge(updatePerson);
			session.getTransaction().commit();
			System.out.println("Person data was UPDATED to DB at this " + session);
		} catch (Exception e) {
			System.out.println("Some problem occured while UPDATİNG person to DB");
		}
		return updatePerson;

	}

	@Override
	public Person delete(long id) {
		Person deletePerson = find(id);
		try (Session session = databaseConnection();) {
			if (deletePerson != null) {
				session.getTransaction().begin();
				session.remove(deletePerson);
				session.getTransaction().commit();

				System.out.println("Person whose " + id + " was deleted.");

			}
		} catch (Exception e) {
			System.out.println("Some problem occured while DELETING person from DB");
		}
		return deletePerson;

	}

	@Override
	public Person find(long id) {
		Person person = null;
		try (Session session = databaseConnection();) {
			person = session.find(Person.class, id);
			if (person != null) {
				System.out.println(person);
			} else {
				System.out.println("Person cannot FOUND.");
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while FINDING person.");
		}

		return person;
	}

}
