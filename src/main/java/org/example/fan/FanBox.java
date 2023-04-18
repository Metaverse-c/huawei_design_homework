package org.example.fan;

import org.example.drive.Drive;

public class FanBox implements FanBoxAdjust{
    private Adaptor adapt;


    public FanBox( String name){
        adapt=new Adaptor(name);
    }

    @Override
    public void add(FanBoxAdjust adjust) {

    }

    @Override
    public void remove(FanBoxAdjust adjust) {

    }

    @Override
    public int adjust(int speed) {
        return adapt.adjust(speed);
    }

    @Override
    public int adjust(String name, int speed) {
        return adapt.adjust(name,speed);
    }

    @Override
    public void showStructure() {
        String a="(fanbox "+adapt.findDrive().getname()+")";
        System.out.print(a);
    }

    public boolean changeDrive(String name){
        return adapt.addDrive(name);
    }
}
