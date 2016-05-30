<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
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
<h2>UNASSIGNED    TASKS</h2>
<s:form action="addTask">
    <s:iterator var="k" value="taskList" >
        <s:property value="taskId"/>
        <s:property value="taskName"/> 
  </s:iterator>
  
    <s:textfield name="userDetails.taskId" label="Task ID"/>
    <s:textfield name="userDetails.userId" label="To User ID"/>
    <s:submit value="Assign" align="left"/>
  
</s:form>

</div>

</body>
</html>