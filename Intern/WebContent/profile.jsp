<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  <link rel="stylesheet" type="text/css" href="profileStyle.css">  -->
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
<div >
<h1> U S E R &nbsp; &nbsp; &nbsp;P R O F I L E </h1>
<s:form  action="home" method="post">
    <table style="height: 70%;" width="100%" border="1">
<tbody>
<tr>
<td>
<h2>U S E R &nbsp; &nbsp; &nbsp;D E T A I L S</h2>
<table style="height: 250px;" width="900" border="1">
<tbody>
<tr>
<td><s:label value="First Name"></s:label> </td>
<td><s:label name="userDetails.firstName"></s:label> </td>
<td width="20px"></td>
<td><s:label value="Last Name"></s:label></td>
<td><s:label name="userDetails.lastName"></s:label></td>
</tr>
<tr>
<td><s:label value="Email ID"></s:label></td>
<td><s:label name="userDetails.emailId"></s:label></td>
<td width="20px"></td>
<td><s:label value="Role"></s:label></td>
<td><s:label name="userDetails.roleName"></s:label></td>
</tr>
<tr>
<td><s:label value="Gender"></s:label></td>
<td><s:label name="userDetails.gender"></s:label></td>
<td width="20px"></td>
<td><s:label value="Date of birth"></s:label></td>
<td><s:label name="userDetails.dob"></s:label></td>
</tr>
</tbody>
</table>
</td>
</tr>
<tr>
<td>
<h1> E M P L O Y E E S &nbsp; &nbsp; &nbsp;L I S T </h1>
<table style="height: 450px;" width="100%" border="1">
<tbody>
<tr>
<td>Project Chart</td>
<td><s:label value="First Name" name="employeeList.firstName"></s:label></td>
</tr>
</tbody>
</table>
</td>
</tr>
</tbody>
</table>
</s:form>
</div>
</body>
</html>