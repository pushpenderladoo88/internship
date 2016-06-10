<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="updateStyle.css">
<title>Update User Detaisl</title>
</head>
<body>
<div class="add">
<h1>Update User Details</h1>
<s:actionerror/>
 <s:form action="updateDetails" method="post">
    <s:textfield name="userDetails.userId" label="User ID"/>
    <s:textfield name="userDetails.firstName" label="First Name"/>
    <s:textfield name="userDetails.lastName" label="Last Name"/>
    <s:textfield name="userDetails.emailId" label="Email ID"/>
    <s:textfield name="userDetails.dob" label="Date Of Birth(MM/DD/YY)"/>
    <s:submit value="Update" align="center"/>
</s:form>
</div>
</body>
</html>