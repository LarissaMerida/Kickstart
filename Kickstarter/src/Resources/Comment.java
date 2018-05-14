package Resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Models.User;

public class Comment {
	private User commentator;
	private String message;
	private User replyAuthor;
	private String reply;

	private Date dateCommentator;
	private Date dateReply;

	private Scanner input = new Scanner(System.in);
	
	public Comment(User commentator, String message, User replyAuthor) {
		this.commentator = commentator;
		this.message = message;
		this.replyAuthor = replyAuthor;
	}

	public Comment() {
	}

	public void setFAQ(User user) {
		System.out.println("FAQ");
		this.commentator = user;
		System.out.println("Enter your question: ");
		this.message = input.nextLine();
		this.reply = null;
		this.dateCommentator = new Date();
	}
	
	public User getCommentator() {
		return this.commentator;
	}
	public void setCommentator(User commentator) {
		this.commentator = commentator;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getReplyAuthor() {
		return this.replyAuthor;
	}
	public void setReplyAuthor(User replyAuthor) {
		this.replyAuthor = replyAuthor;
	}
	
	public Date getDateCommentator() {
		return this.dateCommentator;
	}

	public void setDateCommentator(Date dateCommentator) {
		this.dateCommentator = dateCommentator;
	}

	public Date getDateReply() {
		return this.dateReply;
	}

	public void setDateReply(Date atual) {
		this.dateReply = atual;
	}

	public String getReply() {
		return this.reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	public void listComment(ArrayList<Comment> comments) {
		System.out.println("-- Comments --");
		for(Comment i : comments) {
			System.out.println("Name: " + i.getCommentator().getName());
			System.out.println("Date commentator: " + i.getDateCommentator());
			System.out.println("Message: " + i.getMessage());
			System.out.println("Author: " + i.getReplyAuthor().getName());
			System.out.println("Date reply: " + i.getDateReply());
			
			if(i.getReply() == null) {
				System.out.println("You want to respond? Enter 1(yes) or 0(no)");
				try{
					int enter = input.nextInt();
					
					if(enter == 1) {
						System.out.println("Enter reply: ");
						i.setReply(input.nextLine());
						Date atual = new Date();
						i.setDateReply(atual);
					}
					
				}catch(InputMismatchException e){
					System.out.println("Invalid input.");
				}	
				
			}else {
				System.out.println("Reply: " + i.getReply());
			}
			System.out.println(" ");
		}
		System.out.println("-----");	
	}
}
