package net.pankaj.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.struts2.ServletActionContext;

import net.pankaj.controller.ContactManager;
import net.pankaj.jdbc.Check;
import net.pankaj.model.Contact;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.hibernate.annotations.Cache;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
 
import com.opensymphony.xwork2.ActionSupport;
import net.pankaj.jdbc.Check; 
 
public class ContactAction extends ActionSupport{
 
    private static final long serialVersionUID = 9149826260758390091L;
    private Contact contact;
    private List<Contact> contactList;
    private String id; 
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    public String userId = "";
    private String emailId;
    private String gender;
    private String roleId;
    private String managerId;
    private Date dob;
    private int salary;
    private String isActive;
    private String statusId;
    private String status;
    private String taskAssignId;
    private String assignTo;
    private String taskId;
    private int estimatedHours;
    private int totalHours;
    private Date taskStartDate;
    private Date taskEndDate;
    private String taskName;
    private String roleName;
    public String buttonclickd;
    Contact userDetails = new Contact();
    private static Connection connection = null;
    List<Contact> employeeList = new ArrayList<Contact>();
    List<Contact> taskList = new ArrayList<Contact>();
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    private ContactManager contactManager;
 
    public ContactAction() {
        contactManager = new ContactManager();
    }
 
    public String execute() {
        this.contactList = contactManager.list();
        System.out.println("execute called");
        return SUCCESS;
    }
    
    public String registerManager(){
     Check insertValues = new Check();
     System.out.println("username "+ username);
     System.out.println("password "+ password);
     System.out.println("id  " + id);
     
     //this.id = userId;
      int i = insertValues.insert(this);
      System.out.println("status "  + i);
       if(i == 3){
    	   addActionError("User already exist");
    	   return "register";
       }else if(i>0){
    	   return "login";
       }
       else{
    	   addActionError("Username already exist");
    	   return "register";
       }
 }
    
    
 public String checkEmployee() {
	 Check checkUser = new Check();
	 System.out.println("id is "+ id);
	 userId = id;
	 String userRole = checkUser.checkUserRole(id);
	 //String userRole = checkUser.checkUserRole(userId);
			 if(userRole.equalsIgnoreCase("MANAGER")){
				 String userName = checkUser.checkIfUserExist(id);
				 if(userName != null){
					 addActionError("User Already registered");
					 return "check";

				 }else{
					 return "register";

				 }
			 }else{
				 addActionError("Registration  not allowed for this userid");

				 return "check";
			 }
 } 
 
 
 public String loginManager(){
	 Check loginUser = new Check();
	 System.out.println("username is "+ username);
	 System.out.println("password is "+ password);
	 String validUser = loginUser.login(this);
	 System.out.println("returned value is "+ validUser); 
	 if(validUser.equalsIgnoreCase("VALID")){
		 String userId = loginUser.retrieveUserId(this);
		 
		 userDetails = loginUser.retrieveUserDetails(userId);
		 employeeList = loginUser.retrieveemployeeList(userId);
		 taskList = loginUser.retrievetaskList(userId);
		 System.out.println("tasklist size"+taskList.size());
		 managerId =userId;
		 request = ServletActionContext.getRequest();
		 response = ServletActionContext.getResponse();
		 System.out.println("request ---->"+request);
		 System.out.println("response ---->"+response);
		 /*try{
			 doGet(request, response);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		*/
		 /*connection = getConnection();
		 JDBCPieDataset dataSet = new JDBCPieDataset(connection);
		 OutputStream out=null;
         try {
         dataSet.executeQuery("SELECT task_id , task_name from task_tbl");
         JFreeChart chart = ChartFactory.createPieChart( "task", dataSet,true ,true ,false);
                 
         if (chart != null) {
                 chart.setBorderVisible(true);
                 int width = 500;
                 int height = 500;
                 response.setContentType("image/jpeg");
                 out = response.getOutputStream();
                 ChartUtilities.writeChartAsJPEG(out, chart, width, height);
         }
         }
         catch (SQLException e) {
                 System.err.println(e.getMessage());
         }
         catch (Exception e) {
		e.printStackTrace();
		}
         finally
          { try{
           out.close();
          }catch(Exception e){
        	  e.printStackTrace();
          }*/
          	 return "profile";
	 }else{
		 addActionError("Username or password is not correct");
		 return "index";
	 }
	 
 } 
 
 /*public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
	 System.out.println("inside doget");
	 connection = getConnection();
 JDBCPieDataset dataSet = new JDBCPieDataset(connection);

 try {
 dataSet.executeQuery("SELECT task_id , task_name from task_tbl");
 JFreeChart chart = ChartFactory.createPieChart(
  "task", 
  dataSet,                    
  true,                    
  true,                     
  false                     
  );
         
 if (chart != null) {
         chart.setBorderVisible(true);
         int width = 300;
         int height = 100;
         response.setContentType("image/jpeg");
         OutputStream out = response.getOutputStream();
         ChartUtilities.writeChartAsJPEG(out, chart, width, height);
 }
 }
 catch (SQLException e) {
         System.err.println(e.getMessage());
 }
 catch (Exception e) {
	// TODO: handle exception
	 e.printStackTrace();
}
}*/
 
