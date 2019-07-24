package com.uz.masters.highfieldsmarsrover.service.stratergy;

import com.uz.masters.highfieldsmarsrover.utils.MessageProcessorResult;

public interface IncomingRoverMessageHandler {
    MessageProcessorResult handleIncomingRoverMessage(final String message);

}
