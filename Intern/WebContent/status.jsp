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
 </script>
 
</head>	
<body>
<div class="add">
<h1> Project Status </h1>
<s:form  action="home" method="post">
    <s:submit value="Proflie" action="profile" onclick="profileButtonClicked();"/>
    <s:submit value="Employees" action="employees" onclick="emloyeesButtonClicked();"/>
    <s:submit value="Project" action="project" onclick="projectButtonClicked();"/>
    <s:submit value="Status" action="status" onclick="statusButtonClicked();"/> 
    <s:hidden name="buttonclickd" label="use" id="buttonId" />
</s:form>
</div>
</body>
</html>