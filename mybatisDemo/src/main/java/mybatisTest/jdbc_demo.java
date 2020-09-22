package mybatisTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc_demo {

	public static void main(String[] args) {
		getConn();
	}
	private static Connection getConn() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException var5) {
			var5.printStackTrace();
		}

		try {
			String url = "jdbc:mysql://47.96.142.22:3306/dataBase_demo?useUnicode=true&characterEncoding=UTF-8";
			String user = "DATABASE_Demo";
			String pwd = "lixiaoqi";
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("数据库连接成功");
		} catch (SQLException var4) {
			var4.printStackTrace();
		}

		return con;
	}

}
