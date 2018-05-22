package com.example.fatusia.plantacja;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public abstract class Plant{

     String name;
     String substance;
    private double substanceQuantity;
    private double mass;
    private double health;
    private static int modificationCoefficient;
    private final Date planted;

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

}
