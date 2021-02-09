package faculty;

public class Faculty {
	public String reg_num, name, dept, in_section, email, password;
	public int certificate_num, year, in_year, batch;
	
	public Faculty(String reg_num, String name, int year, String dept, int in_year, String section, int batch, String email, String password) {
		this.reg_num = reg_num;
		this.name = name;
		this.year = year;
		this.dept = dept;
		this.in_year = in_year;
		this.in_section = section;
		this.batch = batch;
		this.email = email;
		this.password = password;
	}
}
