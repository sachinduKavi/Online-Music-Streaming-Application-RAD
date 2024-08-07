<!-- <%-- Document : player Created on : Jul 18, 2024, 1:25:27 PM Author : Sachindu
Kavishka --%> <%@page import="app.classes.Music"%> <%@page
contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>JSP Page</title>
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/register.css" />
  </head>
  <body>
    <div class="container">
      <div class="left-div">
        <div class="text-div">
            <span class="text">Follow The Latest Updates <br> In The World Of Music</span><br>
            <span class="text2">Keep Up With Your Favorite Artists And Never Miss New Release Ever Again</span>
        </div>
      </div>
      <div class="right-div">
          
        <form class="right-container" action="server/registeringProcess.jsp" method="post">
      
            <div class="right-heading">Sign Up</div>
            <div class="right-subheading">Set Up your Account</div>
            <div class="form-label">Name</div>
            <div class="form-inputs"><input type="text"  placeholder="Enter Your Full Name" name="name"/></div>
            <div class="form-label">Email</div>
            <div class="form-inputs"><input type="email"  placeholder="Ender valid email" name="email"/></div>
            <div class="form-label">Country</div>
            <div class="form-inputs"><input type="text"  placeholder="Enter your country name" name="country"/></div>
            <div class="form-label">Password</div>
            <div class="form-inputs"><input type="password"  placeholder="Ender Your password" name="password"/></div>
            <div class="form-label">Re-Ender Password</div>
            <div class="form-inputs"><input type="password"  placeholder="ReEnder Your Password" name="repass"/></div>
            <button class="submit-btn">Create Account</button>
            <div class="login-btn">Already Have an Account?<a href="./index.jsp">Login here</a></div>

        </form>
      </div>
    </div>
  </body>
</html>
