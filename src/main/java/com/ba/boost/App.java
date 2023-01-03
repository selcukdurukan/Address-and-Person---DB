package com.ba.boost;

import com.ba.boost.controller.AddressController;
import com.ba.boost.controller.PersonController;
import com.ba.boost.model.Address;
import com.ba.boost.model.Person;

public class App {

	public static void main(String[] args) {
		
		AddressController ac = new AddressController();
		PersonController pc = new PersonController();
		
//		Address a1 = new Address();
//		a1.setStreet("Candan");	
//		a1.setDoorNumber(12);
//		a1.setCity("Nigde");
//		
//		Person p1 = new Person();
//		p1.setFirstName("Selcuk");
//		p1.setLastName("Durukan");
//		p1.setAddress(a1);
//		
//		Person p2 = new Person();
//		p2.setFirstName("Mehmet");
//		p2.setLastName("Durukan");
//		p2.setAddress(a1);
//		
//		Person p3 = new Person();
//		p3.setFirstName("Ayse");
//		p3.setLastName("Durukan");
//		p3.setAddress(a1);
//		
//		Address a2 = new Address();
//		a2.setStreet("Harzem");
//		a2.setDoorNumber(12);
//		a2.setCity("Istanbul");
//		
//		Person p4 = new Person();
//		p4.setFirstName("Tugba");
//		p4.setLastName("Erdogan");
//		p4.setAddress(a2);
//		
//		ac.create(a1);
//		ac.create(a2);
//		
//		pc.create(p1);
//		pc.create(p2);
//		pc.create(p3);
//		pc.create(p4);
		
//		Address updateAdr = new Address();
//		updateAdr.setStreet("Harzem");
//		updateAdr.setDoorNumber(12);
//		updateAdr.setCity("Ankara");
//		
//		ac.update(2, updateAdr);
		
//		ac.retrive();
		
//		pc.retrive();
		
//		Person updatePer = new Person();
//		updatePer.setFirstName("Tugba");
//		updatePer.setLastName("Durukan");
//		updatePer.setAddress(ac.find(2));
//		pc.update(4, updatePer);
//		pc.retrive();
		
//		pc.delete(5);
		

		
//		pc.delete(4);
		
//		Person updatePerson = new Person();
//		updatePerson.setFirstName("Tugba");
//		updatePerson.setLastName("Erdogan");
//		updatePerson.setAddress(ac.find(2));
//		
//		pc.update(3, updatePerson);
		
		
//		pc.retrive();	
//		ac.retrive();
		
//		Address newAdr = new Address();
//		newAdr.setDoorNumber(6);
//		newAdr.setCity("Istanbul");
//		newAdr.setStreet("Abdulhamit");
//		ac.create(newAdr);
		
//		pc.retrive();	
//		ac.retrive();
//		
//		ac.countAddress();
//		ac.avgDoorNumber();
//		ac.distinctDoorNumber();
		
//		ac.filterDoorNumber(8);
		
//		ac.betweenMethod(5, 13);
		
		ac.orderAddressByDoorNumber();
		



		
		


	}

}
