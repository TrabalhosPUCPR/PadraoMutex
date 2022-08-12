package com.company;

import java.sql.Array;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class GeradorDePares extends Thread{

    private int[] Par;
    private Semaphore mutex;



    public GeradorDePares(int[] Par, Semaphore mutex) {
        this.Par = Par;
        this.mutex = mutex;
    }

    public void run() {
        try {
            Random r = new Random();
            Thread.sleep(r.nextInt(1000,3000));
            mutex.acquire();
            int Par = r.nextInt(0,8);
            if (Par % 2 == 1)Par++;
            for(int i = 0; i < array.length; i++){

            }
            mutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
