package com.uz.masters.highfieldsmarsrover.controller;

import com.uz.masters.highfieldsmarsrover.controller.model.ConnectionRequest;
import com.uz.masters.highfieldsmarsrover.controller.service.ConnectionService;
import com.uz.masters.highfieldsmarsrover.controller.service.ConnectionServiceImpl;
import com.uz.masters.highfieldsmarsrover.controller.service.MessageProcessingServiceImpl;

import java.util.Scanner;


public class ControllerApplication {

    private static Scanner input=new Scanner(System.in);

    public static void main(String [] args) throws Exception{
        System.out.print("Please enter the IP Address for the server : ");
        final String host = input.nextLine();
        System.out.println("Please enter server port: ");
        final int port = input.nextInt();
        ConnectionService connectionService = ConnectionServiceImpl.getInstance(new MessageProcessingServiceImpl());
        connectionService.startConnection(new ConnectionRequest(host,port));
        connectionService.receiveAndProcessMessage();
    }

}
