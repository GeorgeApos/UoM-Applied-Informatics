import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentFrame extends JFrame{

	//2ο βήμα GUI, Δημιουργία Panel
	private JPanel panel = new JPanel();
	
	//2ο βήμα GUI, Δημιουργία 4 γραφικών συστατικών
	private JTextField nameField = new JTextField("Enter name");
	private JTextField idField = new JTextField("Enter student id");
	private JTextField courseField = new JTextField("Enter course name");
	private JButton enrollButton = new JButton("Create and Enroll");
	
	//Φτιάχνω μια λίστα με μαθήματα
	private ArrayList<Course> courses = new ArrayList<>();
	
	public StudentFrame(){
		
		//Προσθέτω μαθήματα στην λίστα μου
		courses.add(new Course("Java"));
		courses.add(new Course("Databases"));
		courses.add(new Course("Python"));
		
		//3o βήμα GUI, προσθέτω τα συστατικά στο panel
		panel.add(nameField);
		panel.add(idField);
		panel.add(courseField);
		panel.add(enrollButton);
		
		//4ο βήμα GUI, προσθέτω το panel στο παράθυρο
		this.setContentPane(panel);
		
		//3. ButtonListener: Δημιουργώ ένα αντικείμενο ακροαρή για το πλήκτρο
		ButtonListener listener = new ButtonListener();
		
		//4. ButtonListener: Προσθέτω την σύνδεση του αντικειμένου με την πηγή των συμβάντων
		enrollButton.addActionListener(listener);
		
		//1ο βήμα GUI, Δημιουργία γραφικής διασύνδεσης (παράθυρο)
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Create and Enroll Student");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 1. ButtonListener: Φτιάχνω μια εσωτερική κλάση ακροατή για τα συμβάντα
	// Την ActionListener την παίρνω από την awt
	class ButtonListener implements ActionListener{
		

		//2. ButtonListener: Υλοποιώ την μέθοδο
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Διαβάζω το όνομα του φοιτητή και την ταυτότητά του
			String name = nameField.getText();
			String id = idField.getText();
			
			// Δημιουργώ φοιτητή
			Student newStudent = new Student(name, id);
			
			//Παίρνω και το μάθημα που εισήγαγε ο χρήστης
			String courseName = courseField.getText();
			
			// Καταχώρηση του φοιτητή στο μάθημα
			// Πρέπει να κάνω αρχικοποίηση του επιλεγμένου μαθήματος
			Course selectedCourse = null;
			// Διατρέχω τα μαθήματα
			for(Course course: courses)
				// Ελέγχω το επιλεγμένο μάθημα είναι 
				if(course.getName().equals(courseName))
					selectedCourse = course;
			
			//Καταχωρεί τον φοιτητή στο επιλεγμένο μάθημα
			selectedCourse.enrollStudent(newStudent);
			
			//Εκτύπωση φοιτητών
			selectedCourse.printCourceDetails();
		}
	
}
	
}
