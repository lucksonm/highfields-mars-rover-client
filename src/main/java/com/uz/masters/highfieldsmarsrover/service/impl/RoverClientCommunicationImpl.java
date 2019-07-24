package com.uz.masters.highfieldsmarsrover.service.impl;

import com.uz.masters.highfieldsmarsrover.service.RoverClientCommunicator;
import com.uz.masters.highfieldsmarsrover.service.stratergy.IncomingRoverMessageHandler;
import com.uz.masters.highfieldsmarsrover.service.stratergy.util.StratergyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class RoverClientCommunicationImpl implements RoverClientCommunicator {

    IncomingRoverMessageHandler incomingRoverMessageHandler;
    private Socket clientSocket;
    Scanner scanner;
    private PrintWriter printWriter;

    private static final Logger LOGGER = Logger.getLogger(RoverClientCommunicationImpl.class.getName());


    @Override
    public boolean bindToRover(final String ip, final int port) {
        try {
            clientSocket = new Socket(ip, port);
            printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            scanner = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
            while (scanner.hasNext()) {
                scanner.useDelimiter(";");
                String result = scanner.next();
                if(result.startsWith("I")) {
                    incomingRoverMessageHandler = StratergyUtil.generateIncomingMessageHandler(result.charAt(0));
                    incomingRoverMessageHandler.handleIncomingRoverMessage(result);
                }
            }
        } catch (UnknownHostException e) {
            LOGGER.log(Level.SEVERE,"Host does not exist exception {0}",e);
        }catch(IOException e){
            LOGGER.log(Level.SEVERE,"IO Exception {0}",e);
        }
        return false;

    }



}
