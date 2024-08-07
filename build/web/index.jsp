<%@page import="app.classes.User"%>
<!-- <%-- Document : player Created on : Jul 18, 2024, 1:25:27 PM Author : Sachindu
Kavishka --%> <%@page import="app.classes.Music"%> <%@page
contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>

<html>
    <%
        // Check whether the cookie is present
        Cookie cookies[] = request.getCookies();
        for(Cookie c: cookies) {
            if(c.getName().equals("user_token")) {
                // Cookie is found 
                User user = new User();
                if(user.cookieAuthorization(c.getValue())) {
                    HttpSession sessionValue = request.getSession();
                    sessionValue.setAttribute("user", user);
                    response.sendRedirect("player.jsp"); // Update session with valid user
                    
                }
            }
        }
        
        %>
    
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>JSP Page</title>
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/login.css" />
  </head>
  <body>
    <div class="container">
      <div class="left-div">
        <div class="text-div">
          <span class="text"
            >Follow The Latest Updates <br />
            In The World Of Music</span
          ><br />
          <span class="text2"
            >Keep Up With Your Favorite Artists And Never Miss New Release Ever
            Again</span
          >
        </div>
      </div>
        
      <form class="right-div" action="server/loginProcess.jsp" method="post">
        <div class="right-container">
          <div class="right-heading">Sign In</div>
          <div class="right-subheading">Login your Account</div>
          <div class="form-label">User email</div>
          <div class="form-inputs">
            <input type="text" placeholder="Enter Your User email" name="email" />
          </div>
          <div class="form-label">Password</div>
          <div class="form-inputs">
            <input type="password" placeholder="Ender Your password" name="password" />
          </div>
          <div class="remember-me">
              <label>Remember Me</label>
              <input type="checkbox" name="remember" value="true"/>
          </div>
          
          <button class="submit-btn">Login</button>
          <div class="login-btn">
            Register Account?<a href="registrationPage.jsp">Register here</a>
          </div>
        </div>
      </form>
      
    </div>
  </body>
</html>
