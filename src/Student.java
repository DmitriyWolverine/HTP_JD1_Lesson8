

import java.util.Date;

public class Student {

		private int id;
		private String fullName;
		private Date birthDate;
		private double avgMark;
		private static int number = 1;

		public Student(int id, String fullName, Date birthDate, double avgMark) {
			this.id = id;
			this.fullName = fullName;
			this.birthDate = birthDate;
			this.avgMark = avgMark;
			number++;
		}
		
		public Student()
		{
			id = number;
			fullName = "Student_"+number;
			birthDate = new Date();
			avgMark = 3 + Math.random() * 7 ;
			number++;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public Date getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}

		public double getAvgMark() {
			return avgMark;
		}

		public void setAvgMark(double avgMark) {
			this.avgMark = avgMark;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj == null) {
				return false;
			}
			Student secondStudent = (Student) obj;
			if(this.avgMark == secondStudent.getAvgMark()) {
				if( this.birthDate.equals(secondStudent.getBirthDate() ) ){
					if( this.fullName.equals(secondStudent.getFullName() ) ) {
						if( this.id == secondStudent.getId()) {
							return true;
						}
					}
				}
			}
			return false;
		}

		@Override
		public String toString() {
			return "ID = "+id+"; Name: "+ fullName+ " birthDate: "+birthDate + " avgMark: "+avgMark;
		}
		
}