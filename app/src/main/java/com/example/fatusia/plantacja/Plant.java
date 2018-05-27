package com.example.fatusia.plantacja;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public abstract class Plant implements Serializable{

     String name;
     String substance;
    Types type;
    protected double substanceQuantity;
    protected double mass;
    protected double health;
    protected static int modificationCoefficient;
    protected Date planted;

    public Types getType(){
        return Types.GENERIC;
    }

    Plant(){

        planted = Calendar.getInstance().getTime();
        substanceQuantity = 0;
        mass = 1.5;
        health = 80;
    }

    public void setMass() {
        mass = mass + ((planted.getTime() * health) / 8000000000000.0);
    }

    public double getHealth(){
        return health;
    }

    public void setHealth(double nHealth){
        health = nHealth;
    }

    public void setSubstanceQuantity(double quantity){substanceQuantity = quantity;}

    public double getSubstanceQuantity(){return substanceQuantity;}

    public String getName(){return name;}

    String print(){

        String out = "";

        out += ("Nazwa: " + name + "\n");
        out += ("Typ: " + getType() + "\n");
        out += ("Zasadzona: " + planted + "\n");
        out += ("Masa: " + mass + "g" + "\n");
        out += ("Zdrowie: " + String.format("%.3g", health) + "%" + "\n");
        out += ("Substancja: " + substance + "\n");
        out += ("Ilosc: " + substanceQuantity + "%" + "\n" + "\n");

        return out;
    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException{
        stream.writeObject(name);
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException {

    }



}
