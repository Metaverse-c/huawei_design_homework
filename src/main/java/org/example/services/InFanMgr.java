package org.example.services;

import org.example.fan.InFan;
import org.example.srv.InSrv;
import org.example.utils.FanCtlConfig;

public interface InFanMgr {
    boolean initConfig(FanCtlConfig cfg);
    InFan findFanBoard(int slot);
    InSrv findSrvBoard(int slot);

}
