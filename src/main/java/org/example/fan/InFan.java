package org.example.fan;

import org.example.srv.InSrv;

public interface InFan extends FanBoxAdjust {
    int TEMPERATURE=30;
    public boolean isMatched(int slot);
    public boolean manualAdjust(int speedmode);
    public boolean manualWorkMode(int workmode);
    public InSrv findSrv(int slot);
}
