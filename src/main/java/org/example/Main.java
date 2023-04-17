package org.example;

import org.example.services.FanCtlAction;
import org.example.utils.FanCtlConfig;

public class Main {
    public static void main(String[] args) {
    //fan slot 1,2,3
    //srv slot 4,5,6,7,8,9
    //1-4;2-5,6,7;3-8,9;
        FanCtlConfig fanCtlConfig1=new FanCtlConfig(1,0,0);
        fanCtlConfig1.addSrv(4,0);
        FanCtlConfig fanCtlConfig2=new FanCtlConfig(2,0,0);
        fanCtlConfig2.addSrv(5,0);
        fanCtlConfig2.addSrv(6,0);
        fanCtlConfig2.addSrv(7,0);
        FanCtlConfig fanCtlConfig3=new FanCtlConfig(3,0,0);
        fanCtlConfig3.addSrv(8,0);
        fanCtlConfig3.addSrv(8,0);
    //初始化位置业务板和风扇板
        FanCtlAction action=new FanCtlAction();
        action.initConfig(fanCtlConfig1);
        action.initConfig(fanCtlConfig2);
        action.initConfig(fanCtlConfig3);
    //修改风扇板工作模式与风扇速度
        action.manaualAdjust(1,2);
        action.manaualAdjust(2,5);
        action.manaualAdjust(3,1);

        action.manualWorkMode(1,1);
        action.manualWorkMode(2,1);
        action.manualWorkMode(1,0);
        action.manualWorkMode(3,0);
    //自动模式下自动调速
        action.onTempChanged(4,31);
        action.onTempChanged(10,31);
        action.onTempChanged(6,4);
//        System.out.println("Hello world!");
    }
}