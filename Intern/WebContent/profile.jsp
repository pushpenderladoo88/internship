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
<a href="<s:url action="update"><s:param name="uId" value="userDetails.userId" ><s:property value="userDetails.userId"/> </s:param></s:url>">
EDIT<br>
<img src="edit.png" alt="Edit Prfile" width="42" height="42" border="0"></a> 
<table style="height: 250px;" width="900" border="1">
<tr>
<td>First Name </td>
<td><s:label name="userDetails.firstName"></s:label> </td>
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
<td><img src="displayChart" /></td>
<td>
<a style="text-align:right; float:right" href="<s:url action="addEmployee"><s:param name="managerId" value="userDetails.userId" ><s:property value="userDetails.userId"/> </s:param></s:url>">
ADD EMPLOYEE<br></a>
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
<h1> T A S K &nbsp; &nbsp; &nbsp;D E T A I L S</h1>
<table width="100%" border="1">
<tr>
    <th>Task</th>
    <th>Name</th>
    <th>Status</th>
    <th>Estimated Hours</th>
    <th>Start Date</th>
    <th>End Date</th>
</tr>

<s:iterator value="taskList" var="j">

    <tr>
        <td><s:property value="taskName"/></td>
        <td><s:property value="firstName"/>, <s:property value="lastName"/> </td>
        <td><s:property value="status"/></td>
        <td><s:property value="estimatedHours"/></td>
        <td><s:property value="startDate"/></td>
        <td><s:property value="endDate"/></td>
    </tr> 
  
</s:iterator>
 </table>
</s:form>
</div>
</body>
</html>