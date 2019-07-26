package com.uz.masters.highfieldsmarsrover.utils;

public interface Constants {

    interface ResponseMessage{
        String INVALID_PARAMETERS_SIZE ="Invalid Parameter Size, 2 parameters expected by the Server i.e IP Address and Port Number";
        String INVALID_PORT ="Invalid Port Number, Port number should be a number";
    }

    interface HandlerClasses{
        String HANDLER_CLASS_INITIALISATION = "com.uz.masters.highfieldsmarsrover.service.stratergy.impl.InitialisationMessageHandler";
        String HANDLER_CLASS_TELEMETRY = "com.uz.masters.highfieldsmarsrover.service.stratergy.impl.TelemetryDataMessageHandler";
        String HANDLER_CLASS_NOT_DEFINED = "Handler Class Not Found";
    }

    interface MessageTypes{
        char MESSAGE_TYPE_INIT = 'I';

        char MESSAGE_TYPE_TELEMETRY = 'T';
    }

    interface ContextParameterKeys {
        String COMMUNICATION_STILL_ACTIVE = "Communication with Rover still active";
    }
}
