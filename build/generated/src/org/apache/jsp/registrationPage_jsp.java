package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import app.classes.Music;

public final class registrationPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- ");
      out.write("   -->\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/common.css\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/register.css\" />\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"left-div\">\n");
      out.write("        <div class=\"text-div\">\n");
      out.write("            <span class=\"text\">Follow The Latest Updates <br> In The World Of Music</span><br>\n");
      out.write("            <span class=\"text2\">Keep Up With Your Favorite Artists And Never Miss New Release Ever Again</span>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"right-div\">\n");
      out.write("          \n");
      out.write("        <form class=\"right-container\" action=\"server/registeringProcess.jsp\" method=\"post\">\n");
      out.write("      \n");
      out.write("            <div class=\"right-heading\">Sign Up</div>\n");
      out.write("            <div class=\"right-subheading\">Set Up your Account</div>\n");
      out.write("            <div class=\"form-label\">Name</div>\n");
      out.write("            <div class=\"form-inputs\"><input type=\"text\"  placeholder=\"Enter Your Full Name\" name=\"name\"/></div>\n");
      out.write("            <div class=\"form-label\">Email</div>\n");
      out.write("            <div class=\"form-inputs\"><input type=\"email\"  placeholder=\"Ender valid email\" name=\"email\"/></div>\n");
      out.write("            <div class=\"form-label\">Country</div>\n");
      out.write("            <div class=\"form-inputs\"><input type=\"text\"  placeholder=\"Enter your country name\" name=\"country\"/></div>\n");
      out.write("            <div class=\"form-label\">Password</div>\n");
      out.write("            <div class=\"form-inputs\"><input type=\"password\"  placeholder=\"Ender Your password\" name=\"password\"/></div>\n");
      out.write("            <div class=\"form-label\">Re-Ender Password</div>\n");
      out.write("            <div class=\"form-inputs\"><input type=\"password\"  placeholder=\"ReEnder Your Password\" name=\"repass\"/></div>\n");
      out.write("            <button class=\"submit-btn\">Create Account</button>\n");
      out.write("            <div class=\"login-btn\">Already Have an Account?<a href=\"./index.jsp\">Login here</a></div>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
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
