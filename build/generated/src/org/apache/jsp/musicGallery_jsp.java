package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import app.classes.User;
import app.classes.Music;

public final class musicGallery_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

int colorDec;
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
   
    
// Load current user
String musicID = request.getParameter("musicID");
HttpSession sessionValue = request.getSession();

// Rediecting back to login page if session is not present
if(sessionValue.getAttribute("user") == null) {
    response.sendRedirect("index.jsp");
    return;
} 

// New user object
User user = (User)sessionValue.getAttribute("user");
user.fetchUserDetails();
    
// Load all favoutite music 
List<Music> musicList = Music.fetchFavouriteMusic(user.getUserID());


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/common.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/playlist.css\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"navigation-bar\">\n");
      out.write("            <div class=\"min-container\">\n");
      out.write("                <img src=\"assets/icons/logo.png\" alt=\"logo-image\" width=\"50%\"/>\n");
      out.write("            \n");
      out.write("                <h2>MUSIC STREAMING</h2>\n");
      out.write("                <h4>");
      out.print(user.getUserName() );
      out.write("</h4>\n");
      out.write("                <h3>");
      out.print(user.getEmail() );
      out.write("</h3>\n");
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
      out.write("                    <li><a href=\"playlist.jsp\">My Playlist</a></li>\n");
      out.write("                    <li><a href=\"player.jsp\">Music Player</a></li>\n");
      out.write("                    <li>About</li>\n");
      out.write("                </ul>\n");
      out.write("                    \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <button class=\"logout-btn\" onclick=\"logout()\">LOGOUT</button>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"inside-container\">\n");
      out.write("                <h1>MY MUSIC PLAYLIST</h1>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("\n");
      out.write("                <div class=\"banner-container\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    ");

                    colorDec = 1127013;
                    for(int i = 0; i < musicList.size(); i++) {
                        Music music = musicList.get(i);
                    
      out.write("\n");
      out.write("                    <div class=\"music-banner\" style=\"background-color: #");
      out.print(Integer.toHexString(colorDec) );
      out.write("\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"column cover-column\">\n");
      out.write("                            <div class=\"cover-image\"\n");
      out.write("                            style=\"background: url('");
      out.print( music.getCoverURL() );
      out.write("'); background-position: center; background-size: cover;\"\n");
      out.write("                            ></div>   \n");
      out.write("                        </div> \n");
      out.write("\n");
      out.write("                        <div class=\"column details-column\" onclick=\"goToMusic('");
      out.print(music.getMusicID());
      out.write("')\"  >\n");
      out.write("                            <h2>");
      out.print(music.getMusicName() );
      out.write("</h2>\n");
      out.write("                            <h4>");
      out.print(music.getArtistName() );
      out.write("</h4>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"column more-details\">\n");
      out.write("                            <h3>");
      out.print(music.getLanguage());
      out.write("</h3>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"column more-details\">\n");
      out.write("                            <h3>");
      out.print(music.getRating() );
      out.write("</h3>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"column end-column\">\n");
      out.write("                            <button onclick=\"unSaveMusic('");
      out.print(music.getMusicID());
      out.write("')\" style=\"background-color: transparent; border: 0\">\n");
      out.write("                                <img src=\"assets/icons/remove.png\" alt=\"remove-icon\" width=\"40px\">\n");
      out.write("                            </button>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                     ");

                        colorDec += 250;
                        }
                        
      out.write("\n");
      out.write("                </div>\n");
      out.write("                    \n");
      out.write("                   \n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("           \n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        function goToMusic(musicID) {\n");
      out.write("            console.log(musicID)\n");
      out.write("            window.location.href = `player.jsp?musicID=` + musicID\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function unSaveMusic(musicID) {\n");
      out.write("            console.log('click on hello', musicID)\n");
      out.write("            fetch('unsaveMusic.jsp?musicID=' + musicID + '&userID=' + '");
      out.print(user.getUserID() );
      out.write("').then(success => {\n");
      out.write("                window.location.href = 'playlist.jsp'\n");
      out.write("            })\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function logout() {\n");
      out.write("            window.location.href = 'server/logout.jsp'\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("   \n");
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
