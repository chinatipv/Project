
public class MemberStudent extends Member{
	private String studentID;
	private String school;
	private String year;
	public MemberStudent(String id, String name, String lastname,
			String gender, Day birthday, String NationID, String phonenumber,
			Day currentday, double dicountRate, String rank, int point,
			String type, String password, String province, String postal,
			String condition, String country, String district, String email,
			double memberPrice, String studentID, String school, String year) {
		super(id, name, lastname, gender, birthday, NationID, phonenumber,
				currentday, dicountRate, rank, point, type, password, province,
				postal, condition, country, district, email, memberPrice);
		this.studentID = studentID;
		this.school = school;
		this.year = year;
	}
	
}