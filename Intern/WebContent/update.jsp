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

        </script>

</head>
<body>
<div class="add">
<h1>Update Contact Manager Pankaj</h1>
<s:actionerror/>
 <s:form action="update" method="post" onsubmit="return validate();">
    <s:textfield name="contact.id" label="Customer id" id="a"/>
    <s:textfield name="contact.firstName" label="Firstname" id="b"/>
    <s:textfield name="contact.lastName" label="Lastname" id="c"/>
    <s:textfield name="contact.emailId" label="Email" id="h"/>
    <s:textfield name="contact.cellNo" label="Cell No." id="d"/>
    <s:textfield name="contact.birthDate" label="Birthdate(MM/DD/YY)"/>
    <s:submit value="Update Contact" align="center"/>
</s:form>
</div>
</body>
</html>