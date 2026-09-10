import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VisitorServlet")
public class VisitorServlet extends HttpServlet {

    static int count = 0;

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String course = request.getParameter("course");

        HttpSession session = request.getSession();

        if (session.isNew()) {
            count++;
        }

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Visitor Details</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Visitor Details</h2>");

        out.println("<h3>Name: " + name + "</h3>");

        out.println("<h3>Course: " + course + "</h3>");

        out.println("<h3>Unique Visitors: " + count + "</h3>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }
}
