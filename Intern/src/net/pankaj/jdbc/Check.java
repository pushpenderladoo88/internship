package net.pankaj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.RE;

import net.pankaj.model.Contact;
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
   
   
   public String checkIfUserExist(String userId){
	   int status=0;
	   String userid = userId;
	   String userName = null;
	      Connection conn = null;

	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         
	         String checkQuery = "Select username from login_tbl where user_id = ?";
	         PreparedStatement ps1 = conn.prepareStatement(checkQuery);
	         ps1.setString(1, userId);
	         ResultSet rs = ps1.executeQuery();

	         while (rs.next()) {
	        	 userName = rs.getString("username");
	           // ret = empRole;
	         }
	         
	         
	        
	      } catch (Exception e) {
	         System.out.println(e);
	      }
	      return userName;
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
	            retur = "valid";
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
   
   public int adding(String managerId,String userId) {
	      String retur = ERROR;
	      String valid;
	      int status=0;
	      Connection conn = null;
	      System.out.println("now in database Check.java");

	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         String sql = "update user_tbl set manager_id= ? where user_id = ? ";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, managerId);
	         ps.setString(2, userId);
	         status = ps.executeUpdate();

	      } catch (Exception e) {
	         status = 0;
	      } finally { 
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      return status;
	   }
   
   public int addingTask(String taskId,String userId) {
	      String retur = ERROR;
	      String valid;
	      int status=0;
	      Connection conn = null;
	      System.out.println("now in database to add task");

	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         String sql = "update task_assignment_tbl set assign_to = ? where task_id = ? ";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, userId);
	         ps.setString(2, taskId);
	         status = ps.executeUpdate();

	      } catch (Exception e) {
	    	  e.printStackTrace();
	         status = 0;
	      } finally { 
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            	e.printStackTrace();
	            }
	         }
	      }
	      return status;
	   }
   
   public int deleting(String managerId,String userId) {
	      String retur = ERROR;
	      String valid;
	      int status=0;
	      Connection conn = null;

	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         String sql = "update user_tbl set manager_id= NULL where user_id = ? ";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, userId);
	         status = ps.executeUpdate();

	      } catch (Exception e) {
	         status = 0;
	      } finally { 
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      return status;
	   }
   
   public int update(Contact s){
	   int status=0;
	   String userName = null;
	      Connection conn = null;
	      try{
	    	  System.out.println("inside databse " + s.getUserId());
	    	  String URL = "jdbc:mysql://localhost:3306/manage";
		         Class.forName("com.mysql.jdbc.Driver");
		         conn = DriverManager.getConnection(URL, "root", "12345");
	   String sql = "Update user_tbl set first_name = ?, last_name = ?, email_id = ?, dob = ? where user_id = ?";
       PreparedStatement ps = conn.prepareStatement(sql);
       ps.setString(1, s.getFirstName());
       ps.setString(2, s.getLastName());
       ps.setString(3, s.getEmailId());
       ps.setDate(4,s.getDob());
       ps.setString(5, s.getUserId());
       status=ps.executeUpdate();
   }
    catch (Exception e) {
   System.out.println(e);
}finally { 
    if (conn != null) {
        try {
           conn.close();
        } catch (Exception e) {
        }
     }
  }

return status;
}

	   

   public String retrieveUserId(ContactAction s) {
	      String retur = ERROR;
	      String valid;
	      String userId="";
	      Connection conn = null;

	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         String sql = "SELECT user_id from login_tbl where username = ? AND password = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, s.getUsername());
	         ps.setString(2, s.getPassword());
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	 userId = rs.getString(1);
	            //retur = "valid";
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
	      return userId;
	   }
   
   public Contact retrieveUserDetails(String userId ) {
		  Contact details = new Contact();
	      Connection conn = null;
	      String ret = null;

	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         String sql = "SELECT * FROM role_tbl A, user_tbl B WHERE B.USER_ID = ? AND A.ROLE_ID = B.ROLE_ID ";
	         //sql+=" empid = ? ";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, userId);
	         //ps.setString(2, role);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	 //details.setUserame(rs.getString("username"));
	        	 details.setFirstName(rs.getString("first_name"));
	        	 details.setLastName(rs.getString("last_name"));
	        	 details.setEmailId(rs.getString("email_id"));
	        	 details.setRoleName(rs.getString("role_name"));
	        	 details.setGender(rs.getString("gender"));
	        	 details.setDob(rs.getDate("dob")); 
	        	 details.setUserId(rs.getString("user_id"));
	        	 details.setManagerId(rs.getString("manager_id"));
	         }
	      } catch (Exception e) {
	         ret = ERROR;
	      } 
	      
	      return details;
	   }
   
   public List<Contact> retrieveemployeeList(String userId ) {
		
	      Connection conn = null;
	      String ret = null;
	      List<Contact> employeeList = new ArrayList<Contact>();
	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         String sql = "SELECT * FROM user_tbl WHERE MANAGER_ID = ? ";
	         //sql+=" empid = ? ";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, userId);
	         //ps.setString(2, role);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	  Contact details = new Contact();
	        	 //details.setUserame(rs.getString("username"));
	        	 details.setFirstName(rs.getString("first_name"));
	        	 details.setUserId(rs.getString("user_id"));
	        	 employeeList.add(details);
	         }
	      } catch (Exception e) {
	         ret = ERROR;
	      } 
	      
	      return employeeList;
	   }

   public List<Contact> retrievetaskList(String userId ) {
		  System.out.println("inside task details");
		  System.out.println(userId);
	      Connection conn = null;
	      String ret = null;
	      List<Contact> taskList = new ArrayList<Contact>();
	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         String sql = "select  task_tbl.TASK_NAME, user_tbl.FIRST_NAME ,user_tbl.LAST_NAME, "
	        		 + "status_tbl.STATUS,task_assignment_tbl.ESTIMATED_HOURS,task_assignment_tbl.TASK_START_DATE , "
	        		 +"task_assignment_tbl.TASK_END_DATE from task_tbl,user_tbl,status_tbl,task_assignment_tbl "
	        		 +"where task_tbl.TASK_ID = task_assignment_tbl.TASK_ID "
	        		 +"and status_tbl.STATUS_ID = task_assignment_tbl.STATUS "
	        		 +"and user_tbl.USER_ID = task_assignment_tbl.ASSIGN_TO "
	        		 +"and user_tbl.MANAGER_ID = ? ";
	         System.out.println("sql query  " + sql );
	         //sql+=" empid = ? ";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, userId);
	         //ps.setString(2, role);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	 System.out.println("inside resultset");
	        	  Contact details = new Contact();
	        	 //details.setUserame(rs.getString("username"));
	        	 details.setTaskName(rs.getString("task_name"));
	        	 details.setFirstName(rs.getString("first_name"));
	        	 details.setLastName(rs.getString("last_name"));
	        	 details.setStatus(rs.getString("status"));
	        	 details.setEstimatedHours(rs.getInt("estimated_hours"));
	        	 details.setTaskStartDate(rs.getDate("task_start_date"));
	        	 details.setTaskEndDate(rs.getDate("task_end_date"));
	        	 taskList.add(details);
	         }
	      } catch (Exception e) {
	    	  System.out.println("error happen");
	    	  e.printStackTrace();
	         ret = ERROR;
	      } 
	      
	      return taskList;
	   }
   
   public List<Contact> retrieveunassignedTaskList() {
		  System.out.println("inside unassigned task list");
	      Connection conn = null;
	      String ret = null;
	      List<Contact> taskList = new ArrayList<Contact>();
	      try {
	         String URL = "jdbc:mysql://localhost:3306/manage";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "12345");
	         String sql = "SELECT A.task_NAME, A.task_id FROM task_tbl A, task_assignment_tbl B WHERE A.TASK_ID = B.TASK_ID AND b.ASSIGN_TO is NULL";
	         System.out.println("sql query  " + sql );
	         //sql+=" empid = ? ";
	         PreparedStatement ps = conn.prepareStatement(sql);
	       
	         //ps.setString(2, role);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	        	 System.out.println("inside unassigned resultset");
	        	  Contact details = new Contact();
	        	 details.setTaskName(rs.getString("task_name"));
	        	 details.setTaskId(rs.getString("task_id"));
	        	 taskList.add(details);
	         }
	      } catch (Exception e) {
	    	  System.out.println("error happen");
	    	  e.printStackTrace();
	         ret = ERROR;
	      } 
	      
	      return taskList;
	   }
   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

}


