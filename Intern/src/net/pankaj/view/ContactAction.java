package net.pankaj.view;

import java.sql.Date;
import java.util.List;

import net.pankaj.controller.ContactManager;
import net.pankaj.jdbc.Check;
import net.pankaj.model.Contact;
 
import com.opensymphony.xwork2.ActionSupport;
 
 
public class ContactAction extends ActionSupport {
 
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
    Contact employeeList = new Contact();
 
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
		 return "profile";
	 }else{
		 addActionError("Username or password is not correct");
		 return "index";
	 }
	 
 } 
 
 public String addEmployee(){
	 Check add = new Check();
	 System.out.println("user id is "+ userId);
	 String addEmp = add.adding(this);
	 System.out.println("returned value is "+ addEmp);
	 if(addEmp.equalsIgnoreCase("VALID")){
		 String userId = add.retrieveUserId(this);
	     setManagerId(userId);
		 return "profile";
	 }else{
		 addActionError("Username or password is not correct");
		 return "index";
	 }
	 
 } 
 
 public String update(){
	 Check updateUser = new Check();
	 System.out.println("firstname is"+ firstName);
	 System.out.println("lastname is "+ lastName);
	 String userId = updateUser.retrieveUserId(this);
	 userDetails = updateUser.retrieveUserDetails(userId);
	 int i = updateUser.update(this);
	 
	 if(i>0){
		 return "profile";
	 }else{
		 return "error";
	 }
	 
 } 
      
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

	public Contact getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Contact employeeList) {
		this.employeeList = employeeList;
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

	
    
}
