package org.example.srv;

import org.example.fan.InFan;
import org.example.utils.BoardFactory;
import org.example.utils.FanCtlConfig;
import org.example.utils.SrvCtlConfig;

public class SrvFactory extends BoardFactory {
    //单例模式
    private static SrvFactory instance=new SrvFactory();

    private SrvFactory(){}
    public static SrvFactory getInstance(){
        return instance;
    }

    //工厂方法
    @Override
    public InFan getFan(FanCtlConfig cfg) {
        return null;
    }

    @Override
    public InSrv getSrv(SrvCtlConfig cfg) {
        return new Srv(cfg);
    }
}
