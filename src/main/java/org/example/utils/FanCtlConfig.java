package org.example.utils;

import java.util.ArrayList;
public class FanCtlConfig {
    private int slot;
    private int comtypes;//0-自动模式,1-手动模式;
    //private FanCtlCommType commtype;
    private int speeder;//0-5档

    private final ArrayList<SrvCtlConfig> srvs;

    private String drivename;

    public FanCtlConfig(){
        srvs=new ArrayList<SrvCtlConfig>();
    }
    public FanCtlConfig(int slot,int comtypes,int speeder,String drivename){
        srvs=new ArrayList<SrvCtlConfig>();
        this.slot=slot;
        this.comtypes=comtypes;
        this.speeder=speeder;
        this.drivename=drivename;
    }

    public void addSrv(int slot,int temp){
        SrvCtlConfig a=new SrvCtlConfig(slot,temp);
        srvs.add(a);
    }

    public void removeSrv(int slot){
        srvs.remove(slot);
    }

    public int getSrvSize(){
        return srvs.size();
    }
    public void setSpeeder(int speeder) {
        this.speeder = speeder;
    }

    public void setComtypes(int comtypes) {
        this.comtypes = comtypes;
    }

    public int getComtypes() {
        return comtypes;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getSlot() {
        return slot;
    }

    public int getSpeeder() {
        return speeder;
    }

    public ArrayList<SrvCtlConfig> getSrvs() {
        return srvs;
    }

    public String getDrivename() {
        return drivename;
    }

    public void setDrivename(String drivename) {
        this.drivename = drivename;
    }
}
