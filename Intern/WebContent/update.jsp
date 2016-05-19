<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="profileStyle.css">
<title>Update User Detaisl</title>
</head>
<body>
<div class="add">
<h1>Update User Details</h1>
<s:actionerror/>
 <s:form action="update" method="post">
    <s:textfield name="userDetails.userId" label="User ID"/>
    <s:textfield name="userDetails.firstName" label="First Name"/>
    <s:textfield name="userDetails.lastName" label="Last Name"/>
    <s:textfield name="userDetails.emailId" label="Email ID"/>
    <s:textfield name="userDetails.dob" label="Date Of Birth(MM/DD/YY)"/>
    <s:textfield name="userDetails.gender" label="Gender"/>
    <s:textfield name="userDetails.salary" label="Salary"/>
    <s:textfield name="userDetails.roleId" label="Role ID"/>
    <s:textfield name="userDetails.managerId" label="Manager ID"/>
    <s:textfield name="userDetails.isActive" label="Active"/>
    <s:submit value="Update Contact" align="center"/>
</s:form>
</div>
</body>
</html>