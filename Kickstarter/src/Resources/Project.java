package Resources;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Models.User;
//ajeitar data da descrição
public class Project {
	private int id;
	private String name;
	public Category category;
	private Donation donation;
	private User author;
	private String description;
	private String moreInfo;
	private ArrayList<Comment> comments = new ArrayList<Comment>();
	private ArrayList<User> collaborators = new ArrayList<User>();
	
	private Scanner input = new Scanner(System.in);

	public Project(User author, String name, Category category, Donation donation, String description){
		this.author = author;
		this.name = name;
		this.category = category;
		this.donation = donation;
		this.setDescription(description);
		this.moreInfo = "no more information";
	}

	public Project() {
		this.author = new User();
		this.moreInfo = "no more information";
	}

	@SuppressWarnings("deprecation")
	public void listProjects(ArrayList<Project> projects, User user) {
		
		if(projects.size() > 0) {
			System.out.println("Type project number ");
			int j = 0;
			for(Project i: projects){
				System.out.println("Project " + j);
				i.setId(j);
				System.out.println("Name: " + i.getName());
				System.out.println("Category: " + i.getCategory());
				System.out.println("Total donation: " + i.donation.getTotal());
				
				int ano = i.getDonation().getFinalDate().getYear();
				ano = ano%100 + 2000; 
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("Final date: ");
				stringBuilder.append(i.donation.getFinalDate().getDate());
				stringBuilder.append("/");
				stringBuilder.append(i.getDonation().getFinalDate().getMonth());
				stringBuilder.append("/");
				stringBuilder.append(ano);
				System.out.println(stringBuilder.toString());
				j++;
			}
			try{
				System.out.println("Enter: ");
				int enter = input.nextInt();
				
				if(enter < projects.size()){
					System.out.println("Project: " + projects.get(enter).getName());
					System.out.println("Author: " + projects.get(enter).getAuthor().getName());
					System.out.println(" ");
					option(enter, projects, user);
				}
				
			}catch(InputMismatchException e){
				System.out.println("Invalid input.");
			}	
			
		}else {
			System.out.println("No projects.");
		}
	}

	private void option(int i, ArrayList<Project> projects, User user ) {
		
		System.out.println("Enter ");
		System.out.println("1 - Description");
		System.out.println("2 - FAQ");
		System.out.println("3 - Comment");
		System.out.println("4 - Community");
		System.out.println("5 - Donate");
		try{
			int enter = input.nextInt();
			Comment comment = new Comment();
			
			switch(enter){
				case 1:
					showDescription(i, projects);
					break;
				case 2:
					comment.setFAQ(user);
					comments.add(comment);
					break;
				case 3:
					comment.listComment(comments);
					break;
				case 4:
					projects.get(i).getDonation().Community(projects, i);
					break;
				case 5:
					projects.get(i).getDonation().donate(projects, i);
					break;
				default:
					System.out.println("Error! Only numbers between 1 and 5.");
			}
			
		}catch(InputMismatchException e){
			System.out.println("Invalid input.");
		}	
	}

	private void showDescription(int i, ArrayList<Project> projects) {
		System.out.println("Description ");
		System.out.println("Author: " + projects.get(i).getAuthor().getName());
		System.out.println("Total donors: " + projects.get(i).getDonation().getGivers().size());
		System.out.println("Total donation: " + projects.get(i).getDonation().getTotal());
		Donation d = projects.get(i).getDonation();
		if(d.getValue().size() > 0) {
			System.out.println("Donation values: " );
			
			for(int j =0; j < d.getValue().size(); j++) {
				System.out.print(d.getValue().get(j) + " ");
			}
		}
		System.out.println("Final date: " + d.getFinalDate());
		System.out.println("Information: " + projects.get(i).getDescription());
		System.out.println("More: " + projects.get(i).getMoreInfo());
	}
	
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Donation getDonation() {
		return this.donation;
	}
	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public void insertProject(ArrayList<Project> projects, ArrayList<User> users) {
		System.out.println("--Insert project--");
		insertCategory();

		System.out.println("Name: ");
		this.name = input.nextLine();
		System.out.println("Description: ");
		this.setDescription(input.nextLine());

		this.author.setCity();
		this.author.setProjectsSupported(this.author.getProjectsSupported()+1);
		
		this.author.setAge();
		this.author.setCreditCard();

		System.out.println("Want to add information? Enter 1(yes) or 0(no)");
		try{
			int enter = input.nextInt();
			if(enter == 1){
				System.out.println("More information: ");
				this.setMoreInfo(input.nextLine());
			}
			
			System.out.println("Want to add collaborator? Enter 1(yes) or 0(no)");
			try{
				enter = input.nextInt();
				if(enter == 1) {
					System.out.println("Name: ");
					String name = input.nextLine();
					User temp = new User();
					temp = temp.searchUser(users, name);
					if(temp != null) {
						this.collaborators.add(temp);
					}else {
						System.out.println("Error! User does not exist.");
					}
				}
				this.donation = new Donation();
				
			}catch(InputMismatchException e){
				System.out.println("Invalid input.");
			}	
				
		}catch(InputMismatchException e){
			System.out.println("Invalid input.");
		}	
		System.out.println("----");
	}

	private void insertCategory() {
		System.out.println("--Category--");
		System.out.println("Enter ");
		System.out.println("1 - ARTS");
		System.out.println("2 - COMICS ILLUSTRATION");
		System.out.println("3 - DESIGN TECH");
		System.out.println("4 - FILM");
		System.out.println("5 - FOOD CRAFT");
		System.out.println("6 - GAMES");
		System.out.println("7 - MUSIC");
		System.out.println("8 - PUBLISHING");
		try{
			int enter = input.nextInt();
			input.nextLine();
			switch(enter){
				case 1:
					this.category = Category.ARTS;
					break;
				case 2:
					this.category = Category.COMICS_ILLUSTRATION;
					break;
				case 3:
					this.category = Category.DESIGN_TECH;
					break;
				case 4:
					this.category = Category.FILM;
					break;
				case 5:
					this.category = Category.FOOD_CRAFT;
					break;
				case 6:
					this.category = Category.GAMES;
					break;
				case 7:
					this.category = Category.MUSIC;
					break;
				case 8:
					this.category = Category.PUBLISHING;
					break;
				default:
					System.out.println("Error! Only numbers between 1 and 8.");
			}
		}catch(InputMismatchException e){
			System.out.println("Invalid input.");
		}
		System.out.println("----");
	}

	public void removeProject(ArrayList<Project> projects, User user) {
		System.out.println("-- Remove --");
		
		if(projects.size() > 0) {
			System.out.println("Enter your password: ");
			String password = input.nextLine();
			
			if(user.getPassword().equals(password)){
				
				System.out.println("Choose a project that you are author: ");
				for(int p = 0; p < projects.size(); p++) {
					System.out.println(p + " - " + projects.get(p).getName() + " Author: " + projects.get(p).getAuthor().getName());
				}
				int enter = input.nextInt();
				
				if(enter < projects.size()) {
					
					if(projects.get(enter).getAuthor().getPassword().equals(password)) {
						projects.remove(enter);
						System.out.println("Project successfully removed!");
					}else {
						System.out.println("Error! Wrong password. ");
					}
				}
				else {
					System.out.println("Error! Only numbers between 0 and " + projects.size() + ".");
				}
			}
		
		}else {
			System.out.println("No projects.");
		}
		System.out.println("----");
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMoreInfo() {
		return this.moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
}
