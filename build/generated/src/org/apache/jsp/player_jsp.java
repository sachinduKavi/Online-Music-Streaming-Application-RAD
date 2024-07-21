package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
      out.write("<!DOCTYPE html>\n");

String musicID = request.getParameter("musicID");
Music music = new Music("MU0000000000000001");
//music.fetchValuesFromDatabase(); // Fetch values from database

System.out.println(music.getMusicID() + "This is form me");

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
      out.write("                <h3>Sachindu Kavishka</h3>\n");
      out.write("                <h4>US0000000000001</h4>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"navigation-elements\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>App Gallery</li>\n");
      out.write("                    <li>Play List</li>\n");
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
      out.write("             <div class=\"row\">\n");
      out.write("                <h3>Now Playing....</h3>\n");
      out.write("                <h1 class=\"music-title\"></h1>\n");
      out.write("                <h3 class=\"artist-name\"></h3>\n");
      out.write("             </div>\n");
      out.write("\n");
      out.write("             <div class=\"row player-row\">\n");
      out.write("                <div class=\"cover-image column\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                 \n");
      out.write("\n");
      out.write("                <div class=\"music-description column\">\n");
      out.write("                    <label for=\"\">Music Name:</label>\n");
      out.write("                    <h3>Despacito daddy yanki</h3>\n");
      out.write("\n");
      out.write("                    <label for=\"\">Artist</label>\n");
      out.write("                    <h3>Despacito daddy yanki</h3>\n");
      out.write("                </div>\n");
      out.write("                 \n");
      out.write("             </div>\n");
      out.write("\n");
      out.write("            <div class=\"row music-controls\">\n");
      out.write("                 <audio src=\"https://firebasestorage.googleapis.com/v0/b/beatboxify-rad.appspot.com/o/audio%2FAala%20Lawan%20%20%E0%B6%86%E0%B6%BD%20%E0%B6%BD%E0%B7%80%E0%B6%B1%E0%B7%8A%20-%20Sanjula%20Himala%20ft%20Dulan%20ARX%20(Official%20Music%C2%A0Video).mp3?alt=media&token=8f0998a6-28fa-45f6-a5d1-d37f4e24f0d0\" autoplay=\"1\" controls id=\"audio\" style=\"visibility: hidden\"></audio>\n");
      out.write("                \n");
      out.write("                 <input type=\"range\" value=\"0\" max=\"100\" class=\"seek-bar\" id=\"seek-bar\">\n");
      out.write("                \n");
      out.write("\n");
      out.write("                 <div class=\"controller\">\n");
      out.write("                    <button class=\"control-btn\"><img src=\"assets/icons/previous.png\" alt=\"\" width=\"50px\"></button>\n");
      out.write("                    <button class=\"control-btn\" id=\"play-pause\"><img src=\"assets/icons/play.png\" alt=\"\" width=\"70px\" id=\"play-icon\"></button>\n");
      out.write("                    <button class=\"control-btn\"><img src=\"assets/icons/next.png\" alt=\"\" width=\"50px\"></button>\n");
      out.write("                 </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("\n");
      out.write("        document.addEventListener('DOMContentLoaded', () => {\n");
      out.write("            const audio = document.getElementById('audio')\n");
      out.write("            const seekBar = document.getElementById('seek-bar')\n");
      out.write("\n");
      out.write("\n");
      out.write("            audio.addEventListener('timeupdate', () => {\n");
      out.write("                seekBar.value = (audio.currentTime / audio.duration) * 100\n");
      out.write("            })\n");
      out.write("\n");
      out.write("            seekBar.addEventListener('input', ()=> {\n");
      out.write("                audio.currentTime = (seekBar.value /100) * audio.duration\n");
      out.write("            })\n");
      out.write("\n");
      out.write("            // Play pause the music\n");
      out.write("            document.getElementById('play-pause').addEventListener('click', () => {\n");
      out.write("                if(audio.paused) {\n");
      out.write("                    audio.play()\n");
      out.write("                    document.getElementById('play-icon').src = 'assets/icons/paused.png'\n");
      out.write("                } else {\n");
      out.write("                    audio.pause()\n");
      out.write("                    document.getElementById('play-icon').src = 'assets/icons/play.png'\n");
      out.write("                }\n");
      out.write("            })\n");
      out.write("\n");
      out.write("        \n");
      out.write("        })\n");
      out.write("    </script>\n");
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
