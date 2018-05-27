package com.example.fatusia.plantacja;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public enum Types implements Serializable{
    WEED(1),
    SHROOM(2),
    CACTUS(3),
    GENERIC(0);

    private int num;
    private String desc;

    Types(){
        num = 0;
        desc = "GENERIC";
    }

    Types (int nNum){
        num = nNum;
    }

    Types(int nNum, String nDesc){
        num = nNum;
        desc = nDesc;

    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        switch(this){
            case WEED:
                stream.writeUTF("WEED");
                break;
            case SHROOM:
                stream.writeUTF("SHROOM");
                break;
            case CACTUS:
                stream.writeUTF("CACTUS");
                break;

        }
    }

    private void readObject(ObjectInputStream stream) throws IOException {
        switch (stream.readUTF()){
            case "WEED":
                num = 1;
                desc = "WEED";
        }
    }

    public String getDesc () {return desc;}
}