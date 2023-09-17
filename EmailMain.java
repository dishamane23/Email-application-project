package mypack;

import java.util.Scanner;

public class EmailMain {

	public static void main(String[] args) {
		Scanner s=new Scanner (System.in);
		System.out.println("Enter First Name:");
		String firstname=s.next();
		System.out.println("Enter Last Name:");
		String lastname=s.next();
		Email em=new Email(firstname,lastname);
		int ch=-1;
		do {
			System.out.println("Enter a Choice\n1.show info\n2.change password\n3.change mailbox capacity\n4.set alternate email\n5.Exit");
			ch=s.nextInt();
			switch(ch) {
			case 1:
				em.getinfo();
				break;
				
			case 2:
				em.set_password();
				break;
			case 3:
				em.set_mailboxcapacity();
				break;
			case 4:
				em.alternate_email();
				break;
			case 5:
				System.out.println("Thank you for using applicatin");
			default:
				System.out.println("Invalid choice enter again");
			
			}
		}while(ch!=5);
		

	}

}