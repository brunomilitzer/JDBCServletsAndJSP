package br.com.brunomilitzer.trainings.servlets.mvc.controller;

import br.com.brunomilitzer.trainings.servlets.mvc.model.AverageCalculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/averageController")
public class AverageController extends HttpServlet {

    private static final long serialVersionUID = 7837192475194157178L;

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        int number1 = Integer.parseInt( request.getParameter( "number1" ) );
        int number2 = Integer.parseInt( request.getParameter( "number2" ) );

        AverageCalculator model = new AverageCalculator();
        int result = model.calculate( number1, number2 );

        request.setAttribute( "result", result );

        RequestDispatcher dispatcher = request.getRequestDispatcher( "result.jsp" );
        dispatcher.forward( request, response );
    }
}
