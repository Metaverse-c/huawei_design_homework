package org.example.fan;
import org.example.utils.FanCtlConfig;
import org.example.utils.SrvCtlConfig;
import org.example.srv.SrvFactory;
import org.example.srv.InSrv;

import java.util.ArrayList;
public class Fan implements InFan, SrvListener {
    private int slot;
    private int comtypes;//工作模式 0-手动,1-自动;
    private int speedmode;
    private Adaptor adapt;
    private Strategy strategy;
    private ArrayList<InSrv> srvs;
    private ArrayList<FanBoxAdjust> childs;

    public Fan(FanCtlConfig cfg){
        slot=cfg.getSlot();
        comtypes =cfg.getComtypes();
        speedmode = cfg.getSpeeder();
        String name= cfg.getDrivename();
        adapt=new Adaptor(name,speedmode);
        strategy=new AutoMode();
        srvs=new ArrayList<InSrv>();
        childs=new ArrayList<>();
        ArrayList<SrvCtlConfig> temp=cfg.getSrvs();
        for(SrvCtlConfig conf:temp){
            InSrv a= SrvFactory.getInstance().getSrv(conf);
            a.addListener(this);
            srvs.add(a);
        }
        System.out.println("srvs created successfully");
    }

//1.观察者模式:通知机制
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
//2.风扇板通用接口实现
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
        adjust(speedmode);
        return true;
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
//3.组合模式
    //3.1
    @Override
    public void add(FanBoxAdjust adjust) {
        childs.add(adjust);
    }

    @Override
    public void remove(FanBoxAdjust adjust) {
        childs.remove(adjust);
    }

    @Override
  //3.2调用驱动调速
    public int adjust(int speed) {
        adapt.adjust(speed);
        if(childs.size()!=0){
            for(FanBoxAdjust adjust:childs){
                adjust.adjust(speed);
            }
        }
        return 1;
    }

    @Override
    public int adjust(String name, int speed) {
        adapt.adjust(speed);
        if(childs.size()!=0){
            for(FanBoxAdjust adjust:childs){
                adjust.adjust(name,speed);
            }
        }
        return 1;
    }
    public boolean changeDrive(String name){
        return adapt.addDrive(name);
    }

}
