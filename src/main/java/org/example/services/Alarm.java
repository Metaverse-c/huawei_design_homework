package org.example.services;

import org.example.fan.SrvListener;

public class Alarm implements SrvListener {
    @Override
    public boolean onSrvHot(int slot, int temp) {
        System.out.println("告警成功");
        return false;
    }
}
