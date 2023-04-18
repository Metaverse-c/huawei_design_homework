package org.example.fan;
import org.example.services.Alarm;
import org.example.utils.FanBoxConfig;
import org.example.utils.FanCtlConfig;
import org.example.utils.SrvCtlConfig;
import org.example.srv.SrvFactory;
import org.example.srv.InSrv;

import java.util.ArrayList;
public class Fan implements InFan, SrvListener {
    private int slot;
    private int comtypes;//工作模式 0-手动,1-自动;
    private int speedmode;
    private Adaptor adapt;//适配器模式
    private Strategy strategy;//策略模式
    private ArrayList<InSrv> srvs;
    private ArrayList<FanBoxAdjust> childs;//组合模式
    private ArrayList<Integer> childfans;

    public Fan(FanCtlConfig cfg){
        slot=cfg.getSlot();
        comtypes =cfg.getComtypes();
        speedmode = cfg.getSpeeder();
        String name= cfg.getDrivename();
        adapt=new Adaptor(name,speedmode);
        strategy=new AutoMode();
//        srvs=new ArrayList<InSrv>();
        FanBoxConfig boxconf=cfg.getChilds();
        initChilds(boxconf);
        ArrayList<SrvCtlConfig> temp=cfg.getSrvs();
        initSrvs(temp);
//        for(SrvCtlConfig conf:temp){
//            InSrv a= SrvFactory.getInstance().getSrv(conf);
//            a.addListener(this);
//            srvs.add(a);
//        }

    }
    private void initChilds(FanBoxConfig cfg){
        childs=new ArrayList<FanBoxAdjust>();
        int number=cfg.getNumber();
        childfans=cfg.getFanchild();
        ArrayList<String> drives=cfg.getDrivenames();
        for(String temp:drives){
            FanBoxAdjust box=new FanBox(temp);
            childs.add(box);
        }
    }

    private void initSrvs(ArrayList<SrvCtlConfig> cfg){
        srvs=new ArrayList<InSrv>();
        for(SrvCtlConfig conf:cfg){
            InSrv a= SrvFactory.getInstance().getSrv(conf);
            Alarm alarm=Alarm.getInstance();
            a.addListener(this);
            a.addListener(alarm);
            srvs.add(a);
        }
    }

    public ArrayList<Integer> getChildfans() {
        return childfans;
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
    public boolean manualWorkMode() {
        if(comtypes==0){
            comtypes =1;
            strategy=new AutoMode();
            System.out.println("change to automode");
        }else{
            comtypes =0;
            strategy=new ManualMode();
            System.out.println("change to manualmode");
        }
        return true;
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

    @Override
    public void showStructure() {
        String a="(fan "+adapt.findDrive().getname()+")";
        System.out.print(a);
        if(childs.size()==0){
            return;
        }
        for(FanBoxAdjust temp:childs){
            temp.showStructure();
        }
    }

    public boolean changeDrive(String name){
        return adapt.addDrive(name);
    }

}
