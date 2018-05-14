package Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Models.Person;
import Models.User;
import Resources.Project;

public class Main {
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Project> projects = new ArrayList<Project>();
	public static Scanner input = new Scanner(System.in);
	private static User user;
	private static Project project;

	public static void main(String[] args) {
		cadastrado();
		menu();
		System.out.println("--Program closed--");
	}

	private static void menu() {
		System.out.println("--Welcome!--");
		User user = new User();

		try{
			System.out.println("Enter ");
			System.out.println("1 - Login");
			System.out.println("2 - Register");
			int enter = input.nextInt();

			switch(enter){
				case 1:
					user = login();
					break;
				case 2:
					user  = register();
					break;
				default:
					System.out.println("Error! Only numbers 1 or 2.");
					menu();
			}

		}catch(InputMismatchException e){
			System.out.println("Invalid input.");
		}

		if(user != null){
			option(user);
		}
	}

	private static void option(User user) {
		System.out.println("Ola, " + user.getName());
		System.out.println("Total projects: " + projects.size());
		System.out.print("Total funds raised: " );
		int total = 0;
		for(int i =0 ; i < projects.size(); i++) {
			total += projects.get(i).getDonation().getTotal();
		}
		System.out.println(total);
		
		try{
			String in = "1";
			while(in.equals("1")) {
				project = new Project();
				System.out.println("Enter ");
				System.out.println("1 - Show projects");
				System.out.println("2 - Insert project");
				System.out.println("3 - Remove my project");
				System.out.println("4 - Edit profile ");
				System.out.println("5 - Show my profile");
				int enter = input.nextInt();
				input.nextLine();
				
				switch(enter){
				case 1:
					project.listProjects(projects, user);
					break;
				case 2:
					project.insertProject(projects, users);
					projects.add(project);
					break;
				case 3:
					project.removeProject(projects, user);
					break;
				case 4:
					user.editProfile(user);
					break;
				case 5:
					user.showProfile(user);
					break;
				default:
					System.out.println("Error! Only numbers between 1 and 5.");
					option(user);
				}
				System.out.println("Do you wish to continue? Enter 1(yes) or 0(no)");
				in = input.nextLine();
			}
		
		}catch(InputMismatchException e){
			System.out.println("Invalid input.");
		}	
	}

	private static User login() {
		user = new User();
		String name, password;
		input.nextLine();
		System.out.println("Name:");
		name = input.nextLine();
		System.out.println("Password: ");
		password = input.nextLine();
		
	    user = user.searchUser(users, name, password);
		return user;
	}

	private static  User register() {
		user = new User();
		user.setName();
		user.setEmail();
		user.setPassword();
		users.add(user);
		return user;
	}

	private static void cadastrado() {
		Person adm = new User("adm", "adm@gmail.com", "adm");
		users.add((User) adm);
		Person person = new User("Ana", "ana@gmail.com", "123");
		users.add((User) person);

		Person person1 = new User("Davi", "davi@gmail.com", "Universe");
		users.add((User) person1);
	}

}
