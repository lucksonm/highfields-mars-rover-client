package com.uz.masters.highfieldsmarsrover.service.stratergy;

import com.uz.masters.highfieldsmarsrover.utils.MessageProcessorResultContext;
import com.uz.masters.highfieldsmarsrover.utils.MessageProcessorResultContext;

public interface IncomingRoverMessageHandler {
    MessageProcessorResultContext handleIncomingRoverMessage(final String message);

}
