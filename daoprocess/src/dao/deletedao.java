package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import userbean.userbean;

public class deletedao 
{
public static void delete(userbean user) {
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cubic","cubic");
		PreparedStatement pstmt=conn.prepareStatement("delete from empdata where id=?");
		pstmt.setInt(1, user.getId());	
		int i=pstmt.executeUpdate();
		if(i==1) {
			System.out.println("delete success");
		}else {
			System.out.println("delete not success");
		}
		
		
		
	}catch(Exception e) {
		System.out.println(e);
	}
	
	
	
}

}


