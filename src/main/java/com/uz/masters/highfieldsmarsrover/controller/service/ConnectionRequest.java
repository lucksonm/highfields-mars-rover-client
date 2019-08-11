package com.uz.masters.highfieldsmarsrover.controller.service;

import lombok.Data;

@Data
public class ConnectionRequest {

    private String hostName;
    private int port;

    public ConnectionRequest(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
    }
}




