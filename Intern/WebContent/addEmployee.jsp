<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Add Employee</title>
</head>
<body>
<div class="add">
<h1 align="center"> Add Employee </h1>
<s:if test="hasActionErrors()">
   <div class="errors" style="color: red">
      <s:actionerror/>
   </div>
</s:if>

<s:form action="addEmployee" method="post">
    <s:textfield name="userId" label="Enter User ID"/>
     <s:hidden name="id" label="id"/>
     <s:hidden name="managerId"></s:hidden>
    <s:submit value="Submit"/>
     
</s:form>

</div>
</body>
</html>