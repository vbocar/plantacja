package com.example.fatusia.plantacja;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

public class Greenhouse{

    public Plant plant;
    private double lightning;
    private double hydration;
    private final Date created;
    private Date lastModified;
    private static int total =0;
    private int id;

    Greenhouse(){

        Random random = new Random();

        lightning = random.nextDouble() % 30.0;
        hydration = random.nextDouble() % 30.0;
        created = Calendar.getInstance().getTime();
        lastModified = created;
        total++;
        id = total;

    }

    public void setPlant(Plant nPlant){
        plant = nPlant;
    }

    public void setLightning(double nLightning){
        lightning = nLightning;
    }

    public double getLightning(){
        return lightning;
    }

    public void setHydration(double nHydration){
        hydration = nHydration;
    }

    public double getHydration(){
        return hydration;
    }

    public void modify (){
        lastModified = Calendar.getInstance().getTime();
    }

    public int getId(){
        return id;
    }

    public void modifyPlant(){
        double health = plant.getHealth() + (lightning + hydration)*lastModified.getTime()/80000000000000.0;
        plant.setSubstanceQuantity(plant.getSubstanceQuantity()+0.1*health);
        plant.setHealth(health);
    }

    public String print(){
        String out = "";
        out += ("SZKLARNIA" + "\n");
        out += ("Swiatlo: " + String.format("%.3g", lightning) + "%\n");
        out += ("Nawodnienie: " + String.format("%.3g", hydration) + "%\n");
        out += ("Stworzona: " + created + "\n");
        out += ("Modyfikacja: " + lastModified + "\n\n");

        return out;
    }


    public void podlej(){;

        hydration = (hydration + 50);
        if (hydration > 100) hydration = 100;
        lastModified = Calendar.getInstance().getTime();
    }

    public void zaswiec(){

        lightning = (lightning + 50);
        if (lightning > 100) lightning = 100;
        lastModified = Calendar.getInstance().getTime();
    }

    public void czasMija() {

        if (hydration > -100.0) hydration = (hydration - (lastModified.getTime()*1.5)/800000000000000.0);

        if (lightning > -100.0) lightning = (lightning - (lastModified.getTime()*8)/800000000000000.0);

        modifyPlant();
    }
}
