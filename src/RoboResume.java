import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoboResume {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String name;
        String email;
        List<String[]> education = new ArrayList<>();
        List<Object[]> work = new ArrayList<>();
        List<String[]> skills = new ArrayList<>();

        System.out.print("Please enter your name: ");
        do {
            name = in.nextLine();
            if (name.length() < 3 || name.length() > 20) {
                out("Please enter a name (3 to 20 char): ");
                name = null;
            }

        } while (name == null);

        out("Hello %s, please enter your email: ", name);
        do {
            email = in.nextLine();
            if(email.indexOf('@') == -1 || email.indexOf('.') == -1) {
                System.out.print("Please enter a valid email to continue: ");
                email = null;
            }
        } while (email == null);

        out("Ok %s, with email: %s, lets enter some education (leave all fields blank to move onto work experience):\n", name, email);

        for (int i = 0; i < 10; i++) {
            int SCHOOL = 0, DEGREE = 1;
            String temp[] = new String[2];

            out("Please enter a school: ");
            temp[SCHOOL] = in.nextLine();

            out("Please enter the degree you got at %s: ", temp[SCHOOL]);
            temp[DEGREE] = in.nextLine();

            if (temp[SCHOOL].equals("") && temp[DEGREE].equals("")) {
                if (education.isEmpty()) {
                    out("You must enter at least one educational achievement or you will look like a deadbeat...");
                } else i = 10;
            } else education.add(temp);
        }

        out("Alright %s, its time to enter some work experience (leave all fields blank to move onto skills):\n", name);


        for (int i = 0; i < 10; i++) {
            int COMPANY = 0, TITLE = 1, TASKS = 2;
            Object[] temp = { null, null, null };
            List<String> tempList = new ArrayList<>();
            out("Please enter the company: ");
            temp[COMPANY] = in.nextLine();

            out("Please enter your job title at %s: ", temp[COMPANY]);
            temp[TITLE] = in.nextLine();

            for (int x = 0; x < 10; x++) {
                String t;
                out("Task: ");
                t = in.nextLine();
                if (t.isEmpty()) x = 10;
                else tempList.add(t);
            }
            if (!tempList.isEmpty()) temp[TASKS] = tempList;

            if (temp[COMPANY].equals("") && temp[TITLE].equals("") && temp[TASKS] == null) i = 10;
            else work.add(temp);
        }

        out("Ok %s, you have added %d schools and %d jobs, time to add some skills: \n", name, education.size(), work.size());

        for (int i = 0; i < 20; i++) {
            int SKILL = 0, LEVEL = 1;
            String temp[] = new String[2];

            out("Skill: ");
            temp[SKILL] = in.nextLine();

            out("Proficiency at %s: ", temp[SKILL]);
            temp[LEVEL] = in.nextLine();

            if (temp[SKILL].equals("") && temp[LEVEL].equals("")) {
                if (skills.isEmpty()) {
                    out("You must enter at least one skill or they will think you can't do anything.");
                } else i = 20;
            } else skills.add(temp);

        }

        out("Alright thats it! Press enter to print your resume...");
        in.nextLine();
        in.close();
        
        out("\n============================================================");
        out("\n============================================================\n\n");


        out("%s\n%s\n\nEDUCATION:\n", name, email);

        for (String[] array : education) {
            int SCHOOL = 0, DEGREE = 1;
            out("\n%s,\n%s\n", array[SCHOOL], array[DEGREE]);
        }

        if (!work.isEmpty()) {
            int COMPANY = 0, TITLE = 1, TASKS = 2;
            out("\nWORK EXPERIENCE:\n");
            for (Object[] array : work) {
                out("\n%s,\n%s\n", array[TITLE], array[COMPANY]);
                if (array[TASKS] != null) {
                    for (String task : (List<String>)array[TASKS]) {
                        out("-%s\n", task);
                    }
                }
            }
        }

        out("\nSKILLS:\n\n");

        for (String[] array : skills) {
            int SKILL = 0, LEVEL = 1;
            out("-%s, proficiency: %s \n", array[SKILL], array[LEVEL]);
        }

        out("\n============================================================");
        out("\n============================================================\n");
	    
    }

    public static void out(String string, Object... variables) {
        System.out.printf(string, variables);
    }
	
}



/*

###IPO###

INPUT:
-a name
-an email
-up to 10 edu entries
-up to 10 work entries, at least 1
-up to 20 skills, at least 1

PROCESSES:
-get input
-save input in strings, lists
-print to screen

OUTPUT:
-Prompts for inputs
-displays all inputs at the end in a resume format





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
