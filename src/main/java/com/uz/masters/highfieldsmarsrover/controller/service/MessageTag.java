package com.uz.masters.highfieldsmarsrover.controller.service;

public enum  MessageTag {

    TELEMETRY("T"),
    INITIALIZATION("I"),
    SUCCESS("I"),
    END_OF_LIFE("E"),
    KILLED_BY_MARTIAN("K"),
    HIT_BOULDER_OR_MAP_EDGE("B"),
    FELL_INTO_A_CRATER("C");
    private String value;

    MessageTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
