package org.example;

public class SrvCtlConfig {
    private int temp;
    private int slot;

    public SrvCtlConfig(int slot,int temp){
        this.slot=slot;
        this.temp=temp;
    }
    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
