package org.example.services;
import org.example.fan.FanBoxAdjust;
import org.example.fan.InFan;
import org.example.srv.InSrv;
import org.example.utils.FanCtlConfig;

public class FanCtlAction {
    private InFanMgr mgr;
    public FanCtlAction(){
        mgr=FanMgr.getInstance();
    }
    public boolean initConfig(FanCtlConfig cfg){
        return mgr.initConfig(cfg);
    }
    public boolean manaualAdjust(int slot,int speedmode){
        InFan fan=mgr.findFanBoard(slot);
        if(fan!=null){
            return fan.manualAdjust(speedmode);
        }
        return false;
    }
    public boolean manualWorkMode(int slot){
        InFan fan=mgr.findFanBoard(slot);
        if(fan!=null){
            return fan.manualWorkMode();
        }
        return false;
    }


    public boolean onTempChanged(int slot,int temp){
        InSrv srv= mgr.findSrvBoard(slot);
        if(srv!=null){
            System.out.println("find srv");
            srv.onTempChanged(temp);
        }else{
            System.out.println("fail to find srv");
        }
        return false;
    }
    public void formComponents(){
        mgr.formComponents();
    }
    public void showStructure(){
        mgr.showStructure();
    }
    public void setroot(int rootslot){
        mgr.setRootslot(rootslot);
        System.out.println("根节点设置成功");
    }


}
