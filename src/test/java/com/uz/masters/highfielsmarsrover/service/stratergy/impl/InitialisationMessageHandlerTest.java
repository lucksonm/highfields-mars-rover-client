package com.uz.masters.highfielsmarsrover.service.stratergy.impl;

import com.uz.masters.highfieldsmarsrover.service.stratergy.IncomingRoverMessageHandler;
import com.uz.masters.highfieldsmarsrover.service.stratergy.impl.InitialisationMessageHandler;
import com.uz.masters.highfieldsmarsrover.utils.Constants;
import com.uz.masters.highfieldsmarsrover.utils.MessageProcessorResultContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={InitialisationMessageHandlerTest.class})
public class InitialisationMessageHandlerTest {

    private MessageProcessorResultContext messageProcessorResultContext;
    private IncomingRoverMessageHandler incomingRoverMessageHandler;

    @Before
    public void init() {
        incomingRoverMessageHandler = new InitialisationMessageHandler();
    }
    @Test
    public void returnTrueWhenValidInitialisationMessageIsProvided() {
      messageProcessorResultContext = incomingRoverMessageHandler.handleIncomingRoverMessage("I 200.000 200.000 30000 30.000 60.000 20.000 20.0 60.0");
      boolean result = messageProcessorResultContext.getAttribute(Constants.ContextParameterKeys.COMMUNICATION_STILL_ACTIVE);
       assertEquals(result, true);
    }

}
