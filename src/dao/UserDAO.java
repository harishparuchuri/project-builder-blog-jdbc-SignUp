package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface {

	public int signUp(User user) {
		String insert = "INSERT INTO user1(email, password)VALUES(?,?)";

		int result = 0;
		try
		{
			Connection cn = ConnectionManager.getConnection();
			
			
			PreparedStatement ps = cn.prepareStatement(insert);
			ps.setString(1,user.getEmail());
			ps.setString(2,user.getPassword());
			System.out.println(ps);
			
			// Step 3: Execute the query or update query
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public boolean loginUser(User user) {
		boolean status = false;
		try{
			Connection cn = ConnectionManager.getConnection();
		
				
		PreparedStatement ps = cn.prepareStatement("select * from user1 where email = ? and password = ? ");
		
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());

			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			// process sql exception
			System.out.println(e);
		}
		return status;
	}

}