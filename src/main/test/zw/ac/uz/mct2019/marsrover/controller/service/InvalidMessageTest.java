package com.uz.masters.highfieldsmarsrover.controller.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import com.uz.masters.highfieldsmarsrover.controller.exception.MarsRoverControllerException;

import java.io.ByteArrayInputStream;
import java.net.Socket;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Socket.class, ConnectionServiceImpl.class})
public class InvalidMessageTest {

    private ConnectionServiceImpl connectionService;
    private MessageProcessingService messageProcessingService=mock(MessageProcessingService.class);
    Socket socket;

    @Before
    public void setUp() throws Exception {
        connectionService = ConnectionServiceImpl.getInstance(messageProcessingService);
        socket = Mockito.mock(Socket.class);
        connectionService.setClientSocket(socket);
    }


    @Test(expected = MarsRoverControllerException.class)
    public void shouldThrowExceptionForUnexpectedMessageTag() throws Exception {
        final String message="I 500.000 500.000 30000 30.000 60.000 20.000 20.0 60.0;D 0 -- -187.500 187.500 125.0 0.000;T 0 -- -187.500 187.500 126.0 0.000;";
        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream(message.getBytes()));
        try {
            connectionService.receiveAndProcessMessage();
        }finally {
            verify(messageProcessingService,times(1)).processInitializationData("I 500.000 500.000 30000 30.000 60.000 20.000 20.0 60.0");
            verify(messageProcessingService,times(0)).processTelemetryStream("D 0 -- -187.500 187.500 125.0 0.000");
            verify(messageProcessingService,times(0)).processTelemetryStream("T 0 -- -187.500 187.500 126.0 0.000");
        }
    }


}
