package org.example.drive;

public class Mars implements HwDrive{
    int speed;
    @Override
    public int adjust(int speedmode) {
        this.speed=speedmode;
        return 0;
    }

    @Override
    public boolean isError() {
        System.out.println("Mars Drive Adjust Error");
        return false;
    }
}