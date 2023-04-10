package org.example;

public interface InFan {
    int TEMPERATURE=30;
    public boolean isMatched(int slot);
    public boolean manualAdjust(int speedmode);
    public boolean manualWorkMode(int workmode);
    public InSrv findSrv(int slot);
}
