import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) throws Exception {
        Semaphore mutexPares = new Semaphore(1);
        Semaphore mutexImpares = new Semaphore(1);

        Contador contGlobal = new Contador();
        int chave[] = new int[100];

        GeradorDeImpares impar1 = new GeradorDeImpares(chave, mutexImpares, contGlobal);
        GeradorDeImpares impar2 = new GeradorDeImpares(chave, mutexImpares, contGlobal);
        GeradorDePares par1 = new GeradorDePares(chave, mutexPares, contGlobal);
        GeradorDePares par2 = new GeradorDePares(chave, mutexPares, contGlobal);

        // com o delay padrao ( aleatorio entre 1000 e 3000 ms ) demora ~1m40s
        
        impar1.start();
        par1.start();
        impar2.start();
        par2.start();
        System.out.println("Threads Iniciadas!");

        try{
            impar1.join();
            impar2.join();
            par1.join();
            par2.join();
            System.out.println("FIM!");
            System.out.print("[");
            for(int i = 0; i < chave.length; i++){
                System.out.print(chave[i]);
                if(i + 1 < chave.length) System.out.print(", ");
            }
            System.out.print("]");
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
