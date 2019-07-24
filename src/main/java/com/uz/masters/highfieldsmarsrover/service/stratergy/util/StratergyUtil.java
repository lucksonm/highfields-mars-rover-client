package com.uz.masters.highfieldsmarsrover.service.stratergy.util;

import com.uz.masters.highfieldsmarsrover.service.stratergy.IncomingRoverMessageHandler;
import com.uz.masters.highfieldsmarsrover.utils.Constants;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StratergyUtil {
    private static final Logger LOGGER = Logger.getLogger(StratergyUtil.class.getName());

    private StratergyUtil(){}

    @SuppressWarnings("unchecked")
    public static IncomingRoverMessageHandler generateIncomingMessageHandler(final char messageType) {
        String handlerClassName = generateIncomingMessageHandlerClass(messageType);
        IncomingRoverMessageHandler incomingRoverMessageHandler = null;
        try {
            final Class<? extends IncomingRoverMessageHandler> handlerClass = (Class<? extends IncomingRoverMessageHandler>) Class.forName(
                    handlerClassName);
            incomingRoverMessageHandler = handlerClass.newInstance();
        } catch (final Exception ex) {
            LOGGER.log(Level.SEVERE,"Excepion "+ex);
        }
        return incomingRoverMessageHandler;
    }

    private static String generateIncomingMessageHandlerClass(char messageType) {
        String handlerClass = "";
        switch (messageType) {
            case Constants.MessageTypes.MESSAGE_TYPE_INIT:
                handlerClass = Constants.HandlerClasses.HANDLER_CLASS_INITIALISATION;
                break;
            default:
                handlerClass = Constants.HandlerClasses.HANDLER_CLASS_NOT_DEFINED;
                break;
        }
        return handlerClass;
    }
}
