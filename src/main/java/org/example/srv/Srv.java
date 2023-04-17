package org.example.srv;
import org.example.utils.SrvCtlConfig;
import org.example.fan.SrvListener;

import java.util.ArrayList;
public class Srv implements InSrv{
    private int slot;
    private int temp;
    private ArrayList<SrvListener> listeners;

    public Srv(SrvCtlConfig cfg){
        listeners=new ArrayList<SrvListener>();
        this.temp=cfg.getTemp();
        this.slot=cfg.getSlot();
    }

    public int getSlot() {
        return slot;
    }

    @Override
    public int onTempChanged(int temp) {
        this.temp=temp;
        notifyToAll();
        return 0;
    }
//subject的订阅机制
    @Override
    public void addListener(SrvListener listener) {
        listeners.add(listener);
    }
//subject的通知机制
    @Override
    public void notifyToAll() {
        for(SrvListener listener:listeners){
            listener.onSrvHot(slot,temp);
        }
    }
}
