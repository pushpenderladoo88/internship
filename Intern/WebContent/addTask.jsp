<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="addTaskStyle.css">
<title>Add Task</title>
</head>
<body>
<div class="add">
<h1 align="center"> Add Task</h1><br>
<s:if test="hasActionErrors()">
   <div class="errors" style="color: red">
      <s:actionerror/>
   </div>
</s:if>
<s:form action="addTask">

        <s:property value="taskName"/>
        <s:select label="Tasks not assigned " list="taskList" name="taskName" /><br><br>
        <s:select label="Available Employees " list="employeeList" value="firstName" />

    <s:submit value="Assign" align="left"/>
  
</s:form>

</div>

</body>
</html>