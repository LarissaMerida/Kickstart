package Models;
//ao errar idade, da erro, mas continua
import java.util.ArrayList;
import java.util.InputMismatchException;

public class User extends Person{

	public User(String name, String email, String password) {
		super(name, email, password);
		this.city = "Nao informada.";
		this.creditCard = "Nao informado.";
	}

	public User() {
		super();
	}

	public void setName(){
		System.out.println("Name:");
		this.name = input.nextLine();
	}

	public void setEmail(){
		System.out.println("Email: ");
		this.email = input.nextLine();
	}

	public void setPassword(){
		System.out.println("Password: ");
		this.password = input.nextLine();
	}
	
	public void setAge() {
		System.out.println("Age: ");
		try{
			this.age = input.nextInt();
			input.nextLine();
			
		}catch(InputMismatchException e){
			System.out.println("Invalid input.");
			input.nextLine();
		}	
	}
	public void setCity() {
		System.out.println("City:");
		this.city = input.nextLine();
	}
	
	public void setCreditCard() {
		System.out.println("Credit card:");
		this.creditCard = input.nextLine();
	}
	public User searchUser(ArrayList<User> users, String name, String password) {
		for(User i: users){
			if(i.getName().equals(name) && i.getPassword().equals(password)){
				return i;
			}
		}
		return null;
	}

	public User searchUser(ArrayList<User> users, String name) {
		for(User i: users){
			if(i.getName().equals(name)){
				return i;
			}
		}
		return null;	
	}

	public void editProfile(User user) {
		System.out.println("-- Edit profile --");
		System.out.println("Enter");
		System.out.println("1 - Name");
		System.out.println("2 - Email");
		System.out.println("3 - Password");
		System.out.println("4 - Age");
		System.out.println("5 - City");
		System.out.println("6 - Credit card");
		try{
			int enter = input.nextInt();
			input.nextLine();
			
			switch(enter) {
				case 1:
					user.setName();
					break;
				case 2:
					user.setEmail();
					break;
				case 3:
					user.setPassword();
					break;
				case 4:
					user.setAge();
					break;
				case 5:
					user.setCity();
					break;
				case 6:
					user.setCreditCard();
					break;
				default:
					System.out.println("Error! Only numbers between 1 and 6.");
			}
		}catch(InputMismatchException e){
			System.out.println("Invalid input.");
		}		
	}

	public void showProfile(User user) {
		System.out.println("--My profile--");
		System.out.println("Name: " + user.getName());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Password: " + user.getPassword());
		System.out.println("City: " + user.getCity());
		System.out.println("Age: " + user.getAge());
		System.out.println("Total of projects supported: " + user.getProjectsSupported());
		System.out.println("Credit card: " + user.getCreditCard());
		System.out.println("----");
	}
}
