package com.example.fatusia.plantacja;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class User {

    private static User instance;
    public static ArrayList<Greenhouse> greenhouses = new ArrayList<>();
    public static File file;
    public static boolean start = true;

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

    public static void save(final Context context) throws IOException {

        file.delete();

        User.file = new File(context.getFilesDir(), "/data.dat");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(greenhouses.size());

        for(int i=0; i<greenhouses.size(); i++){
            os.writeObject(greenhouses.get(i));
        }

        os.flush();
        os.close();
        fos.close();
    }

    public static void load(Context context) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream is = new ObjectInputStream(fis);

        int n = (int) is.readObject();
        //Toast.makeText(context, Integer.toString(n), Toast.LENGTH_SHORT).show();

        for(int i=0; i<n; i++){
            Greenhouse greenhouse = (Greenhouse) is.readObject();
            greenhouses.add(greenhouse);
        }

        is.close();
        fis.close();
        start = false;
    }

}
