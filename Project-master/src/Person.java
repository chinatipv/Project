import java.util.Date;

public class Person {
	private String ID;
	private String name;
	private String lastname;
	private String gender;
	private Day birthday;
	private String NationID;
	private String phonenumber;
	private int age;


	Person(String id, String name,String lastname,String gender,Day birthday,String NationID,String phonenumber,Day currentday){
		this.ID=id;
		this.name=name;
		this .lastname=lastname;
		this.gender=gender;
		this.birthday = birthday;
		this.NationID = NationID;
		this.phonenumber = phonenumber;
		this.age = this.getAge(currentday);
	}
	public void ChangePhoneNumber(String phonenumber){
		this.phonenumber = phonenumber;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Day getBirthday() {
		return birthday;
	}
	public void setBirthday(Day birthday) {
		this.birthday = birthday;
	}
	public String getNationID() {
		return NationID;
	}
	public void setNationID(String nationID) {
		NationID = nationID;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getAge(Day currentday) {
		int duration =this.birthday.getDayTillTheMoviePermier(currentday);
		int year = duration/360;
		return year;
		
	}
	public void setId(String id){
		this.ID=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setLastname(String lastname){
		this.lastname=lastname;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public String getId(){
		return this.ID;
	}
	public String getName(){
		return this.name;
	}
	public String getLastname(){
		return this.lastname;
	}
	
	public String getGender(){
		return this.gender;
	}
	public String toString(){
		return "ID: "+this.ID+"  Name: "+this.name+" "+this.lastname+"  Gender: "+this.gender+"  Age: "+this.age+" years  NationID: "+this.NationID+"  Phone: "+this.phonenumber;
	}
	public boolean equals(Person key){
		if(this.ID.equals(key.ID)&&this.name.equals(key.name)&&this.lastname.equals(key.lastname)&&this.gender.equals(key.gender)&&this.birthday.equals(key.birthday)&&this.NationID.equals(key.NationID)&&this.phonenumber.equals(key.phonenumber))
			return true;
		return false;
	}
	
}