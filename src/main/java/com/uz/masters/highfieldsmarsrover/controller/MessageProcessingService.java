package com.uz.masters.highfieldsmarsrover.controller;

public interface MessageProcessingService {

    String processTelemetryStream(String spaceDelimitedTelemtryToken);
    void processInitializationData(String spaceDelimitedInitializationToken);
}
