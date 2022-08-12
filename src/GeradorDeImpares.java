package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class GeradorDeImpares extends Thread{
    private int[] Impar;
    private Semaphore mutex;


    public GeradorDeImpares(int[] Impar, Semaphore mutex) {
        this.Impar = Impar;
        this.mutex = mutex;
    }
    public void run() {
        try {
            Random r = new Random();
            Thread.sleep(r.nextInt(1000,3000));
            mutex.acquire();
            int Impar = r.nextInt(1,9);
            if (Impar % 2 == 0)Impar++;
            for(int i = 0; i < array.lenght; i++){

            }
            mutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



