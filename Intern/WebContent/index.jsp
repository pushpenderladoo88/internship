<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Contact Manager</title>
 <script type="text/javascript">
 function loginButtonClicked(){
	 document.getElementById("buttonId").value ="login";
 }
 function signUpButtonClicked(){
	 document.getElementById("buttonId").value ="signUp";
 }
 </script>
 <!--script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("a");
                var b = document.getElementById("b");
                var c = document.getElementById("c");
                var d = document.getElementById("d").value;
                var h = document.getElementById("h");
                var valid = true;
                if(a.value.length<=0 || b.value.length<=0 || c.value.length<=0 || d.value.length<=0)
                    {
                        alert("Don't leave the field empty!");
                        valid = false;
                    }
                else{
                	if(isNaN(d))
                		{
                		alert("Please enter valid phone number");
                		valid = false;
                		}
                		
                }
                return valid;
                
            };

        </script-->
</head>	
<body>
<center>
<div class="add" align="center">
<h1 align="center" id="head"> Login/Register </h1>
<s:if test="hasActionErrors()">
   <div class="errors" style="color: red">
      <s:actionerror/>
   </div>
</s:if>



<s:form  action="signup">
    <s:textfield name="username" label="Username" id="a" />
    <s:textfield type="password" name="password" label="Password" id="b" />
    <s:submit value="Login" action="login" onclick="loginButtonClicked();"/>
    <s:submit value="Signup" action="signup" onclick="signUpButtonClicked();"/>
    <s:hidden name="buttonclickd" label="Username" id="buttonId" />
</s:form>
</div>
</center>
</body>
</html>