<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="showEmployeeStyle.css">
<title>Employee Details</title>
</head>
<body>
<div class="add">
<h1>Employee Details</h1>
<s:actionerror/>
 <s:form action="done" method="post">
    <s:label name="userDetails.userId" label="User ID"/>
    <s:label name="userDetails.firstName" label="First Name"/>
    <s:label name="userDetails.lastName" label="Last Name"/>
    <s:label name="userDetails.emailId" label="Email ID"/>
    <s:label name="userDetails.dob" label="Date Of Birth(MM/DD/YY)"/>
    <s:label name="userDetails.gender" label="Gender"/>
    <s:label name="userDetails.managerId" label="Manager ID"/>
    <s:submit value="Back" align="left"/>
    <s:hidden name="managerId"></s:hidden>
    <a style="text-align:right; float:right;" href="<s:url action="deleteEmployee"><s:param name="userId" value="userDetails.userId"><s:property value="userDetails.userId"/> </s:param>
    <s:param name="managerId" value="userDetails.managerId"><s:property value="userDetails.managerId"/> </s:param></s:url>">
<img src="http://nonamescriptware.com/wp-content/uploads/TrashIt_icon_trnspt.png" alt="Edit Prfile" width="52" height="52" border="0" style="float: right;"></a>
    
</s:form>
</div>
</body>
</html>