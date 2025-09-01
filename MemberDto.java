package Dtos;


public class MemberDto {
	private String userid;
	private String password;
	private String rePassword;
	private String username;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String phone1;
	private String phone2;
	private String phone3;
	private String tel1;
	private String tel2;
	private String tel3;
	private String email;
	private String year;
	private String month;
	private String day;
	
	// 디폴트 생성자
	public MemberDto() {}
	
	// 모든 인자 생성자
	public MemberDto(String userid, String password, String username, String zipcode, String addr1,
			String addr2, String phone1, String phone2, String phone3, String tel1, String tel2, String tel3,
			String email, String year, String month, String day) {
		super();
		this.userid = userid;
		this.password = password;
		this.rePassword = rePassword;
		this.username = username;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.email = email;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// Getter and Setter
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	// toString
	@Override
	public String toString() {
		return "MemberDto [userid=" + userid + ", password=" + password + ",rePassword=" + rePassword + ", username="
				+ username + ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone1=" + phone1
				+ ", phone2=" + phone2 + ", phone3=" + phone3 + ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3
				+ ", email=" + email + ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	
	
}
