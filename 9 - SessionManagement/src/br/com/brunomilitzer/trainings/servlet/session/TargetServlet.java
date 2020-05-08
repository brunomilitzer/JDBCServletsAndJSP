package br.com.brunomilitzer.trainings.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TargetServlet extends HttpServlet {

    private static final long serialVersionUID = 4556098341417485169L;

    @Override
    protected void doGet( final HttpServletRequest request, final HttpServletResponse response) throws IOException {

        final Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for ( final Cookie cookie: cookies) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        }

        final HttpSession session = request.getSession();
        final String userName = ( String ) session.getAttribute( "user" );

        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();

        out.print("<h1>User Name Is: " + userName + "</h1>");
    }
}
