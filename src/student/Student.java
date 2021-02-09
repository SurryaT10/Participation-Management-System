package student;

public class Student {
	public String reg_num, name, dept, section, email, password;
	public int certificate_num, year, batch;
	
	public Student(String reg_num, String name, int year, String dept, String section, int batch, String email, String password) {
		this.reg_num = reg_num;
		this.name = name;
		this.year = year;
		this.dept = dept;
		this.section = section;
		this.batch = batch;
		this.email = email;
		this.password = password;
	}
}
