package com.example.fatusia.plantacja;

import java.io.File;
import java.util.ArrayList;

public class User {

    private static User instance;
    public static ArrayList<Greenhouse> greenhouses = new ArrayList<>();
    public static File file;

    public synchronized static User get(){
        if (instance == null){
            instance = new User();
        }
        return instance;
    }


    private static void addPlant(Plant plant){
        Greenhouse greenhouse = new Greenhouse();
        greenhouses.add(greenhouse);
        greenhouse.setPlant(plant);
    }

    public static void newPlant(Types type, String name){
        switch (type){
            case WEED:
                Weed weed = new Weed(name);
                addPlant(weed);
                break;
            case SHROOM:
                Shroom shroom = new Shroom(name);
                addPlant(shroom);
                break;
            case CACTUS:
                Cactus cactus = new Cactus(name);
                addPlant(cactus);
                break;
        }
    }

}
