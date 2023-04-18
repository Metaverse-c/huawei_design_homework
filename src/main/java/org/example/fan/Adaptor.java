package org.example.fan;
import java.util.ArrayList;
import org.example.drive.Drive;
import org.example.drive.Mars;
import org.example.drive.Nept;
import org.example.drive.Venus;

public class Adaptor {
    private ArrayList<Drive> drives;
    private int pointer;//指向最新指定的驱动
    public Adaptor(){
        pointer=-1;
    }

    public Adaptor(String name){
        drives=new ArrayList<Drive>();
        Drive temp=createDrive(name);
        drives.add(temp);
        pointer=0;
    }

    public Adaptor(String name,int speed){
        drives=new ArrayList<Drive>();
        Drive temp=createDrive(name);
        temp.adjust(speed);
        drives.add(temp);
        pointer=0;
    }


    //创建驱动
    public Drive createDrive(String name){
        Drive temp=null;
        if(name=="Mars"){
            temp=new Mars(name);
        }else if(name=="Venus"){
            temp=new Venus(name);
        }else if(name=="Neptune"){
            temp=new Nept(name);
        }
        return temp;
    }
    //添加驱动
    public boolean addDrive(String name){
        if(drives.size()==0){
            Drive temp=createDrive(name);
            drives.add(temp);
            pointer=0;
            return true;
        }else {
            int i=0;
            for(Drive drive:drives){
                if(drive.getname()==name) {
                    pointer=i;
                }
                i++;
            }
            if(i==drives.size()){
                Drive temp=createDrive(name);
                drives.add(temp);
                pointer=i;
            }
            return true;
        }
    }


    //找到指定的驱动
    public Drive findDrive(String name){
        for(Drive drive:drives){
            if(drive.getname()==name) {
                return drive;
            }
        }
        return null;
    }
    public Drive findDrive(){
        return drives.get(pointer);
    }

    //调速
    int adjust(String name,int speed){
        Drive temp=findDrive(name);
        if(temp==null){
            temp=findDrive();
        }
        return temp.adjust(speed);
    }
    int adjust(int speed){
        Drive temp=findDrive();
        return temp.adjust(speed);
    }

    //返回驱动信息
    boolean isError(){
        Drive temp=findDrive();
        return temp.isError();
    }
}
