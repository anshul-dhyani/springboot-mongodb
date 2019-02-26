/**
 * 
 */
package com.anshul.springbootmongodb.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author anshul
 *
 */
@Document(collection = "person")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6532750572836066152L;
	@Id
	private String id;
	private String name;
	private int age;
	private Address address;
	private List<POI> pointsOfInterest;

	/**
	 * 
	 */
	public Person() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	/**
	 * @param name
	 * @param age
	 * @param address
	 * @param pointsOfInterest
	 */
	public Person(String name, int age, Address address, List<POI> pointsOfInterest) {
		this();
		this.name = name;
		this.age = age;
		this.address = address;
		this.pointsOfInterest = pointsOfInterest;
	}

	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param address
	 * @param pointsOfInterest
	 */
	public Person(String id, String name, int age, Address address, List<POI> pointsOfInterest) {
		this();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.pointsOfInterest = pointsOfInterest;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<POI> getPointsOfInterest() {
		return pointsOfInterest;
	}

	public void setPointsOfInterest(List<POI> pointsOfInterest) {
		this.pointsOfInterest = pointsOfInterest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", pointsOfInterest="
				+ pointsOfInterest + "]";
	}

}