 public String showEmployee() {
	 Check loginUser = new Check();
	 System.out.println("Inshide show method");
	 //HttpServletRequest req= HttpS;
	 //req = session.get
	//session = req.getSession();
	 request = ServletActionContext.getRequest();
	 System.out.println("request ---->"+request);
	 //System.out.println("response ---->"+response);
	 //String userId = (String)session.getAttribute("userId");
	 userDetails = loginUser.retrieveUserDetails(userId);

	 String userId = request.getParameter("userId");
	 System.out.println("employee ID in showemployee is -->" + userId);
	 managerId=userDetails.getManagerId();
return "viewEmployee";	
}
 public String addEmployee(){
	 Check add = new Check();
	 request = ServletActionContext.getRequest();
	 System.out.println("user id is "+ userId);
	 System.out.println("manager id is "+ managerId);
	 System.out.println("now after manager Id");
	 int addEmp = add.adding(managerId,userId);
	 System.out.println("returned value is "+ addEmp);
	 if(addEmp>0){
		 String uId = add.retrieveUserId(this);
		 userDetails = add.retrieveUserDetails(managerId);
		 employeeList = add.retrieveemployeeList(managerId);
		 taskList = add.retrievetaskList(managerId);
		 return "added";
	 }else{
		 addActionError("Username or password is not correct");
		 return "error";
	 }
	 
 }
 
 public String deleteEmployee(){
	 Check delete = new Check();
	 Check loginUser = new Check();
	 request = ServletActionContext.getRequest();
	// String managerId = request.getParameter("managerId");
	 System.out.println("user id is "+ userId);
	 System.out.println("manager id" + managerId);
	 int deleteEmp = delete.deleting(managerId,userId);
	 System.out.println("returned value is "+ deleteEmp);
	 if(deleteEmp>0){
		 String uId = delete.retrieveUserId(this);
		 userDetails = loginUser.retrieveUserDetails(managerId);
		 employeeList = loginUser.retrieveemployeeList(managerId);
		 taskList = loginUser.retrievetaskList(managerId);
		 return "deleted";
	 }else{
		 return "error";
	 }
	 
 }
 
 
 public String addTask(){
	 Check task = new Check();
	 request = ServletActionContext.getRequest();
	// String managerId = request.getParameter("managerId");
	 System.out.println("user id is "+ userId);
	 taskList = task.retrieveunassignedTaskList(userId);
	 
		 return "added";
	 }
 
 
 public String goToAddEmployee(){
	 request = ServletActionContext.getRequest();
	 System.out.println("request ---->"+request);
	  managerId = request.getParameter("managerId");
	 System.out.println("manager id is "+ managerId);
		 return "success";
	 
	 
 } 
 
 public String goToAddTask(){
	 request = ServletActionContext.getRequest();
	 System.out.println("request ---->"+request);
	  managerId = request.getParameter("managerId");
	 System.out.println("manager id is "+ managerId);
		 return "success";
	 
	 
 } 
 
 public String update(){
	 Check updateUser = new Check();
	 System.out.println("firstname is"+ firstName);
	 System.out.println("lastname is "+ lastName);
	 Check loginUser = new Check();
	 System.out.println("Inshide show method");
	 //HttpServletRequest req= HttpS;
	 //req = session.get
	//session = req.getSession();
	 request = ServletActionContext.getRequest();
	 System.out.println("request ---->"+request);
	 //System.out.println("response ---->"+response);
	 //String userId = (String)session.getAttribute("userId");
	 //userDetails = loginUser.retrieveUserDetails(userId);

	 String userId = request.getParameter("uId");
	 System.out.println("employee ID in update is -->" + userId);

	 //String userId = updateUser.retrieveUserId(this);
	 userDetails = updateUser.retrieveUserDetails(userId);
	 /*int i = updateUser.update(this);
	 
	 if(i>0){
		 return "profile";
	 }else{
		 return "error";
	 }*/
	 return "update";
 
 } 
 
 public String updateDetails(){
	 Check updateUser = new Check();
	 System.out.println("Inside updateDetails");
int i = updateUser.update(this.userDetails);
	 
	 if(i>0){
		 userDetails = updateUser.retrieveUserDetails(this.userDetails.getUserId());
		 employeeList = updateUser.retrieveemployeeList(this.userDetails.getUserId());
		 taskList = updateUser.retrievetaskList(this.userDetails.getUserId());
		 return "profile";
	 }else{
		 return "error";
	 }	 
	 
 }
 
 /*public static Connection getConnection() {
     if (connection != null)
             return connection;
     else {
     
     String dbUrl = "jdbc:mysql://localhost:3306/manage";
     try {
     Class.forName("com.mysql.jdbc.Driver");
     connection = DriverManager.getConnection(dbUrl, "root", "12345");
     } catch (Exception e) {
             e.printStackTrace();
     }
     return connection;
}
}
      */
    public String signup() throws Exception{
    	String navigte;
    	System.out.println("button clicked is --->"+buttonclickd);
    	if(buttonclickd.equalsIgnoreCase("signup")){
    		navigte= "check";
    	}else{
    		navigte =loginManager();
    	}
    	     
        return navigte;
    }
 
    
   
 
    public List<Contact> getContactList() {
        return contactList;
    }
 
    public void setContact(Contact contact) {
        this.contact = contact;
    }
 
    public void setContactList(List<Contact> contactsList) {
        this.contactList = contactsList;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getButtonclickd() {
		return buttonclickd;
	}

	public void setButtonclickd(String buttonclickd) {
		this.buttonclickd = buttonclickd;
	}

	public Contact getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Contact userDetails) {
		this.userDetails = userDetails;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTaskAssignId() {
		return taskAssignId;
	}

	public void setTaskAssignId(String taskAssignId) {
		this.taskAssignId = taskAssignId;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Date getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

	public ContactManager getContactManager() {
		return contactManager;
	}

	public void setContactManager(ContactManager contactManager) {
		this.contactManager = contactManager;
	}

	public Contact getContact() {
		return contact;
	}

	public List<Contact> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Contact> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Contact> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Contact> taskList) {
		this.taskList = taskList;
	}

	
    
}
