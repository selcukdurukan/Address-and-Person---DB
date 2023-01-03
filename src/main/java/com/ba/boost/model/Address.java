package com.ba.boost.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "people")


@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "street", nullable = false)
	private String street;
	@Column(name = "door_number", nullable = false)
	private int doorNumber;
	@Column(name = "city", nullable = false)
	private String city;

	@OneToMany(mappedBy = "address")
	private List<Person> people;


	
	

	

	
	
	

}
