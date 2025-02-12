class Student{
	int rollNumber;
	String name;
	int age;
	char grade;
	Student next;
	
	public Student(int rollNumber,String name,int age,char grade){
		this.rollNumber = rollNumber;
		this.name  = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
}
class StudentLinkedList{
	private Student head;

	public void addAtBeginning(int rollNumber,String name,int age,char grade){
		Student newStudent = new Student(rollNumber,name,age,grade);
		newStudent.next = head;
		head = newStudent;
	}
	public void addAtEnd(int rollNumber,String name,int age,char grade){
		Student newStudent = new Student(rollNumber,name,age,grade);
		if(head == null){
			head = newStudent;
			return ;
		}
		Student temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = newStudent;
	}
	public void addAtPosition(int position,int rollNumber,String name,int age,char grade){
		if(position < 1) {
		return;}
		if(position == 1){
			addAtBeginning(rollNumber,name,age,grade);
			return;
		}	
		Student newStudent = new Student(rollNumber,name,age,grade);
		Student temp = head;
		for(int i=1;temp != null && i < position;i++){
			temp = temp.next;
		}
		if(temp == null)return;
		newStudent.next = temp.next;
		temp.next = newStudent;	
	}
	public void deleteByRollNumber(int rollNumber){
		if(head == null){
			return;
		}
		if(head.rollNumber == rollNumber){
			head = head.next;
			return ;
			
		}
		Student temp = head , prev = null;
		while(temp != null && temp.rollNumber != rollNumber){
			prev = temp;
			temp = temp.next;
		}
		if(temp == null)return;
		prev.next = temp.next;
	} 
	public Student  searchByRollNumber(int rollNumber){
		Student temp = head;
		while(temp != null){
			if(temp.rollNumber == rollNumber){return temp;}
			temp = temp.next;
		}
		return null;
	}
	public void updateGrade(int rollNumber,char newGrade){
		Student student = searchByRollNumber(rollNumber);
		if(student != null){student.grade = newGrade;}
	}
	public void displayStudents(){
		if(head == null){
			System.out.println("No students in the list");
			return ;
		}
		Student temp = head;
		while(temp != null){
			System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
		temp = temp.next;
		}
	}
}
public class Main{
	public static void main(String args[]){
		StudentLinkedList list = new StudentLinkedList();
		list.addAtEnd(101, "Samiksha", 20, 'A');
                list.addAtEnd(102, "Saniya", 21, 'B');
       	        list.addAtBeginning(103, "Nomicy", 22, 'C');
       	        list.addAtPosition(2, 104, "Sanjana", 19, 'A');

		System.out.println("Student Records : ");
		list.displayStudents();

	        System.out.println("\nSearching for Roll Number 102:");
        	Student found = list.searchByRollNumber(102);
       	        if (found != null) {
           	   System.out.println("Student Found: " + found.name);
       	        } else {
                   System.out.println("Student not found.");
                }

                System.out.println("\nUpdating grade of Roll Number 101 to 'B'");
       	        list.updateGrade(101, 'B');
       	        list.displayStudents();
    
                System.out.println("\nDeleting student with Roll Number 103");
                list.deleteByRollNumber(103);
                list.displayStudents();

	}
}
