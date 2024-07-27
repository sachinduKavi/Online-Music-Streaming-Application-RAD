package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import app.classes.User;
import app.classes.Music;

public final class player_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    
String musicID = request.getParameter("musicID");
HttpSession sessionValue = request.getSession();


sessionValue.setAttribute("user_ID", "US0000000000000001");

// New user object
User user = new User((String)sessionValue.getAttribute("user_ID"));
user.fetchUserDetails();


if(musicID == null) {
    if(sessionValue.getAttribute("current-music") != null) {
       musicID = (String)sessionValue.getAttribute("current-music");
    } else 
    musicID = "MU0000000000000001";
}
Music music = new Music(musicID);
music.fetchValuesFromDatabase(); // Fetch values from database

// Check whether music is fav
boolean favState = music.favCheck(user.getUserID());


// Set volume 
int volume = (request.getParameter("v") != null)? Integer.valueOf(request.getParameter("v")): 90;

// Update session current music ID
session.setAttribute("current-music", musicID);



      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/common.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/player.css\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"navigation-bar\">\n");
      out.write("            <div class=\"min-container\">\n");
      out.write("                <img src=\"assets/icons/logo.png\" alt=\"logo-image\" width=\"50%\"/>\n");
      out.write("            \n");
      out.write("                <h2>MUSIC STREAMING</h2>\n");
      out.write("                <h3>");
      out.print(user.getEmail() );
      out.write("</h3>\n");
      out.write("                <h4>");
      out.print(user.getUserName() );
      out.write("</h4>\n");
      out.write("                <h5>");
      out.print(user.getUserID() );
      out.write("</h5>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"navigation-elements\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>Music Gallery</li>\n");
      out.write("                    <li>Play List</li>\n");
      out.write("                    <li><a href=\"player.jsp\">Music Player</a></li>\n");
      out.write("                    <li>About</li>\n");
      out.write("                </ul>\n");
      out.write("                    \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <button class=\"logout-btn\">LOGOUT</button>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("             \n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("       \n");
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
