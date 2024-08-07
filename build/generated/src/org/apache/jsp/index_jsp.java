package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import app.classes.User;
import app.classes.Music;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!-- ");
      out.write("   -->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    ");

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
        
        
      out.write("\r\n");
      out.write("    \r\n");
      out.write("  <head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>JSP Page</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/common.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/login.css\" />\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"left-div\">\r\n");
      out.write("        <div class=\"text-div\">\r\n");
      out.write("          <span class=\"text\"\r\n");
      out.write("            >Follow The Latest Updates <br />\r\n");
      out.write("            In The World Of Music</span\r\n");
      out.write("          ><br />\r\n");
      out.write("          <span class=\"text2\"\r\n");
      out.write("            >Keep Up With Your Favorite Artists And Never Miss New Release Ever\r\n");
      out.write("            Again</span\r\n");
      out.write("          >\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("        \r\n");
      out.write("      <form class=\"right-div\" action=\"server/loginProcess.jsp\" method=\"post\">\r\n");
      out.write("        <div class=\"right-container\">\r\n");
      out.write("          <div class=\"right-heading\">Sign In</div>\r\n");
      out.write("          <div class=\"right-subheading\">Login your Account</div>\r\n");
      out.write("          <div class=\"form-label\">User email</div>\r\n");
      out.write("          <div class=\"form-inputs\">\r\n");
      out.write("            <input type=\"text\" placeholder=\"Enter Your User email\" name=\"email\" />\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"form-label\">Password</div>\r\n");
      out.write("          <div class=\"form-inputs\">\r\n");
      out.write("            <input type=\"password\" placeholder=\"Ender Your password\" name=\"password\" />\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"remember-me\">\r\n");
      out.write("              <label>Remember Me</label>\r\n");
      out.write("              <input type=\"checkbox\" name=\"remember\" value=\"true\"/>\r\n");
      out.write("          </div>\r\n");
      out.write("          \r\n");
      out.write("          <button class=\"submit-btn\">Login</button>\r\n");
      out.write("          <div class=\"login-btn\">\r\n");
      out.write("            Register Account?<a href=\"registrationPage.jsp\">Register here</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </form>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
