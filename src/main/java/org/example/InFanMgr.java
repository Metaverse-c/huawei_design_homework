package org.example;

public interface InFanMgr {
    boolean initConfig(FanCtlConfig cfg);
    InFan findFanBoard(int slot);
    InSrv findSrvBoard(int slot);

}
