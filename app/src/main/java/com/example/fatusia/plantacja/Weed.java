package com.example.fatusia.plantacja;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public class Weed extends Plant {

    @Override
    public final Types getType(){
        return(Types.WEED);
    }

    Weed(){
        name = "Cannabis Sativa";
        substance = "THC";
    }

    Weed(String nName){
        name = nName;
        substance = "THC";
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException{

        name = (String) stream.readObject();
        substanceQuantity = (Double) stream.readObject();
        mass = (Double) stream.readObject();
        health = (Double) stream.readObject();
        planted = (Date) stream.readObject();

        type = Types.WEED;
        substance = "THC";

    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException{

        stream.writeObject(name);
        stream.writeObject(substanceQuantity);
        stream.writeObject(mass);
        stream.writeObject(health);
        stream.writeObject(planted);
        stream.flush();
    }

}
