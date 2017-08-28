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
		Connection c = null;
		PreparedStatement ps = null;
		try{
			c = new NConnectionMaker().connectionMaker();
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
					e.printStackTrace();
				}
			}
			if( c != null ){
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	public void deleteAll(){
		Connection c = null;
		PreparedStatement ps = null;
		try{
			c = new NConnectionMaker().connectionMaker();
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
	
	public User getUser(String id){
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try{
			c = new NConnectionMaker().connectionMaker();
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
	
	public int getCount(){
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try{
			c = new NConnectionMaker().connectionMaker();
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
