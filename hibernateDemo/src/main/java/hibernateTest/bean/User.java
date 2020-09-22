package hibernateTest.bean;

public class User {
	private int id;
	private String userName;
	private String passWord;
	private int age;
	private int sex;
	private long phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", passWord=" + passWord +
				", age=" + age +
				", sex=" + sex +
				", phone=" + phone +
				'}';
	}
}
