package org.example;

public interface InSrv {
    int TEMPRATURE=30;
    int onTempChanged(int temp);
    void addListener(SrvListener listener);
    void notifyToAll();

    int getSlot();
}
