
public class Main {

	public static void main(String[] args){
		
		Student s1 = new Student("John", "ics20133");
		Student s2 = new Student("Mary", "iis19047");
		Student s3 = new Student("Babis", "iis20100");
		
		Course c1 = new Course("Java" , 5);
		Course c2 = new Course("Machine Learning" , 5);

		
//		// ���� ��� ���� ��� ������������ ��������� c1 ���� ������� s1
//		s1.setCourse(c1);
//
//		c1.printInfo();
		
		// ��� �� ��� ������������� ����, �� ��� ���� Student ��� �� ����������� ��� setCourse
//		// ���� ��� ���� ��� ������� s1 ���� ������� c1
//		c1.enrollStudent(s1);
		
//		s2.setCourse(c2);
//		
//		s1.printInfo();
//		// s2.printInfo();
		

		// ����� 3 �������� �� ��� ������
		c1.enrollStudent(s1);
		c1.enrollStudent(s2);
		c1.enrollStudent(s3);
		
		// �������� ����� ���� ��������
		c1.printInfo();
		
		
	}
}
