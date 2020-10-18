package com.lee.JAVA编程思想.Part20_注释;

import java.util.List;

public class PasswordUtils {
	@UserCase(id = 47, description = "Passwords must contain at least one numric")
	public boolean validatePassword(String password) {
		return (password.matches("\\w*\\d\\w*"));
	}

	@UserCase(id = 48)
	public String encryptPassword(String password) {
		return new StringBuffer(password).reverse().toString();
	}

	@UserCase(id = 49, description = "New passwords can't equal previously userd ones")
	public boolean checkForNewPassword(List<String> prePasswords, String password) {
		return !prePasswords.contains(password);
	}

}
