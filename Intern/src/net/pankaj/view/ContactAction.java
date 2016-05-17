package net.pankaj.view;

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
    public String userId = "";
    public String buttonclickd;
 
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
		 return "profile";
	 }else{
		 addActionError("Username or password is not correct");
		 return "index";
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

	
    
}
