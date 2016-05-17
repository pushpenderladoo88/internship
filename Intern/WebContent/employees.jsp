<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="profileStyle.css">
<title>Home Page</title>
 <script type="text/javascript">
 function profileButtonClicked(){
	 document.getElementById("buttonId").value ="profile";
 }
 function employeesButtonClicked(){
	 document.getElementById("buttonId").value ="employees";
 }
 function projectButtonClicked(){
	 document.getElementById("buttonId").value ="project";
 }
 function statusButtonClicked(){
	 document.getElementById("buttonId").value ="status";
 }
 function addButtonClicked(){
	 document.getElementById("buttonId").value ="add";
 }
 function deleteButtonClicked(){
	 document.getElementById("buttonId").value ="delete";
 }
 </script>
 
</head>	
<body>
<div class="add">
<h1> Employees </h1>
<s:form  action="home" method="post">
    <s:submit value="Proflie" action="profile" onclick="profileButtonClicked();"/>
    <s:submit value="Employees" action="employees" onclick="emloyeesButtonClicked();"/>
    <s:submit value="Project" action="project" onclick="projectButtonClicked();"/>
    <s:submit value="Status" action="status" onclick="statusButtonClicked();"/>
    <s:submit value="Add Employee" action="add" onclick="addButtonClicked();"/>
    <s:submit value="Remove Employee" action="delete" onclick="deleteButtonClicked();"/> 
    <s:hidden name="buttonclickd" label="use" id="buttonId" />
    <s:textfield name="id" label="Employee ID"/>
    <s:textfield name="firstName" label="First Name"/>
    <s:textfield name="lastName" label="Last Name"/>
    <s:textfield name="emailId" label="Email ID"/>
    <s:textfield name="dob" label="Birth Date"/>
    <s:textfield name="gender" label="Gender"/>
    <s:textfield name="salary" label="Salary"/>
    <s:textfield name="roleName" label="Role"/>
</s:form>
</div>
</body>
</html>