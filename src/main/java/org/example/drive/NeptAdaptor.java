package org.example.drive;

public class NeptAdaptor implements HwDrive{
    Nept drive;
    @Override
    public int adjust(int speedmode) {
        this.drive.setSpeed(speedmode);
        return 0;
    }

    @Override
    public boolean isError() {
        System.out.println("Adaptor Drive Adjust Error");
        return false;
    }
}
