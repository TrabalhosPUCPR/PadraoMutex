import java.util.Random;
import java.util.concurrent.Semaphore;

public class GeradorDePares extends Thread{
    private int[] chave;
    private Semaphore mutex;
    private int qntd_pares;
    private Contador contGlobal;

    public GeradorDePares(int[] chave, Semaphore mutex, Contador contGlobal) {
        this.chave = chave;
        this.mutex = mutex;
        this.qntd_pares = 0;
        this.contGlobal = contGlobal;
    }
    public void run() {
        try {
            while(this.contGlobal.getContador() < 100){
                this.mutex.acquire();
                if(this.contGlobal.getContador() >= 100) return;
                Random r = new Random();
                // pra pega numero aleatorio entre 2 numeros: (maximo - min) + min
                int par = r.nextInt(8);
                if (par % 2 == 1) par++;
                
                this.chave[this.contGlobal.getContador()] = par;
                this.contGlobal.contar();
                this.qntd_pares++;
                
                //Thread.sleep(r.nextInt(2000) + 1000);
                Thread.sleep(r.nextInt(500) + 100);
                this.mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getQntd(){ return qntd_pares; }

}
