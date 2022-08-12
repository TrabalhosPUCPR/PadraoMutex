import java.util.Random;
import java.util.concurrent.Semaphore;

public class GeradorDeImpares extends Thread{
    private int[] chave;
    private Semaphore mutex;
    private int qntd_impares;
    private Contador contGlobal;

    public GeradorDeImpares(int[] chave, Semaphore mutex, Contador contGlobal) {
        this.chave = chave;
        this.mutex = mutex;
        this.qntd_impares = 0;
        this.contGlobal = contGlobal;
    }
    public void run() {
        try {
            while(this.contGlobal.getContador() < 100){
                this.mutex.acquire();
                if(this.contGlobal.getContador() >= 100) return;
                Random r = new Random();
                // pra pega numero aleatorio entre 2 numeros: (maximo - min) + min
                int impar = r.nextInt(8) + 1;
                if (impar % 2 == 0) impar++;
                
                this.qntd_impares++;
                this.chave[this.contGlobal.getContador()] = impar;
                this.contGlobal.contar();
                
                Thread.sleep(r.nextInt(500) + 100);
                this.mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getQntd(){ return qntd_impares; }
}



