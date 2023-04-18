package org.example.drive;

import org.example.utils.NetptuneStatus;

public class Nept implements Drive{
    private NetptuneStatus speed;
    private String name;
    public Nept(String name,int speed){
        this.speed=new NetptuneStatus(speed);
        this.name=name;
    }
    public Nept(String name){
        this.speed=new NetptuneStatus(0);
        this.name=name;
    }
    public NetptuneStatus getSpeed(){
        return speed;
    }
    public void setSpeed(int speedmode){
        this.speed.setSpeed(speedmode);
    }

    @Override
    public int adjust(int speedmode) {
        this.speed.setSpeed(speedmode);
        return 0;
    }

    @Override
    public boolean isError() {
        if(speed.getSpeed()>5||speed.getSpeed()<1){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String getname() {
        return name;
    }
}
