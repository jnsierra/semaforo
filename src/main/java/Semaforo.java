
import co.com.ud.semaforo.presentacion.SemaforoControlador;

/**
 *
 * @author Usuario
 */
public class Semaforo {

    public Semaforo() {
        SemaforoControlador semaforoControlador = new SemaforoControlador();
        semaforoControlador.iniciar();
    }

    public static void main(String[] args) {
        System.out.println("Llego al main");
        Semaforo semaforo = new Semaforo();
    }
}
