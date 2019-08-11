package com.uz.masters.highfieldsmarsrover.controller.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class EnemyInformation implements Serializable {

    private String enemy;
    private double xCordinate;
    private double yCordinate ;
    private double direction ;
    private double speedInMetersPerSecond;
}




