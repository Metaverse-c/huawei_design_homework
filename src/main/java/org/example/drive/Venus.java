package org.example.drive;

import org.example.utils.NetptuneStatus;

public class Venus implements HwDrive{
    int speed;
    @Override
    public int adjust(int speedmode) {
        this.speed=speedmode;
        return 0;
    }

    @Override
    public boolean isError() {
        System.out.println("Venus Drive Adjust Error");
        return false;
    }
}
