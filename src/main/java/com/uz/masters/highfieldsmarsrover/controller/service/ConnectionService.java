package com.uz.masters.highfieldsmarsrover.controller.service;

import com.uz.masters.highfieldsmarsrover.controller.model.ConnectionRequest;

public interface ConnectionService {

    void startConnection(ConnectionRequest connectionRequest);
    void receiveAndProcessMessage();
    void stopConnection();
}




