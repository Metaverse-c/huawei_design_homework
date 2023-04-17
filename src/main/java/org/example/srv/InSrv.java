package org.example.srv;

import org.example.fan.SrvListener;

public interface InSrv {
    int TEMPRATURE=30;
    int onTempChanged(int temp);
    void addListener(SrvListener listener);
    void notifyToAll();

    int getSlot();
}
