package org.example;

import org.example.fan.Fan;
import org.example.fan.FanBox;
import org.example.fan.FanBoxAdjust;
import org.example.services.FanCtlAction;
import org.example.utils.FanBoxConfig;
import org.example.utils.FanCtlConfig;

public class Main {
    public static void main(String[] args) {
    //fan slot 1,2,3,11,12,13,21,22,23
    //fanbox
    //srv slot 4,5,6,7,8,9,14,15,16,17,18,19,24,25,26,27,28,29
    //1-4;2-5,6,7;3-7,8,9;11-14;12-15,16,17;13-17,18,19;21-24;22-25,26,27;23-27,28,29;
        FanCtlConfig fanCtlConfig1=new FanCtlConfig(1,0,0,"Mars");
        fanCtlConfig1.addSrv(4,0);
        FanCtlConfig fanCtlConfig2=new FanCtlConfig(2,0,0,"Venus");
        fanCtlConfig2.addSrv(5,0);
        fanCtlConfig2.addSrv(6,0);
        fanCtlConfig2.addSrv(7,0);
        FanCtlConfig fanCtlConfig3=new FanCtlConfig(3,0,0,"Neptune");
        fanCtlConfig3.addSrv(8,0);
        fanCtlConfig3.addSrv(9,0);

        //组合模式 配置树形结构
        FanBoxConfig fanBoxConfig1=new FanBoxConfig();
        fanBoxConfig1.addDrive("Mars",2);
        fanBoxConfig1.addDrive("Neptune",2);
        fanBoxConfig1.addFanchild(2);
        fanCtlConfig1.setChilds(fanBoxConfig1);

        FanBoxConfig fanBoxConfig2=new FanBoxConfig();
        fanBoxConfig2.addDrive("Mars",1);
        fanBoxConfig2.addDrive("Neptune",1);
        fanBoxConfig2.addDrive("Venus",2);
        fanBoxConfig2.addFanchild(3);
        fanCtlConfig2.setChilds(fanBoxConfig2);

        FanBoxConfig fanBoxConfig3=new FanBoxConfig();
        fanBoxConfig3.addDrive("Mars");
        fanCtlConfig3.setChilds(fanBoxConfig3);
    //初始化位置业务板和风扇板
        FanCtlAction action=new FanCtlAction();
        action.initConfig(fanCtlConfig1);
        action.initConfig(fanCtlConfig2);
        action.initConfig(fanCtlConfig3);

        //构造树并且打印树结构(组合模式)
        action.setroot(1);
        action.formComponents();
        action.showStructure();


    //修改手动模式下修改风扇速度
        action.manaualAdjust(1,2);
        action.manaualAdjust(2,5);
        action.manaualAdjust(3,1);
    //修改风扇模式
        action.manualWorkMode(1);
        action.manualWorkMode(2);
        action.manualWorkMode(1);
        action.manualWorkMode(3);
    //自动模式下自动调速以及自动告警
        action.onTempChanged(4,31);
        action.onTempChanged(10,31);
        action.onTempChanged(6,4);

    }
}