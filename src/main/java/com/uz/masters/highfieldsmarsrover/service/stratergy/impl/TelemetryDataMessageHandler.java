package com.uz.masters.highfieldsmarsrover.service.stratergy.impl;

import com.uz.masters.highfieldsmarsrover.service.stratergy.IncomingRoverMessageHandler;
import com.uz.masters.highfieldsmarsrover.utils.Constants;
import com.uz.masters.highfieldsmarsrover.utils.MessageProcessorResultContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TelemetryDataMessageHandler implements IncomingRoverMessageHandler{

    private static final Logger LOGGER = Logger.getLogger(TelemetryDataMessageHandler.class.getName());


    @Override
    public MessageProcessorResultContext handleIncomingRoverMessage(String message) {
        LOGGER.log(Level.INFO,"<<<<<<<<<<<<<<<<<<<<<<<Incoming TeleMetry Message>>>>>>>>>>>>>>>>>> "+message);
        return MessageProcessorResultContext.newInstance().addAttribute(Constants.ContextParameterKeys.COMMUNICATION_STILL_ACTIVE,true);
    }
}
