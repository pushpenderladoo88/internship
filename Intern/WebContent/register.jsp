<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Main Registration</title>
<script type="text/javascript">
var pass_strength;
function IsEnoughLength(str,length)
{if ((str == null) || isNaN(length))return false;else if (str.length < length)return false;return true;
}
function HasMixedCase(passwd)
{
if(passwd.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/))return true; else return false;
}
function HasNumeral(passwd)
{if(passwd.match(/[0-9]/))
return true; else return false;
}
function HasSpecialChars(passwd)
{
if(passwd.match(/.[!,@,#,$,%,^,&,*,?,_,~]/))return true; else return false;
}
function CheckPasswordStrength(password)
{if (IsEnoughLength(password,14) && HasMixedCase(password) && HasNumeral(password) && HasSpecialChars(password))pass_strength = "<b><font style='color:olive'>Very strong</font></b>";else if (IsEnoughLength(password,8) && HasMixedCase(password) && (HasNumeral(password) || HasSpecialChars(password)))pass_strength = "<b><font style='color:Blue'>Strong</font></b>";
else if (IsEnoughLength(password,8) && HasNumeral(password))pass_strength = "<b><font style='color:Green'>Good</font></b>";
else pass_strength = "<b><font style='color:red'>Weak</font></b>";
document.getElementById('pwd_strength').innerHTML = pass_strength;
}
</script>


<script type="text/javascript">
function checkPass()
{
    var pass1 = document.getElementById('Password');
    var pass2 = document.getElementById('CnfPassword');
   
    var message = document.getElementById('confirmMessage');
    
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    
    if(pass1.value == pass2.value){
        
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
    }else{
       
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}  
</script>

</head>
<body>
<div class="add">
<h1 align="center"> Register </h1>
<s:actionerror/>
<s:form action="register" method="post" onclick="return Validate()">
    <s:textfield name="username" label="Username"/>
    <s:textfield type="password" name="password" label="Password" id="Password" onkeyup='CheckPasswordStrength(this.value);'/>
    <div id='pwd_strength'></div>
    <s:textfield type="password" name="CnfPassword" label="Confirm Password" id="CnfPassword" onkeyup="checkPass(); return false;"/>
    <span id="confirmMessage" class="confirmMessage"></span>
     <s:hidden name="id" label="id"/>
    <s:submit value="Submit"/>
     
</s:form>

</div>
</body>
</html>