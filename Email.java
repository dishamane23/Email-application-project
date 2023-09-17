package mypack;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Email {
	Scanner in=new Scanner (System.in);
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private String candidateid;
	private int defaultpasswordlength=8;
	private int defaultcandidateidlength=6;
	private int mailboxcapacity=500;
	private String alternate_email;
	
	
	//Created the constructor to receive first name and last name
	public Email(String firstname,String lastname)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		System.out.println("New Employee:"+this.firstname+" "+this.lastname);
		//next call method to ask the Department and then return the department
		this.department=this.setDepartment();
		
		this.candidateid=setcandidateid(defaultcandidateidlength);
		System.out.println("your candidate id:"+this.candidateid);

		//call a method and then return default password
		this.password=this.randompassword(defaultpasswordlength);
		this.email=this.genertae_email();
	}
	//Generate Email 
	private String genertae_email()
	{
		return this.firstname.toLowerCase()+"."+this.lastname.toLowerCase()+"@"+this.department.toLowerCase()+"."+"capgemini.com";
	}
	//Generate random password
	private String randompassword(int length) {
		Random r=new Random();
		String capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String small_chars="abcdefghijklmnopqrstuvwxyz";
		String numbers="1234567890";
		String symbols="!@#$%^&*";
		String values=capital_chars+small_chars+numbers+symbols;
		String password="";
		for(int i=0;i<length;i++)
		{
			password=password+values.charAt(r.nextInt(values.length()));
		}
		return password;
	}
	public void set_password()
	{
		boolean flag=false;
		do {
			System.out.println("Do you wants to change the password!(Y/N)");
			char ch=in.next().charAt(0);
			if(ch=='Y'||ch=='y')
			{
				flag=true;
				System.out.println("Enter Current password");
				String temp =in.next();
				if(temp.equals(this.password)) {
					System.out.println("Enter new password");
					this.password=in.next();
					System.out.println("password changed successfully");
				}
				else {
					System.out.println("Incorrect password");
				}
			}else if(ch=='N'||ch=='n') {
				flag=true;
				System.out.println("password changed option cancelled");
			}
			else {
				System.out.println("Invalid code");
			}
		}while(!flag);
	}
	private String setcandidateid(int length) {
		String candidateidset="0123456789";
		char [] candidateid=new char[length];
		for(int i=0;i<length;i++)
		{
			int rand=(int)(Math.random()*candidateidset.length());
			candidateid[i]=candidateidset.charAt(rand);
		}
		return new String(candidateid);
	}
	public void set_mailboxcapacity() {
		System.out.println("Current Capacity="+this.mailboxcapacity+"mb");
		System.out.println("Enter new Capacity:");
		this.mailboxcapacity=in.nextInt();
		System.out.println("Mail box Capacity is Successfully Changed");
	}
	public void alternate_email() {
		System.out.println("Enter new email:");
		this.alternate_email=in.next();
		System.out.println("New mail is created");
	}
	//Ask for the Department
	private String setDepartment() {
		System.out.println("*WELCOME TO EMAIL APPLICATION*");
		System.out.println("Choice Department Codes:\n1.for Sales\n2.for Development\n3.for Accounting\n4.for HR Recruiter");
		boolean flag=false;
		do {
			System.out.println("Enter your Department Code:");
		int ch=in.nextInt();
		switch(ch)
		{
		case 1:
			return "sales";
		case 2:
			return "development";
		case 3:
			return "accounting";
		case 4:
			return "hrrecruiter";
		case 0:
			return "";
		default:
			System.out.println("Invalid Choice please choice it again!!");
		}
	}while(!flag);
		return null;
		
}
	public void getinfo() {
		System.out.println("New:"+this.firstname+" "+this.lastname);
		System.out.println("Department:"+this.department);
		System.out.println("Email:"+this.email);
		System.out.println("password:"+this.password);
		System.out.println("Mailbox Capacity:"+this.mailboxcapacity);
		System.out.println("Alternate Email:"+this.alternate_email);
		
	}
}