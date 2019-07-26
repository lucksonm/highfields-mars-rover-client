package com.uz.masters.highfieldsmarsrover.service.stratergy.impl;

import com.uz.masters.highfieldsmarsrover.service.stratergy.IncomingRoverMessageHandler;
import com.uz.masters.highfieldsmarsrover.utils.Constants;
import com.uz.masters.highfieldsmarsrover.utils.MessageProcessorResultContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InitialisationMessageHandler implements IncomingRoverMessageHandler{


    private static final Logger LOGGER = Logger.getLogger(InitialisationMessageHandler.class.getName());

    @Override
    public MessageProcessorResultContext handleIncomingRoverMessage(final String message) {
        LOGGER.log(Level.INFO,"<<<<<<<<<<<<<<<<<<<<<<<Incoming Initialisation Message>>>>>>>>>>>>>>>>>> "+message);
        return MessageProcessorResultContext.newInstance().addAttribute(Constants.ContextParameterKeys.COMMUNICATION_STILL_ACTIVE,true);
    }

}
