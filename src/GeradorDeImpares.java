import java.util.Random;
import java.util.concurrent.Semaphore;

public class GeradorDeImpares extends Thread{
    private int[] chave;
    private Semaphore mutex;
    private int qntd_impares;
    private int contGlobal;

    public GeradorDeImpares(int[] chave, Semaphore mutex, int contGlobal) {
        this.chave = chave;
        this.mutex = mutex;
        this.qntd_impares = 0;
        this.contGlobal = contGlobal;
    }
    public void run() {
        try {
            while(this.contGlobal < 100){
                Random r = new Random();
                // pra pega numero aleatorio entre 2 numeros: (maximo - min) + min
                Thread.sleep(r.nextInt(2000) + 1000);
                mutex.acquire();
                int Impar = r.nextInt(8) + 1;
                if (Impar % 2 == 0) Impar++;
                mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



