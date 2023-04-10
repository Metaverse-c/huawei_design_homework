package org.example;
import java.util.ArrayList;

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
    public boolean manualWorkMode(int slot,int commtype){
        InFan fan=mgr.findFanBoard(slot);
        if(fan!=null){
            return fan.manualWorkMode(commtype);
        }
        return false;
    }
    public boolean onTempChanged(int slot,int temp){
        InSrv  srv= mgr.findSrvBoard(slot);
        if(srv!=null){
            srv.onTempChanged(temp);
        }
        return false;
    }



}
