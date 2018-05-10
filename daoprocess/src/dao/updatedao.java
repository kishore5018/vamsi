package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import userbean.userbean;

public class updatedao {

	public static void update(userbean user) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement pstmt=conn.prepareStatement("update emp set password=?,email=?,id=? where username=?");
			pstmt.setString(4, user.getUsername());
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.setInt(3, user.getId());
			int i=pstmt.executeUpdate();
			if(i==1) {
				System.out.println("updatesuccess");
			}else {
				System.out.println("update not success");
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
