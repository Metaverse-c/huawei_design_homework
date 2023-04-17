package org.example.drive;

import org.example.utils.NetptuneStatus;

public class Nept {
    NetptuneStatus speed;
    public NetptuneStatus getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed.setSpeed(speed);
    }
}
