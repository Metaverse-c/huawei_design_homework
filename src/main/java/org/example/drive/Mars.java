package org.example.drive;

public class Mars implements HwDrive{
    private int speed;
    private String name;
    public Mars(String name,int speed){
        this.speed=speed;
        this.name=name;
    }
    public Mars(String name){
        speed=0;
        this.name=name;
    }

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

    @Override
    public String getname() {
        return name;
    }
}
