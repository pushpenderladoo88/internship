package net.pankaj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import net.pankaj.view.ContactAction;

public class Check extends ActionSupport {

   
   private String role;
   private String user;
   private String pass;
   

   public String checkUserRole(String userId ) {
	  String empRole;
      String ret = ERROR;
      Connection conn = null;

      try {
         String URL = "jdbc:mysql://localhost:3306/manage";
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(URL, "root", "12345");
         String sql = "SELECT A.ROLE_NAME FROM role_tbl A, user_tbl B WHERE B.USER_ID = ? AND A.ROLE_ID = B.ROLE_ID";
         //sql+=" empid = ? ";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, userId);
         //ps.setString(2, role);
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            empRole = rs.getString("ROLE_NAME");
            ret = empRole;
         }
      } catch (Exception e) {
         ret = ERROR;
      } 
      
      return ret;
   }
   
   public int insert(ContactAction s){
	   int status=0;
	   String userName = null;
	      Connection conn = null;

	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         
	         String checkQuery = "Select username from login_tbl where username = ?";
	         PreparedStatement ps1 = conn.prepareStatement(checkQuery);
	         ps1.setString(1, s.getUsername());
	         ResultSet rs = ps1.executeQuery();

	         while (rs.next()) {
	        	 userName = rs.getString("username");
	           // ret = empRole;
	         }
	         
	         if(userName != null){
	        	status = 3;
	         }else{
	        	 String sql = "INSERT INTO login_tbl VALUES(?,?,?)";
		         PreparedStatement ps = conn.prepareStatement(sql);
		         ps.setString(1, s.getId());
		         ps.setString(2, s.getUsername());
		         ps.setString(3, s.getPassword());
		         status=ps.executeUpdate();
	         }
	         
	        
	      } catch (Exception e) {
	         System.out.println(e);
	      }
	      return status;
	   }
   
   public String login(ContactAction s) {
	      String retur = ERROR;
	      String valid;
	      Connection conn = null;

	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         String sql = "SELECT * from login_tbl where username = ? AND password = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, s.getUsername());
	         ps.setString(2, s.getPassword());
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	            valid = rs.getString(1);
	            retur = valid;
	         }
	      } catch (Exception e) {
	         retur = ERROR;
	      } finally { 
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      return retur;
	   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }
}
