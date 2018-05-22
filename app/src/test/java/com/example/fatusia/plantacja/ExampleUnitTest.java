package com.example.fatusia.plantacja;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public static void test1(){

        Shroom shroom = new Shroom();
        Weed weed = new Weed();
        Cactus cactus = new Cactus();


        Greenhouse greenhouse = new Greenhouse();

        greenhouse.addPlant(shroom);
        greenhouse.addPlant(weed);
        greenhouse.addPlant(cactus);


        shroom.print();
        weed.print();
        cactus.print();

        User user = new User();

        user.addGreenhouse (greenhouse);
        user.greenhouses.get(0).print();

        user.podlej(0);
        user.zaswiec(0);
        user.czasMija(0);
        user.podlej(0);

        user.greenhouses.get(0).print();

        user.greenhouses.get(0).printPlants();
    }
}