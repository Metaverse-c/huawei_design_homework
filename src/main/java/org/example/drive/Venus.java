package org.example.drive;

import org.example.utils.NetptuneStatus;

public class Venus implements HwDrive{
    private int speed;
    private String name;
    public Venus(String name,int speed){
        this.speed=speed;
        this.name=name;
    }
    public Venus(String name){
        this.name=name;
        speed=0;
    }
    @Override
    public int adjust(int speedmode) {
        this.speed=speedmode;
        return 0;
    }

    @Override
    public boolean isError() {
        System.out.println("Venus Drive Adjust Error");
        return false;
    }

    @Override
    public String getname() {
        return name;
    }
}
