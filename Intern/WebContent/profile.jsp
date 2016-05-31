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
<!-- <h2>D E T A I L S</h2> -->
<%-- <a  href="update.jsp?userId=<s:property value="userDetails.userId"/>">update</a> --%>
<a style="float: right" href="<s:url action="update"><s:param name="uId" value="userDetails.userId" ><s:property value="userDetails.userId"/> </s:param></s:url>">
<img src="https://cdn2.iconfinder.com/data/icons/windows-8-metro-style/256/edit.png" alt="Edit Prfile" width="52" height="52" border="0" style="float: right;"></a> 
<table style="height: 250px;" width="900" border="1">
<tr>
<td>First Name </td>
<td><s:label name="userDetails.firstName"></s:label></td>
<td>Last Name </td>
<td><s:label name="userDetails.lastName"></s:label></td>
</tr>
<tr>
<td>Email ID </td>
<td><s:label name="userDetails.emailId"></s:label></td>
<td>Role </td>
<td><s:label name="userDetails.roleName"></s:label></td>
</tr>
<tr>
<td>Gender </td>
<td><s:label name="userDetails.gender"></s:label></td>
<td>Date of birth </td>
<td><s:label name="userDetails.dob"></s:label></td>
</tr>

</table>
</td>
</tr>
<tr>
<td>
<h1 style="text-align:left; float:left"> P R O J E C T &nbsp; &nbsp; &nbsp;S T A T U S </h1>
<h1 style="text-align:right; float:right"> E M P L O Y E E S &nbsp; &nbsp; &nbsp;L I S T</h1>
<hr style="clear:both;"/>
 
<%-- <a href="addEmployee.jsp?userId=<s:property value="userId"/>">Add Employee</a> --%>
<%-- <a href="<s:url action="addEmployee"><s:param name="managerId" value="userDetails.userId" ><s:property value="userDetails.userId"/> </s:param></s:url>">
ADD EMPLOYEE<br></a> --%>
<table style="height: 450px;" width="100%" border="1">
<tbody>
<tr>
<td>

<s:iterator var="n" value="statusList">
<a href="<s:url action="showStatus"><s:param name="statusId" value="statusId" ><s:property value="statusId"/> </s:param></s:url>">
<s:property value="status "/> <s:property value="count"/><br></a> 
<%-- <s:url  action="#" >
<s:param name="userId" value="userId" ><s:property value="firstName"/> </s:param>
</s:url> <s:property value="firstName"/> --%>
<%-- <s:a href="%url"><s:property value="firstName"/> </s: --%>
</s:iterator>

<td>
<a style="text-align:right; float:right" href="<s:url action="goToAddEmployee"><s:param name="managerId" value="userDetails.userId" ><s:property value="userDetails.userId"/> </s:param></s:url>">
<img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQOGEfXM9JhOBJLUIAj_9CYfG21PwW7nlP-dfROHlfJO1uq8G1XYg" alt="Add Employee" width="60" height="60" border="0" style="float: right;"></a>
<s:iterator var="i" value="employeeList">
<a href="<s:url action="showEmployee"><s:param name="userId" value="userId" ><s:property value="userId"/> </s:param></s:url>">
<s:property value="firstName"/><br></a> 
<%-- <s:url  action="#" >
<s:param name="userId" value="userId" ><s:property value="firstName"/> </s:param>
</s:url> <s:property value="firstName"/> --%>
<%-- <s:a href="%url"><s:property value="firstName"/> </s: --%>

</s:iterator>
</td>
</tr>
</tbody>
</table>
</td>
</tr>


</tbody>
</table>
<h1> T A S K &nbsp; &nbsp; &nbsp;D E T A I L S
<a style="text-align:right; float:right" href="<s:url action="goToAddTask"><s:param name="managerId" value="userDetails.userId" ><s:property value="userDetails.userId"/> </s:param></s:url>">
<img src="http://www.iconsplace.com/icons/preview/orange/add-list-256.png" alt="Add Task" width="60" height="60" border="0" style="float: right;"></a>
</h1>
<table width="100%" border="1">
<tr>
    <th>Task</th>
    <th>Name</th>
    <th>Status</th>
    <th>Estimated Hours</th>
    <th>Start Date</th>
    <th>End Date</th>
</tr>

<s:iterator var="j" value="taskList" >

    <tr>
        <td><s:property value="taskName"/></td>
        <td><s:property value="firstName "/> <s:property value="lastName"/> </td>
        <td><s:property value="status"/></td>
        <td><s:property value="estimatedHours"/></td>
        <td><s:property value="taskStartDate"/></td>
        <td><s:property value="taskEndDate"/></td>
    </tr> 
  
</s:iterator>
 </table>
</s:form>
</div>
</body>
</html>