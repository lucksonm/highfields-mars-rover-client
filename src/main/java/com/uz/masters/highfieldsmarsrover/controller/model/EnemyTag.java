package com.uz.masters.highfieldsmarsrover.controller.model;

public enum EnemyTag {

    CRATER("c"),BOULDER("b"),
    MARTIAN("m");
    private String value;

    EnemyTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
