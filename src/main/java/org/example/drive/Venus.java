package org.example.drive;

import org.example.utils.NetptuneStatus;

public class Venus {
    NetptuneStatus speed;
    public NetptuneStatus getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed.setSpeed(speed);
    }
}
