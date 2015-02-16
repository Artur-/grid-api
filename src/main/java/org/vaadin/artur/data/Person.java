package org.vaadin.artur.whatsnewinvaadin74.data;

import java.math.BigDecimal;
import java.util.Random;

public class Person {

	private int id;
	private String firstName, lastName;
	private int age;
	private Gender gender;
	private BigDecimal salary;
	private Address address;
	private boolean busy;

	public Person(Random r) {
		id = idSequence++;
		firstName = Vaadiners.getFirstName(r);
		lastName = Vaadiners.getLastName(r);
		age = 10 + r.nextInt(100);
		gender = Gender.values()[r.nextInt(Gender.values().length)];
		salary = new BigDecimal(1000 + r.nextDouble() * 9000.0);
		address = new Address(r);
		busy = r.nextDouble() > 0.9;
	}

	/**
	 * @return the busy
	 */
	public boolean isBusy() {
		return busy;
	}

	/**
	 * @param busy
	 *            the busy to set
	 */
	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	private static int idSequence = 1;

}
