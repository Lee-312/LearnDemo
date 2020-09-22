package com.lee;

import java.io.*;

/**
 * 使用ObjectOutputStream/ObjectInputStream流保存对象时，该对象类必须实现Serializable接口，否则会出现NotSerializableException异常
 */
public class SerializableTest {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		Employee secretary = new Employee("A", 1991, 10, 3);

		Employee e1 = new Employee("A", 1991, 10, 3);
		e1.setSecretary(secretary);
		Employee e2 = new Employee("A", 1991, 10, 3);
		e2.setSecretary(secretary);

		Employee[] staff = new Employee[3];
		staff[0] = secretary;
		staff[1] = e1;
		staff[2] = e2;
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.txt"))) {
			out.writeObject(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.txt"))) {
			Employee[] newStaff = (Employee[]) in.readObject();
			for (Employee employee : newStaff) {
				System.out.println(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class Employee implements Serializable {
	private String name;
	private int year;
	private int month;
	private int day;

	private Employee secretary;

	public Employee() {
	}

	public Employee(String name, int year, int month, int day) {
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Employee getSecretary() {
		return secretary;
	}

	public void setSecretary(Employee secretary) {
		this.secretary = secretary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", year=" + year +
				", month=" + month +
				", day=" + day +
				", secretary=" + secretary +
				'}';
	}
}
