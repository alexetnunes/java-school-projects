/*
* Student Class
* Alex Nunes
* 07/10/2014
* Dalhousie University
* Faculty of Computer Science
*
* A Student Object that consists of a name and an
* ID with an overridden toString and equals method
*/
public class Student {

	//Variables
	private String name;
	private int id;

	//Constructors
	public Student(){

	}

	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	//toString
	@Override
	public String toString() {
		return  name + ", ID " + id ;
	}

	//Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
