// JavaScript Document

function checkmyform(){
  if (document.forms["registerForm"]["username"].value == "") 
  { alert("Please enter in your username.");
  return false;
  }
    if (document.forms["registerForm"]["password"].value == "") 
  { alert("Please enter in your password.");
  return false;
  }
  if (document.forms["registerForm"]["firstname"].value == "") 
  { alert("Please enter in your first name.");
  return false;
  }
if (document.forms["registerForm"]["lastname"].value == "") 
  { alert("Please enter in your last name.");
  return false;
  }	
if (document.forms["registerForm"]["email"].value == "") 
  { alert("Please enter in your email address.");
  return false;
  }	
	
	
}