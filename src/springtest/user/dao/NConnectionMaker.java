package springtest.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker {

	@Override
	public Connection connectionMaker() throws SQLException {//return�� �ܼ��ϰ� �ϱ� ���� SQLException�� å�� ���߾� throws��.
		try { 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/tobyself2test", "root", "1234");
	}

}
