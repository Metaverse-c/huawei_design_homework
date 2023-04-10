package org.example;
import java.util.ArrayList;
public class FanMgr implements InFanMgr{
    private static FanMgr instance=new FanMgr();
    private FanMgr(){
        fans=new ArrayList<InFan>();
    }
    public static FanMgr getInstance() {
        return instance;
    }

    ArrayList<InFan> fans;

    @Override
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
                System.out.println("find fan");
                return temp1;
            }
        }
        System.out.println("false fan slot");
        return null;
    }
}
