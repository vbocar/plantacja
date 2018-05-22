package com.example.fatusia.plantacja;

import java.lang.reflect.Type;

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

}
