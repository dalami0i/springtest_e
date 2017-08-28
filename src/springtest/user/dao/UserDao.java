package springtest.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springtest.user.domain.User;

public class UserDao {
	private String insertquery = "INSERT INTO users VALUES (?,?,?)";
	private String deleteAllquery = "DELETE FROM users WHERE 1=1";
	private String getUserquery = "SELECT * FROM users WHERE id = ?";
	private String getCountquery = "SELECT count(*) FROM users WHERE 1=1";

	public void insert(User user){
		try {//toby에서는 throws로 던져 버리지만, 실제 coding에서 exception이 발생하면  try-catch로 잡아야 할 것이므로 exception은 try-catch로 잡는 것을 원칙으로 한다. 아직 처리는 못하지만....인지만 하는 걸로... 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection c = null;
		PreparedStatement ps = null;
		try{
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tobyself2test", "root", "1234");
			ps = c.prepareStatement(insertquery);
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPw());
			ps.executeUpdate();
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			if( ps != null ){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if( c != null ){
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
	
	public void deleteAll(){
		try { 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection c = null;
		PreparedStatement ps = null;
		try{
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tobyself2test", "root", "1234");
			ps = c.prepareStatement(deleteAllquery);
			ps.executeUpdate();
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			if( ps != null ){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if( c != null ){
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
	
	public User getUser(String id){//get에서도 객체로 받아서 처리하는게 일관성이 있지만, 추후 exception test에서 string을 받아야 확인되는 exception으로 Toby 책에서 실습을 하므로 string으로 받아둔다.
		try { 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try{
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tobyself2test", "root", "1234");
			ps = c.prepareStatement(getUserquery);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPw(rs.getString(3));
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			if( rs != null ){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if( ps != null ){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if( c != null ){
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return user;
	}
	
	public int getCount(){//get에서도 객체로 받아서 처리하는게 일관성이 있지만, 추후 exception test에서 string을 받아야 확인되는 exception으로 Toby 책에서 실습을 하므로 string으로 받아둔다.
		try { 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try{
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tobyself2test", "root", "1234");
			ps = c.prepareStatement(getCountquery);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			if( rs != null ){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if( ps != null ){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if( c != null ){
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return count;
	}

}
