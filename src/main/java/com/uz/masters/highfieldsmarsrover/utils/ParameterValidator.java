package com.uz.masters.highfieldsmarsrover.utils;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ParameterValidator {



    public int validateConnectionInitialisationParameters(String... args) throws IllegalAccessException {
        if (args.length != 2) {
            throw new IllegalAccessException(Constants.ResponseMessage.INVALID_PARAMETERS_SIZE);
        } else {
            try {
                return Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                throw new IllegalAccessException(Constants.ResponseMessage.INVALID_PORT);
            }
        }
    }

}
