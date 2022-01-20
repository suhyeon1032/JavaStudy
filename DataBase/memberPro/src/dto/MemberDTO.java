package dto;

public class MemberDTO {
	private int num;
	private String username;
	private String tel;
	private String email;
	private String birth;
	private String gender;
	private String writedate;
	
	public MemberDTO() {}

	// setter
	public void setNum(int num) {
		this.num = num;
	}
	// getter
	public int getNum() {
		return num;
	}
	
	// setter
	public void setUsername(String username) {
		this.username = username;
	}
	// getter
	public String getUsername() {
		return username;
	}
	
	// mouser -> right bt -> source -> generate getter and setter

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	
	
}
