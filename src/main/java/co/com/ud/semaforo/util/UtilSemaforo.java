package co.com.ud.semaforo.util;

/**
 *
 * @author sierraj
 */
public class UtilSemaforo {
    
    public static String convertirBinario(Integer number){
        return Integer.toBinaryString(number);
    }
    
    public static String completarOchoCaractertes(String numero){
        int tamanio = numero.length();
        for(int i = 0 ; i < 8 -tamanio  ; i++){
            numero = "0" + numero;
        }
        return numero;
    }
}
