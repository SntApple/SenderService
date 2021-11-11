package edu.task4;

import edu.task4.service.UserServiceImpl;

import javax.xml.ws.Endpoint;
import java.util.logging.Logger;

public class SoapServiceServer {
    private static final Logger LOGGER = Logger.getGlobal();


    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/server", new UserServiceImpl());
    }
}
