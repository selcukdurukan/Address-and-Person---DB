package com.ba.boost.controller;

import java.util.ArrayList;
import java.util.List;

import com.ba.boost.dao.IDatabaseCrud;
import com.ba.boost.model.Address;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;

public class AddressController implements IDatabaseCrud<Address> {

	@Override
	public void create(Address entity) {
		// Try with resoruces db connection'ı otomatik kapatır
		try (Session session = databaseConnection();) {

			session.getTransaction().begin();

			session.persist(entity);

			session.getTransaction().commit();
			System.out.println("Address data was ADDED to DB at this " + session);

		} catch (Exception e) {
			System.out.println("Some problem occured while ADDING address to DB");
		}
	}

	@Override
	public List<Address> retrive() {
		ArrayList<Address> addresses = null;

		try (Session session = databaseConnection();) {

			String hql = "SELECT a FROM Address AS a";
			TypedQuery<Address> typedQuery = session.createQuery(hql, Address.class);

			addresses = (ArrayList<Address>) typedQuery.getResultList();

			for (Address a : addresses) {
				System.out.println(a);
			}

		} catch (Exception e) {
			System.out.println("Some problem occured while RETRIVING all of addressess from DB.");
		}

		return addresses;
	}

	@Override
	public Address update(long id, Address entity) {
		Address updateAddress = find(id);
		try (Session session = databaseConnection()) {
			updateAddress.setStreet(entity.getStreet());
			updateAddress.setDoorNumber(entity.getDoorNumber());
			updateAddress.setCity(entity.getCity());

			session.getTransaction().begin();

			session.merge(updateAddress);

			session.getTransaction().commit();
			System.out.println("Address data was UPDATED to DB at this " + session);

		} catch (Exception e) {
			System.out.println("Some problem occured while UPDATİNG address to DB");
		}
		return updateAddress;
	}

	@Override
	public Address delete(long id) {
		Address deleteAddress = find(id);
		try (Session session = databaseConnection();) {
			if (deleteAddress != null) {
				session.getTransaction().begin();

				session.remove(deleteAddress);

				session.getTransaction().commit();
				System.out.println("Address whose " + id + " was deleted.");
			}

		} catch (Exception e) {
			System.out.println("Some problem occured while DELETING address from DB");
		}
		return deleteAddress;

	}

	@Override
	public Address find(long id) {
		Address address = null;
		// try with resources closed automatically.
		try (Session session = databaseConnection();) {

			address = session.find(Address.class, id);
			if (address != null) {
				System.out.println(address);
			} else {
				System.out.println("Address cannot FOUND.");
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while FINDING address");
		}
		return address;
	}
	/*
	 * Some hql with address class
	 */
	
	public void countAddress() {
		try (Session session = databaseConnection()){
			String hql = "SELECT COUNT(adr) FROM Address AS adr";
			TypedQuery<Long> typedQuery = session.createQuery(hql, Long.class);
			long addressCount = typedQuery.getSingleResult();
			System.out.println("Total address number: " + addressCount);
		} catch (Exception e) {
			System.out.println("Some problem occured while COUNTING address.");
		}
	}
	
	public void avgDoorNumber() {
		try (Session session = databaseConnection()){
			/*
			 * SUM
			 * AVG
			 * COUNT
			 * MIN
			 * MAX
			 */
			String hql = "SELECT AVG(adr.doorNumber) FROM Address AS adr";
			TypedQuery<Double> typedQuery = session.createQuery(hql, Double.class);
			Double avgDoorNumber = typedQuery.getSingleResult();
			System.out.println("Addresses' id avg number: " + avgDoorNumber);
		} catch (Exception e) {
			System.out.println("Some problem occured while calculating AVG address' id.");
		}
	}
	
	public void distinctDoorNumber() {
		try (Session session = databaseConnection()){
			String hql = "SELECT DISTINCT(adr.doorNumber) FROM Address AS adr";
			TypedQuery<Integer> typedQuery = session.createQuery(hql, Integer.class);
			ArrayList<Integer> distinctDoorNumber = (ArrayList<Integer>) typedQuery.getResultList();
			for (int i = 0; i < distinctDoorNumber.size(); i++) {
				System.out.println((i+1) +". Door Number: " +  distinctDoorNumber.get(i));
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while DISTINCTING address.");
		}
	}
	
	public void filterDoorNumber(int input) {
		try (Session session = databaseConnection();) {
			String hql = "SELECT adr FROM Address AS adr WHERE doorNumber <=:key";
			TypedQuery<Address> typedQuery= session.createQuery(hql, Address.class);
			typedQuery.setParameter("key", input);
			ArrayList <Address> filterAddresses = (ArrayList<Address>) typedQuery.getResultList();
			for (Address a : filterAddresses) {
				System.out.println(a);
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while FILTER address.");
		}
	}
	
	public void betweenMethod(int a, int b) {
		try (Session session = databaseConnection();) {
			String hql = "SELECT adr FROM Address AS adr WHERE adr.doorNumber BETWEEN :key1 AND :key2";
			TypedQuery<Address> typedQuery= session.createQuery(hql, Address.class);
			typedQuery.setParameter("key1", a);
			typedQuery.setParameter("key2", b);
			
			System.out.println(typedQuery.getResultList());
		} catch (Exception e) {
			System.out.println("Some problem occured while FILTER address.");
		}
	}
	
	public void orderAddressByDoorNumber() {
		try (Session session = databaseConnection();) {
			String hql = "SELECT adr FROM Address AS adr ORDER BY adr.doorNumber ASC";
			TypedQuery<Address> typedQuery= session.createQuery(hql, Address.class);

			ArrayList <Address> orderAddresses = (ArrayList<Address>) typedQuery.getResultList();
			for (Address a : orderAddresses) {
				System.out.println(a);
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while ORDERED address.");
		}
	}
}
