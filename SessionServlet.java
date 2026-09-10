import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("uname");
        String course = request.getParameter("course");

        // URL Rewriting
        String url = "VisitorServlet?name="
                + URLEncoder.encode(name, "UTF-8")
                + "&course="
                + URLEncoder.encode(course, "UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Session Servlet</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Session Servlet</h2>");

        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Course: " + course + "</p>");

        out.println("<br>");

        out.println("<a href='" + url + "'>Visit Details</a>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }
}
