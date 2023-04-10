package org.example;

public class FanFactory extends BoardFactory{

    //单例模式
    private static FanFactory instance=new FanFactory();

    private FanFactory(){}

    public static FanFactory getInstance(){
        return instance;
    }
    //工厂方法
    @Override
    public InFan getFan(FanCtlConfig cfg) {
        return new Fan(cfg);
    }

    @Override
    public InSrv getSrv(SrvCtlConfig cfg) {
        return null;
    }
}
