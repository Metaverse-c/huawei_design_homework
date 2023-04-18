package org.example.utils;

import java.util.ArrayList;

public class FanBoxConfig {
    private int number;//风扇板包含的风扇盒数
    private ArrayList<Integer> fanchild;

    private ArrayList<String> drivenames;

    public FanBoxConfig(){
        fanchild=new ArrayList<>();
        drivenames=new ArrayList<>();
        number=0;
    }

    public ArrayList<Integer> getFanchild() {
        return fanchild;
    }
    public ArrayList<String> getDrivenames() {
        return drivenames;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addFanchild(int slot){
        fanchild.add(slot);
    }
    public void removeFanchild(int slot){
        fanchild.remove(slot);
    }
    //添加风扇盒
    public boolean addDrive(String drivename){

        drivenames.add(drivename);
        number++;
        return true;

    }
    public void addDrive(String drivename,int number){
        for(int i=0;i<number;i++){
            addDrive(drivename);
        }
    }
}
