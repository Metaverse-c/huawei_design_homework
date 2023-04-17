package org.example.utils;

import org.example.utils.FanCtlConfig;
import org.example.utils.SrvCtlConfig;
import org.example.fan.InFan;
import org.example.srv.InSrv;

public abstract class BoardFactory {
    public abstract InFan getFan(FanCtlConfig cfg);
    public abstract InSrv getSrv(SrvCtlConfig cfg);

}
