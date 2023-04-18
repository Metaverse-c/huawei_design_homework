package org.example.fan;

public interface FanBoxAdjust {
    void add(FanBoxAdjust adjust);
    void remove(FanBoxAdjust adjust);
    int adjust(int speed);

    int adjust(String name,int speed);

}
