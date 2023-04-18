package org.example.services;

import org.example.fan.FanBoxAdjust;
import org.example.fan.InFan;
import org.example.srv.InSrv;
import org.example.utils.FanCtlConfig;

public interface InFanMgr {
    boolean initConfig(FanCtlConfig cfg);
    InFan findFanBoard(int slot);
    InSrv findSrvBoard(int slot);
    boolean addFanBox(int slot,String name);
    boolean addFanbox(int slot, FanBoxAdjust childfan);

    void formComponents();

    void setRootslot(int rootslot);

    void showStructure();//打印出该数的先序序列

}
