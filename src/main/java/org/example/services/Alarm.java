package org.example.services;

import org.example.fan.SrvListener;

import javax.swing.plaf.PanelUI;

public class Alarm implements SrvListener {
    private static Alarm instance=new Alarm();
    private Alarm(){}

    public static Alarm getInstance(){
        return instance;
    }
    @Override
    public boolean onSrvHot(int slot, int temp) {
        if(temp>100){
            System.out.println("告警成功");
        }
        return false;
    }
}
