import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

public class MainServlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      HttpSession session = request.getSession(false);
      if (session == null) {
        response.setStatus(302);
        response.sendRedirect("login");  
      }   
      String title = "Logged in as: ";
      title += session.getAttribute("USER_ID");
      response.setContentType("text/html");
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      String html = docType + "<html>\n" + "<head><title>" + title + "</title>\n"
    + "<style>\n" +
    ".container {\n" +
    "  display: flex;\n" +
    "  flex-wrap: wrap;\n" +
    "  justify-content: center;\n" +
    "  align-items: center;\n" +
    "  height: 50vh;\n" +
    "}\n" +
    ".box {\n" +
    "  flex: 0 0 calc(50% - 20px);\n" +
    "  height: 100px;\n" +
    "  margin: 10px;\n" +
    "  text-align: center;\n" +
    "}\n" +
    ".pink { background-color: pink; }\n" +
    ".blue { background-color: blue; }\n" +
    ".green { background-color: green; }\n" +
    ".yellow { background-color: yellow; }\n" +
    "</style>\n" +
    "</head>\n" + "<body>\n" +
    "<h1 align=\"center\">" + title + "</h1>\n" +
    "<div class=\"container\">\n" +
    "<div class=\"box pink\">\n" +
    "<form action=\"your_action_url_here\" method=\"POST\">\n" +
    "<input type=\"submit\" value=\"Car\" />\n" +
    "</form>\n" +
    "</div>\n" +
    "<div class=\"box blue\">\n" +
    "<form action=\"your_action_url_here\" method=\"POST\">\n" +
    "<input type=\"submit\" value=\"Sport\" />\n" +
    "</form>\n" +
    "</div>\n" +
    "<div class=\"box green\">\n" +
    "<form action=\"your_action_url_here\" method=\"POST\">\n" +
    "<input type=\"submit\" value=\"Songs\" />\n" +
    "</form>\n" +
    "</div>\n" +
    "<div class=\"box yellow\">\n" +
    "<form action=\"your_action_url_here\" method=\"POST\">\n" +
    "<input type=\"submit\" value=\"Commercial\" />\n" +
    "</form>\n" +
    "</div>\n" +
    "</div>\n" +
    "<div style=\"text-align: center;\">\n" +
    "<form action=\"upload\" method=\"GET\">\n" +
    "<input type=\"submit\" value=\"UPLOAD\" />\n" +
    "</form>\n" +
    "</div>\n" +
    "<div style=\"text-align: center;\">\n" +
    "<form action=\"play\" method=\"GET\">\n" +
    "<input type=\"submit\" value=\"GALLERY\" />\n" +
    "</form>\n" +
    "</div>\n" +
    "<div style=\"text-align: center;\">\n" +
    "<form action=\"logout\" method=\"GET\">\n" +
    "<input type=\"submit\" value=\"LOGOUT\" />\n" +
    "</form>\n" +
    "</div>\n" + "</body></html>";

      PrintWriter out = response.getWriter();
      out.println(html);
  }
}
