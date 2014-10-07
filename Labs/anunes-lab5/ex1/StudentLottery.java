/*
* Student Class
* Alex Nunes
* 07/10/2014
* Dalhousie University
* Faculty of Computer Science
*
* A StudentLottery that consists of an ArrayList
* of Student Objects
*/
import java.util.*;
public class StudentLottery {

	//Variable
	private ArrayList<Student> students;

	//Constructors
	public StudentLottery() {
		this.students = new ArrayList<Student>();
	}

	/* A function that allows a user to add as many students
	 * as they want. No students maybe identical. Ends when user
	 * types 'n'.
	 */
	public void addStudents(){
		Scanner kbd = new Scanner(System.in);
		char enter='y';

		while(enter != 'n'){
			System.out.print("Enter? (y or n): ");
			enter = kbd.next().charAt(0);

			if(enter == 'y'){
				String name;
				int id;
				Student student;

				System.out.print("Name: ");
				kbd.nextLine();
				name = kbd.nextLine();

				System.out.print("ID: ");
				id = kbd.nextInt();

				student = new Student(name, id);

				if(students.contains(student)){
					System.out.println("Sorry. You cannot enter twice!");
				} else {
					students.add(student);
				}
			}else if(enter == 'n'){
				System.out.println("Thank you.\n");
			}else{
				System.out.println("Invalid command.");
			}
		}
	}

	//Randomly selects a Student from the array
	public void pickWinner(){
		Random random= new Random();
		System.out.println("And the winner is: " + students.get(random.nextInt(students.size())));
	}
}
