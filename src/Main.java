import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		StudentGroup sg = new StudentGroup(20);
		for(int i = 0 ; i < sg.getStudents().length; i++) {
			sg.setStudent(new Student(), i);
		}
		for(int i = 0 ; i < 20; i++) {
			System.out.println(sg.getStudent(i));
		}
		
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd.MM.yyyy");
		
		Student newSt1 = null;
		Student newSt2 = null;
		Student newSt3 = null;
		Student newSt4 = null;
		try {
			newSt1 = new Student (60,"Egor1", format.parse("19.12.1999") , 9.9);
			newSt2 = new Student (60,"Egor2", format.parse("29.12.1999") , 9.9);
			newSt3 = new Student (60,"Egor3", format.parse("19.12.1998")  , 9.9);
			newSt4 = new Student (60,"Egor4", format.parse("19.06.2001") , 8.6);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		sg.addLast(newSt1);
		sg.addLast(newSt2);
		sg.addLast(newSt3);
		sg.addLast(newSt4);
		
		for(int i = 0 ; i < sg.getStudents().length; i++) {
			System.out.println(sg.getStudent(i).getBirthDate());
			System.out.println(sg.getCurrentAgeByDate(i));
		}
		

		for(Student st: sg.getStudentsByAge(18)) {
			System.out.println(st);
		}
	
		System.out.println ("");
		
	}
}
