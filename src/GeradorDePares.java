import java.util.Random;
import java.util.concurrent.Semaphore;

public class GeradorDePares extends Thread{
    private int[] chave;
    private Semaphore mutex;
    private int qntd_pares;
    private int contGlobal;

    public GeradorDePares(int[] chave, Semaphore mutex, int contGlobal) {
        this.chave = chave;
        this.mutex = mutex;
        this.qntd_pares = 0;
        this.contGlobal = contGlobal;
    }
    public void run() {
        try {
            while(this.contGlobal < 100){
                Random r = new Random();
                // pra pega numero aleatorio entre 2 numeros: (maximo - min) + min
                Thread.sleep(r.nextInt(2000) + 1000);
                mutex.acquire();
                int par = r.nextInt(8) + 1;
                if (par % 2 == 0) par++;
                mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
