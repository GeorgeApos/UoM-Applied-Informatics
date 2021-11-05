
public class Course {

	private String name;
	private int ects;
	
//	// ������� ��� ������� �� ���� �������
//	private Student enrolledStudent;
	
	// ��� ������� �������� ��� �������������, ������ �� ������ ���� ������
	private Student[] enrolledStudents = new Student[100];
	
	private int numberOfStudents;
	
	public Course(String aName, int aNumber){
		name = aName;
		ects = aNumber;
		// � ������������ ���� ��� ���� ���� ������ ���
		numberOfStudents=0;
	}
	
	// ������� set
	public void enrollStudent(Student s){
//		// ��� ���� �������
//		enrolledStudent = s;
		
		// ��� ������� ��������
		
		enrolledStudents[numberOfStudents] = s;
		numberOfStudents++;
	
	}
	
	public void printInfo(){
		System.out.println("Course Name: " + name);
		System.out.println("ECTS: " + ects);
		System.out.println("has the following students");
		// �������� ��� �������� ��� ������ �� ���� ��������
		for(int i=0; i<numberOfStudents; i++){
			System.out.println("student name: " + enrolledStudents[i].getName());
			
		}
		
//		// �������� �� ����� ��� �������
//		System.out.println("student name: " + enrolledStudent.getName());
		
	}
	
	public String getName(){
		return name;
	}
	
	public int getECTS(){
		return ects;
	}
	
	
	
}
