package org.example;

public abstract class BoardFactory {
    public abstract InFan getFan(FanCtlConfig cfg);
    public abstract InSrv getSrv(SrvCtlConfig cfg);

}
