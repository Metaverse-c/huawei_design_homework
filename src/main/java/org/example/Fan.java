package org.example;
import java.util.ArrayList;
public class Fan implements InFan,SrvListener{
    private int slot;
    private int comtypes;
    private int speedmode;

    ArrayList<InSrv> srvs;

    public Fan(FanCtlConfig cfg){
        slot=cfg.getSlot();
        comtypes =cfg.getComtypes();
        speedmode = cfg.getSpeeder();
        srvs=new ArrayList<InSrv>();
        ArrayList<SrvCtlConfig> temp=cfg.getSrvs();
        for(SrvCtlConfig conf:temp){
            InSrv a=SrvFactory.getInstance().getSrv(conf);
            a.addListener(this);
            srvs.add(a);
        }
        System.out.println("srvs created successfully");
    }

    //通知机制
    @Override
    public boolean onSrvHot(int slot, int temp) {
        if(comtypes ==0){
            if(temp>=TEMPERATURE){
                speedmode=5;
            } else if(temp<TEMPERATURE&&temp>=0.8*TEMPERATURE){
                speedmode=4;
            } else if(temp<0.8*TEMPERATURE&&temp>=0.6*TEMPERATURE) {
                speedmode=3;
            } else if(temp<0.6*TEMPERATURE&&temp>=0.4*TEMPERATURE) {
                speedmode=2;
            } else if (temp<0.4*TEMPERATURE&&temp>=0.2*TEMPERATURE) {
                speedmode=1;
            }else if(temp<0.2*TEMPERATURE&&temp>=0*TEMPERATURE){
                speedmode=0;
            }
            System.out.println("自动档温度调节成功");
            return true;
        }
        System.out.println("手动档，不调节温度");
        return true;
    }

    @Override
    public boolean isMatched(int slot) {
        if(this.slot==slot){
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean manualAdjust(int speedmode) {
        if(speedmode>=0&&speedmode<=5){
            this.speedmode=speedmode;
            System.out.println("change speedmode successfully");
            return true;
        }
        System.out.println("fail to change speedmode");
        return false;
    }

    @Override
    public boolean manualWorkMode(int workmode) {
        if(workmode==0||workmode==1){
            comtypes =workmode;
            System.out.println("change workmode successfully");
            return true;
        }
        System.out.println("fail to change workmode");
        return false;
    }

    @Override
    public InSrv findSrv(int slot) {
        for(InSrv temp:srvs){
            if(temp.getSlot()==slot){
                System.out.println("find fan");
                return temp;
            }
        }
        System.out.println("false srv slot");
        return null;
    }
}
