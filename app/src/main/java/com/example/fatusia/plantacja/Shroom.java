package com.example.fatusia.plantacja;

import java.io.IOException;
import java.util.Date;

public class Shroom extends Plant {

    @Override
    public final Types getType(){
        return(Types.SHROOM);
    }

    Shroom(){
        name = "Psilocybe semilanceata";
        substance = "Psylobicyna";
    }

    Shroom(String nName){
        name = nName;
        substance = "Psylobicyna";
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException{

        name = (String) stream.readObject();
        substanceQuantity = (Double) stream.readObject();
        mass = (Double) stream.readObject();
        health = (Double) stream.readObject();
        planted = (Date) stream.readObject();

        type = Types.SHROOM;
        substance = "Psylobicyna";

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
