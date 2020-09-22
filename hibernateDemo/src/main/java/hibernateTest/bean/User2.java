package hibernateTest.bean;

import javax.persistence.*;

@Entity // 定义了一个实体
@Table(name = "user")
public class User2 {
	@Id// 这表示一个主键
	@GeneratedValue// 这表示一个主键
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String passWord;

	@Column(name = "age")
	private int age;

	@Column(name = "sex")
	private int sex;

	@Column(name = "phone")
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
