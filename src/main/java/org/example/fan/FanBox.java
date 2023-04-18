package org.example.fan;

public class FanBox implements FanBoxAdjust{
    private Adaptor adapt;

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

    public boolean changeDrive(String name){
        return adapt.addDrive(name);
    }
}
