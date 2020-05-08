package br.com.brunomilitzer.trainings.servlets.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed( ServletRequestEvent event ) {

        System.out.println( "Request destroyed" );
    }

    @Override
    public void requestInitialized( ServletRequestEvent event ) {

        System.out.println( "Request created" );
    }
}
