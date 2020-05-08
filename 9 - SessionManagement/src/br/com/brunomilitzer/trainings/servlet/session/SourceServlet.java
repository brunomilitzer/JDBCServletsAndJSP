package br.com.brunomilitzer.trainings.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SourceServlet extends HttpServlet {

    private static final long serialVersionUID = 2425625362197572486L;

    @Override
    protected void doPost( final HttpServletRequest request, final HttpServletResponse response) throws IOException {

        final Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for ( final Cookie cookie: cookies) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        }

        response.addCookie( new Cookie( "security", "12345" ) );

        final String username = request.getParameter("userName");
        final HttpSession session = request.getSession();
        session.setAttribute("user", username);

        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();

        final String url = "targetServlet?sessionId=123";

        out.print("<a href='" + url + "'>Click Here to Get the User Name </a>");
    }
}
