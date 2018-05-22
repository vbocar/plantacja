package com.example.fatusia.plantacja;

public class Cactus extends Plant {

    @Override
    public final Types getType(){
        return(Types.CACTUS);
    }

    public Cactus() {
        name = "Lophophora williamsii";
        substance = "Meskalina";
    }

    public Cactus(String nName) {
        name = nName;
        substance = "Meskalina";
    }

}

