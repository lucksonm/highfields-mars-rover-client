package com.uz.masters.highfieldsmarsrover.controller.service;

public enum  ControlInstruction {

    ACCELERATE("a"),
    BRAKE("b"),
    TURN_LEFT("l"),
    TURN_HARD_LEFT("L"),
    TURN_RIGHT("r"),
    TURN_HARD_RIGHT("R");

    private String value;

    ControlInstruction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
