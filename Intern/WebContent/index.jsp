<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Contact Manager</title>
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
<div class="add">
<h1 align="center"> Login/Register </h1>
<s:actionerror/>
<s:form action="signup" method="post">
    <s:textfield name="contact.UserName" label="Username" id="a"/>
    <s:textfield type="password" name="contact.Password" label="Password" id="b"/>
    <s:submit value="Login" action="login" method="post"/>
    <s:submit value="Signup" />
</s:form>
</div>
</body>
</html>