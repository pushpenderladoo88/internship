<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="profileStyle.css">
<title>Status</title>
</head>	
<body>
<div class="add">
<h1 align="center"> Status </h1><br>
<s:if test="hasActionErrors()">
   <div class="errors" style="color: red">
      <s:actionerror/>
   </div>
</s:if>
<s:form action="goback">

    <table width="100%" border="1">
<tr>
    <th>Task</th>
    <th>Name</th>
    <th>Status</th>
    <th>Estimated Hours</th>
    <th>Start Date</th>
    <th>End Date</th>
</tr>

<s:iterator var="j" value="statusTaskList" >

    <tr>
        <td><s:property value="taskName"/></td>
        <td><s:property value="firstName "/> <s:property value="lastName"/> </td>
        <td><s:property value="status"/></td>
        <td><s:property value="estimatedHours"/></td>
        <td><s:property value="taskStartDate"/></td>
        <td><s:property value="taskEndDate"/></td>
    </tr> 
    
    <s:hidden name="managerId"></s:hidden>

    <s:submit value="Done" align="left"/>
  
  
</s:iterator>
 </table>
             
</s:form>

</div>
</body>
</html>