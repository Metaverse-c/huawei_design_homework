package org.example.services;
import org.example.fan.FanBox;
import org.example.fan.FanBoxAdjust;
import org.example.fan.FanFactory;
import org.example.fan.InFan;
import org.example.srv.InSrv;
import org.example.utils.FanCtlConfig;

import java.util.ArrayList;
public class FanMgr implements InFanMgr{
    private static FanMgr instance=new FanMgr();
    private FanMgr(){
        fans=new ArrayList<InFan>();
    }
    public static FanMgr getInstance() {
        return instance;
    }

    private ArrayList<InFan> fans;

    private int rootslot;


//给风扇板添加风扇盒
    @Override
    public boolean addFanBox(int slot,String name){
        InFan fan=findFanBoard(slot);
        if(fan!=null){
            FanBoxAdjust childfanbox=new FanBox(name);
            fan.add(childfanbox);
            System.out.println("succeed to add fanbox");
            return true;
        }
        System.out.println("slot error,fail to add fanbox");
        return false;
    }
    @Override
    public boolean addFanbox(int slot,FanBoxAdjust childfan){
        InFan fan=findFanBoard(slot);
        if(fan!=null){
            fan.add(childfan);
            System.out.println("succeed to add fanbox");
            return true;
        }
        System.out.println("slot error,fail to add fanbox");
        return false;
    }

    @Override
    public void formComponents() {
        for(InFan fan:fans){
            ArrayList<Integer> temp=fan.getChildfans();
            for(int slot:temp){
                InFan a= findFanBoard(slot);
                fan.add(a);
            }
        }
    }

    public void setRootslot(int rootslot) {
        this.rootslot = rootslot;
    }

    @Override
    public void showStructure() {

        InFan root=findFanBoard(rootslot);
        if(root!=null){
            System.out.println("Tips:展示树的先序遍历");
            root.showStructure();
            System.out.println(" ");
            return;
        }
        System.out.println("root is null");
    }


    @Override
    //初始化风扇与业务板配置
    public boolean initConfig(FanCtlConfig cfg) {
        FanFactory fanfac=FanFactory.getInstance();
        InFan a=fanfac.getFan(cfg);
        fans.add(a);
        System.out.println("fan created successfully");
        return true;
    }

    @Override
    public InFan findFanBoard(int slot) {
        for(InFan temp:fans){
            if(temp.isMatched(slot)){
                return temp;
            }
        }
        return null;
    }

    @Override
    public InSrv findSrvBoard(int slot) {
        for(InFan temp:fans){
            InSrv temp1=temp.findSrv(slot);
            if(temp1!=null) {
                return temp1;
            }
        }
//        System.out.println("false fan slot");
        return null;
    }

}
