package com.uz.masters.highfieldsmarsrover.controller.service;

import lombok.extern.slf4j.Slf4j;
import com.uz.masters.highfieldsmarsrover.controller.model.*;
import com.uz.masters.highfieldsmarsrover.controller.exception.MarsRoverControllerException;

import java.util.ArrayList;
import java.util.List;

import static com.uz.masters.highfieldsmarsrover.controller.model.ControlInstruction.*;

@Slf4j
public class MessageProcessingServiceImpl implements MessageProcessingService{

    @Override
    public String processTelemetryStream(String spaceDelimitedTelemtryToken){
        log.debug("Processing telemetry message: {}",spaceDelimitedTelemtryToken);
        if(spaceDelimitedTelemtryToken==null || !spaceDelimitedTelemtryToken.startsWith(MessageTag.TELEMETRY.getValue())){
            throw new MarsRoverControllerException("Telemetry token must start with "+MessageTag.TELEMETRY.getValue());
        }
        return ACCELERATE.getValue();
    }

    @Override
    public void processInitializationData(String spaceDelimitedInitializationToken){
        log.debug("Processing initialization message: {}",spaceDelimitedInitializationToken);
        if(spaceDelimitedInitializationToken==null || !spaceDelimitedInitializationToken.startsWith(MessageTag.INITIALIZATION.getValue())){
            throw new MarsRoverControllerException("Initialization token must start with "+MessageTag.INITIALIZATION.getValue());
        }
        final String [] mapInfoArray=spaceDelimitedInitializationToken.split("\\s+");
        if(mapInfoArray.length!=9){
            throw new MarsRoverControllerException("Invalid initialization token");
        }
        MapInformation mapInformation=MapInformation.getInstance();
        mapInformation.setSpanOfXAxis(new Double(mapInfoArray[1]));
        mapInformation.setSpanOfYAxis(new Double(mapInfoArray[2]));
        mapInformation.setTimeLimitInMilliSeconds(new Double(mapInfoArray[3]));
        mapInformation.setMinRangeOfVehiceVisualSensorsInMeters(new Double(mapInfoArray[4]));
        mapInformation.setMaxRangeOfVehiceVisualSensorsInMeters(new Double(mapInfoArray[5]));
        mapInformation.setMaxVehicleSpeedInMetersPerSecond(new Double(mapInfoArray[6]));
        mapInformation.setMaxTurningSpeedInDegreesPerSecond(new Double(mapInfoArray[7]));
        mapInformation.setMaxHardTurningSpeedInDegreesPerSecond(new Double(mapInfoArray[8]));
        log.info("Map Information: {}",mapInformation);
    }






}
