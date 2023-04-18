package org.example.fan;

import org.example.srv.InSrv;

import java.util.ArrayList;

public interface InFan extends FanBoxAdjust {
    int TEMPERATURE=30;
    public boolean isMatched(int slot);
    public boolean manualAdjust(int speedmode);
    public boolean manualWorkMode();
    public InSrv findSrv(int slot);
    ArrayList<Integer> getChildfans();

}
