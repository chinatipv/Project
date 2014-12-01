import java.util.ArrayList;


public class Member extends Person {
	private double dicountRate; // in 1 = 100% .5 = 50%
	private String rank;
//	none = not a member
//	silver = 
//	gold =
//	platinum =
	private int point =0;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private String type;
	private String password;
	private String province;
	private String postal;
	private String condition;
	private String country;
	private String district;
	private String email;
	private double memberPrice;



	public Member(String id, String name, String lastname, String gender,
			Day birthday, String NationID, String phonenumber, Day currentday,
			double dicountRate, String rank, int point, String type,
			String password, String province, String postal, String condition,
			String country, String district, String email, double memberPrice) {
		super(id, name, lastname, gender, birthday, NationID, phonenumber,
				currentday);
		this.dicountRate = dicountRate;
		this.rank = rank;
		this.point = point;
		this.type = type;
		this.password = password;
		this.province = province;
		this.postal = postal;
		this.condition = condition;
		this.country = country;
		this.district = district;
		this.email = email;
		this.memberPrice = memberPrice;
	}



	public void addPoint(int point){
		this.point+=point;
	}
	
}
