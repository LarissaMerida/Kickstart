package Models;

import java.util.Scanner;

public class Person {
	protected String name;
	protected String email;
	protected String password;
	protected int age;
	protected String city;
	protected String creditCard;
	protected int projectsSupported;
	
	protected Scanner input = new Scanner(System.in);

	public Person(String name, String email, String password){
		this.name = name;
		this.email = email;
		this.password = password;
		this.projectsSupported = 0;
	}

	public Person() {
		
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCreditCard() {
		return this.creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	public int getProjectsSupported() {
		return this.projectsSupported;
	}
	public void setProjectsSupported(int projectsSupported) {
		this.projectsSupported = projectsSupported;
	}
}
