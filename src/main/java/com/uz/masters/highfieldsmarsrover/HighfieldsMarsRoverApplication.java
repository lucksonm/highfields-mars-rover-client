package com.uz.masters.highfieldsmarsrover;

import com.uz.masters.highfieldsmarsrover.service.RoverClientCommunicator;
import com.uz.masters.highfieldsmarsrover.utils.ParameterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class HighfieldsMarsRoverApplication implements CommandLineRunner {

	@Autowired
	private RoverClientCommunicator roverClientCommunicator;

	@Autowired
	private ParameterValidator parameterValidator;

	public static void main(String[] args) {
		SpringApplication.run(HighfieldsMarsRoverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int port = parameterValidator.validateConnectionInitialisationParameters(args);
		roverClientCommunicator.bindToRover(args[0], port);
	}

}
