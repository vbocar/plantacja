package com.example.fatusia.plantacja;

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

}
