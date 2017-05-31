import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoboResume {

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String name = null;
		String email = null;
		List<String> education = new ArrayList<String>();
		List<String> work = new ArrayList<String>();
		List<String> skills = new ArrayList<String>();
		
		System.out.print("Please enter your name: ");
		do {
			
			name = scan.nextLine();
			if (name.length() < 3 || name.length() > 12) {
				
				System.out.print("Please enter a name (3 to 12 char): ");
				name = null;
			}
			
		} while (name == null);
		
		System.out.printf("Hello %s, please enter your email: ", name);
		
		do {
			
			email = scan.nextLine();
			if(email.indexOf('@') == -1 || email.indexOf('.') == -1) {
				
				System.out.print("Please enter a valid email to continue: ");
				email = null;
			}
			
		} while (email == null);
		
		System.out.printf("Ok %s, with email: %s, lets enter some education (enter a blank line to move onto work history):\n", name, email);
		
		for (int i = 0; i < 10; i++) {
			String temp = scan.nextLine();
			if (temp.equals("")) {
				if (education.isEmpty()) {
					System.out.println("You must enter at least one education field: ");
					i = 0;
				} else {
					i = 10;
				}
			} else {
				education.add(temp);
			}
		}
		
		System.out.println("you have entered: ");
		for (String edu : education) {
			System.out.println(edu);
		}
		System.out.println("Now enter your work history(blank line to move on to skills): ");
		
		for (int i = 0; i < 10; i++) {
			String temp = scan.nextLine();
			if (temp.equals("")) {
				i = 10;
			} else {
				work.add(temp);
			}
		}
		
		System.out.println("you have entered: ");
		for (String w : work) {
			System.out.println(w);
		}
		
		System.out.println("Now you may enter your skills (again, blank line to move on): ");
		
		for (int i = 0; i < 20; i++){
			String temp = scan.nextLine();
			if (temp.equals("")) {
				if (skills.isEmpty()) {
					System.out.println("You must enter at least one skill: ");
					i = 0;
				} else {
					i = 20;
				}
			} else {
				skills.add(temp);
			}
		}
		
		System.out.println("you have entered: ");
		for (String skill : skills) {
			System.out.println(skill);
		}
		
		System.out.println("Press return to print out resume.");
		scan.nextLine();
		System.out.println("=============================================================");
		System.out.println(name);
		System.out.printf("%s \n\n", email);
		System.out.println("EDUCATION:");
		for (String edu : education) {
			System.out.printf("%s \n\n", edu);
		}
		if (!work.isEmpty()){
			System.out.println("WORK:");
			for (String w : work) {
				System.out.printf("%s \n\n", w);
			}
		}
		System.out.println("SKILLS:");
		for (String skill : skills) {
			System.out.println(skill);
		}
		System.out.println("=============================================================");
		
		scan.close();
	}
	
}



/*

Robo Resume Assignment
   
Write a program that will allow a user to enter in:
- a name, 
- an email address, 
- anywhere from 1 to 10 educational achievements,
- anywhere from 0 to 10 work experiences,
- anywhere from 1 to 20 skills with rating

When the user is done entering the information, the program should output the information
to look something like the following:

=============================================================
John J Jingleheimer-Schmidt
jjjschmidt@gmail.com

Education
BS in Psychology,
UMaryland, 2002

MS in Software Engineering,
Johns Hopkins U, 2005

Experience
Software Developer II
Amtrak, June 2015 - Present
- Duty 1, Lorem ipsum
- Duty 2, Gaudeamos Igitur Iuvenes Dum Somos

Software Developer I
Amtrak, June 2014 - June 2015
- Duty 1, Lorem ipsum
- Duty 2, Gaudeamos Igitur Iuvenes Dum Somos

Business Analyst
DCPS, August 2005 - May 2014
- Duty 1, Lorem ipsum
- Duty 2, Gaudeamos Igitur Iuvenes Dum Somos

Skills
PHP, highly skilled
Ruby on Rails, proficient
Perl, familiar

*/