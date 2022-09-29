package co.com.ud.semaforo.util;

import co.com.ud.semaforo.dto.LuzSemaforoDto;
import co.com.ud.semaforo.dto.SemaforoDto;
import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import co.com.ud.semaforo.enumeration.TipoSemaforoEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static SemaforoDto inicializarSemaforoVehicular(int x, int y){
        List<LuzSemaforoDto> luces = new ArrayList<>();
        luces.add(LuzSemaforoDto.builder()
                .color(ColorEnum.RED)
                .estado(EstadoEnum.APAGADO)
                .build());
        luces.add(LuzSemaforoDto.builder()
                .color(ColorEnum.ORANGE)
                .estado(EstadoEnum.APAGADO)
                .build());
        luces.add(LuzSemaforoDto.builder()
                .color(ColorEnum.GREEN)
                .estado(EstadoEnum.APAGADO)
                .build());
        return SemaforoDto.builder()
                .numCopias(2)
                .titulo("Semaforo de Vehicular")
                .x(x)
                .y(y)
                .luces(luces)
                .tipoSemaforo(TipoSemaforoEnum.VEHICULAR)
                .build();
    }
    
    public static SemaforoDto inicializarSemaforoPeatonal(int x, int y){
        List<LuzSemaforoDto> lucesPeatonal = new ArrayList<>();
        lucesPeatonal.add(LuzSemaforoDto.builder()
                .color(ColorEnum.RED)
                .estado(EstadoEnum.APAGADO)
                .build());
        lucesPeatonal.add(LuzSemaforoDto.builder()
                .color(ColorEnum.GREEN)
                .estado(EstadoEnum.APAGADO)
                .build());
        return SemaforoDto.builder()
                .numCopias(2)
                .titulo("Semaforo Peatonal")
                .x(x)
                .y(y)
                .luces(lucesPeatonal)
                .tipoSemaforo(TipoSemaforoEnum.PEATONAL)
                .build();
    }
    
    public static void esperarHilo(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(UtilSemaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
