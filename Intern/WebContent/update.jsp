<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Update User Detaisl</title>
</head>
<body>
<div class="add">
<h1>Update User Details</h1>
<s:actionerror/>
 <s:form action="update" method="post">
    <s:label value="First Name" name="userDetails.firstName"/>
    <s:submit value="Update Contact" align="center"/>
</s:form>
</div>
</body>
</html>