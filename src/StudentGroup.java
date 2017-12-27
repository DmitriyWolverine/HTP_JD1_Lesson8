import java.util.Date;

public class StudentGroup implements GroupOperationService {

	private Student[] students;
	
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException {
		if(students == null) {
			throw new IllegalArgumentException();
		}
		this.students = students;
	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException {
		if( index < students.length && index >= 0 ) {
			return students[index];
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException  {
		if(student == null) {
			throw new IllegalArgumentException();
		}
		if(index < students.length && index >= 0 ) {
			this.students[index] = student;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException {
		if(student == null) {
			throw new IllegalArgumentException();
		}
		Student [] newStudents = new Student[students.length +1];
		newStudents[0] = student;
		for(int i = 1 ; i < newStudents.length ; i++) {
			newStudents[i] = students[i-1];
		}
		this.students = newStudents;
	}

	@Override
	public void addLast(Student student)  throws IllegalArgumentException {
		if(student == null) {
			throw new IllegalArgumentException();
		}
		Student [] newStudents = new Student[students.length +1];
		newStudents[students.length] = student;
		for(int i = 0 ; i < students.length ; i++) {
			newStudents[i] = students[i];
		}
		this.students = newStudents;
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException {
		if(student == null) {
			throw new IllegalArgumentException();
		}
		if(index == students.length) {
			addLast(student);
		}
		else if(index == 0 ) {
			addFirst(student);
		}
		else {
			if(index < students.length && index >= 0 ) {
				Student [] newStudents = new Student[students.length +1];
				for ( int i = 0 ; i < index ; i++) {
					newStudents[i] = students[i];
				}
				newStudents[index] = student;
				for(int i = index + 1 ; i < newStudents.length ; i++) {
					newStudents[i] = students[i-1];
				}
				this.students = newStudents;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
	}

	@Override
	public void remove(int index) throws IllegalArgumentException  {
		if( index >= students.length || index < 0) {
			throw new IllegalArgumentException();
		}
		Student[] newStudents = new Student[ students.length - 1];
		int j = 0;
		for(int i = 0 ; i < students.length ; i++) {
			if( i == index) {
				continue;
			}
			newStudents[j] = students[i];
			j++;
		}
		students = newStudents;
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException {
		if(student == null) {
			throw new IllegalArgumentException();
		}
		
		boolean doesExist = false;
		int index = 0;
		for(int i = 0 ; i < students.length ; i++) {
			if( students[i].equals(student)) {
				doesExist = true;
				index = i;
				break;
			}
		}
		if( doesExist == true) {
			remove(index);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void removeFromIndex(int index) throws IllegalArgumentException{
		if( index >= students.length || index < 0) {
			throw new IllegalArgumentException();
		}
		
		Student[] newStudents = new Student[index];
		for(int i = 0 ; i < index ; i++) {
			newStudents[i] = students[i];
		}
		students = newStudents;
	}

	@Override
	public void removeFromElement(Student student) throws IllegalArgumentException{
		if(student == null) {
			throw new IllegalArgumentException();
		}

		boolean doesExist = false;
		int index = 0 ;
		for(int i = 0 ; i < students.length ; i++) {
			if( students[i].equals(student)) {
				doesExist = true;
				index = i;
				break;
			}
		}
		if(doesExist)
		{
			removeFromIndex(index);
		}
		
	}

	@Override
	public void removeToIndex(int index) throws IllegalArgumentException{
		if( index >= students.length || index < 0 ) {
			throw new IllegalArgumentException();
		}
		Student [] newStudents = new Student[students.length - index ];
		for(int i = index ; i < students.length ; i++) {
			newStudents[ i - index ] = students[i];
		}
		students = newStudents;
	}

	@Override
	public void removeToElement(Student student) throws IllegalArgumentException{
		if(student == null) {
			throw new IllegalArgumentException();
		}
		boolean doesExist = false;
		int index = 0 ;
		for(int i = 0 ; i < students.length ; i++) {
			if( students[i].equals(student)) {
				doesExist = true;
				index = i;
				break;
			}
		}
		if(doesExist)
		{
			removeToIndex(index);
		}
	}

	@Override
	public void bubbleSort() {
		for( int i = 0 ; i< students.length - 1; i++ ) {
			for( int j = i+1; j < students.length ; j++) {
				if( students[i].getFullName().compareTo(students[j].getFullName() ) > 0 ) {
					swap(students, i, j);
				}
			}
		}
	}

	private static void swap (Student[] array, int i , int j) {
		Student temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	@Override
	public Student[] getByBirthDate(Date date) throws  IllegalArgumentException{
		if (date == null )
		{
			throw new IllegalArgumentException();
		}
		int resArraySize = 0;
		for(int i = 0 ; i < students.length ; i++) {
			if (students[i].getBirthDate().equals(date) ) {
				resArraySize++;
			}
		}
		Student []studentsByDate = new Student[resArraySize];
		int j = 0;
		for(int i = 0 ; i < students.length ; i++) {
			if (students[i].getBirthDate().equals(date) ) {
				studentsByDate[j] = students[i];
				j++;
			}
		}
		return studentsByDate;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) throws  IllegalArgumentException{
		if (firstDate == null || lastDate == null)
		{
			throw new IllegalArgumentException();
		}
		int resArraySize = 0;
		for(int i = 0 ; i < students.length ; i++) {
			if ( students[i].getBirthDate().compareTo (firstDate) > 0  &&   students[i].getBirthDate().compareTo (lastDate) <0 ) {
				resArraySize++;
			}
		}
		Student []studentsByDate = new Student[resArraySize];
		int j = 0;
		for(int i = 0 ; i < students.length ; i++) {
			if ( students[i].getBirthDate().compareTo (firstDate) > 0  &&   students[i].getBirthDate().compareTo (lastDate) <0 )
			{
				studentsByDate[j] = students[i];
				j++;
			}
		}
		return studentsByDate;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days)  throws  IllegalArgumentException{
		if (date == null )
		{
			throw new IllegalArgumentException();
		}
		
		long dateToDays = date.getTime() / (24 * 60 * 60 * 1000);
		int firstBorder  = (int)dateToDays - days;
		int secondBorder = (int)dateToDays + days;
		
		int resArraySize = 0;
		for(int i = 0 ; i < students.length ; i++) {
			if ( (students[i].getBirthDate().getTime() / (24 * 60 * 60 * 1000) ) > firstBorder  &&  
					(students[i].getBirthDate().getTime() / (24 * 60 * 60 * 1000) ) < secondBorder ) {
				resArraySize++;
			}
		}
		Student []studentsByDate = new Student[resArraySize];
		int j = 0;
		for(int i = 0 ; i < students.length ; i++) {
			if ( (students[i].getBirthDate().getTime() / (24 * 60 * 60 * 1000) ) > firstBorder  &&  
					(students[i].getBirthDate().getTime() / (24 * 60 * 60 * 1000) ) < secondBorder )
			{
				studentsByDate[j] = students[i];
				j++;
			}
		}
		return studentsByDate;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent)  throws  IllegalArgumentException{
		if (indexOfStudent < 0 || indexOfStudent > students.length )
		{
			throw new IllegalArgumentException();
		}
		long result = new Date().getTime() - getStudent(indexOfStudent).getBirthDate().getTime() ;
		result = result / 1000;
		result = result / 60;
		result = result / 60;
		result = result / 24;
		result = result / 365;
		return 	(int)  result ;
	}

	@Override
	public Student[] getStudentsByAge(int age) throws  IllegalArgumentException{
		if(age < 0) {
			throw new IllegalArgumentException();
		}
		int newSize = 0;
		for( int i = 0 ; i < students.length ; i++) {
			if(getCurrentAgeByDate(i) == age) {
				newSize++;
			}
		}
		Student [] newArr = new Student[newSize];
		int j = 0;
		for( int i = 0 ; i < students.length ; i++) {
			if(getCurrentAgeByDate(i) == age) {
				newArr[j] = students[i];
				j++;
			}
		}
		return newArr;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		double maxMark = 0;
		for(int i = 0 ; i < students.length ; i++) {
			if( students[i].getAvgMark() > maxMark) {
				maxMark = students[i].getAvgMark();
			}
		}
		int newSize = 0;
		for(int i = 0 ; i < students.length ; i++) {
			if( students[i].getAvgMark() == maxMark) {
				newSize++;
			}
		}
		Student[] res = new Student[newSize];
		int j = 0;
		for( int i = 0 ; i < students.length  ; i++) {
			if( students[i].getAvgMark() == maxMark) {
				res[j] = students[i];
				j++;
			}
		}
		return res;
	}

	@Override
	public Student getNextStudent(Student student) throws  IllegalArgumentException{
		if(student == null) {
			throw new IllegalArgumentException();
		}
		boolean doesExist = false;
		int index = 0 ;
		for(int i = 0 ; i < students.length ; i++) {
			if( students[i].equals(student)) {
				doesExist = true;
				index = i;
				break;
			}
		}
		if(doesExist == true ) {
			if ( index == students.length-1 ) {
				return null;
			}
			else {
				return getStudent(index+1);
			}
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
}
