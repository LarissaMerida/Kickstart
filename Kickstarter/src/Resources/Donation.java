package Resources;



import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Models.User;

public class Donation {
	private ArrayList<Float> values = new ArrayList<Float>(); 
	private String objective; 
	private Date finalDate; 
	private int donationPeriod;
	private ArrayList<User> givers = new ArrayList<User>();  
	private float total;   

	private Scanner input = new Scanner(System.in);
	
	@SuppressWarnings("deprecation")
	public Donation() {
		this.total = 0f;
		System.out.println("-- Donation --");
		System.out.println("Objective: ");
		this.objective = input.nextLine();
		System.out.println("Donation periodo(days) : Enter 30 or 60");
		try{
			int enter = input.nextInt();
			if(enter == 30 || enter == 60) {
				this.donationPeriod = enter;
				Date atual = new Date();
				atual.setDate(atual.getDate()+this.donationPeriod);
				finalDate = new Date();
				finalDate.setDate(atual.getDate());  
				finalDate.setMonth(atual.getMonth());
				finalDate.setYear(atual.getYear());
			}else {
				System.out.println("Error! Only period of 30 or 60 days.");
			}
			setValue();
			
		}catch(InputMismatchException e){
			System.out.println("Invalid input.");
		}	
	}
	
	public Donation(float total) {
		this.finalDate = new Date();
		this.total = total;
	}
	public ArrayList<Float> getValue() {
		return this.values;
	}
	public void setValue() {
		int i = 1;
		while(i != 0) {
			System.out.println("Enter the value: ");
			float value = input.nextFloat();
			
			this.values.add(value);
			System.out.println("Do you want to add another value? Enter 1(yes) or 0(no)");
			i = input.nextInt();
		}
	}

	public String getObjective() {
		return this.objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}

	public Date getFinalDate() {
		return this.finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public float getTotal() {
		return this.total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void Community(ArrayList<Project> projects, int i) {
		System.out.println("-- Community --");
		Donation donation = projects.get(i).getDonation();
		System.out.println("Number of supporters: " + donation.givers.size());
		System.out.println("Some supporters: ");
		for(User j: donation.getGivers()) {
			System.out.println("Name: " + j.getName());
			System.out.println("Total of projects supported: " + j.getProjectsSupported());	
		}
		System.out.println("----");
	}
	
	public ArrayList<User> getGivers() {
		return this.givers;
	}
	public void setGivers(ArrayList<User> givers) {
		this.givers = givers;
	}
	
	public void donate(ArrayList<Project> projects, int i) {
		System.out.println("-- Donate --");
		Donation donation = projects.get(i).getDonation();
		System.out.println("Enter ");
		for(int j = 1; j <  donation.getValue().size(); j++) {
			System.out.println(j + " - " + donation.getValue().get(j));
		}
		try{
			int enter = input.nextInt();
			
			if(enter < donation.getValue().size()) {
				donation.setTotal(donation.getTotal() + donation.getValue().get(enter-1));
				System.out.println("Congratulations! You contribute to this project.");
			}
			else {
				System.out.println("Error! Only numbers between 1 and " + donation.getValue().size() + ".");
			}
			
		}catch(InputMismatchException e){
			System.out.println("Invalid input.");
		}	
		
		System.out.println("----");
	}

}
