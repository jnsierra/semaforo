/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.logica;

import co.com.ud.semaforo.dto.AccionSemaforoDto;
import co.com.ud.semaforo.dto.SemaforoDto;
import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import co.com.ud.semaforo.presentacion.Vista;
import co.com.ud.semaforo.util.UtilSemaforo;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sierraj
 */
public class EjecutaAccionLogica extends Thread {

    private Vista vista;
    private String semaforoUnoBinary;
    private String semaforoDosBinary;
    private AccionSemaforoDto accionSemaforoUno;
    private AccionSemaforoDto accionSemaforoDos;
    @Getter
    @Setter
    private SemaforoDto semaforoVehicular;
    @Getter
    @Setter
    private SemaforoDto semaforoPeatonal;
    @Setter
    private Boolean cambioAccion;

    public EjecutaAccionLogica(Vista vista, SemaforoDto semaforoVehicular, SemaforoDto semaforoPeatonal) {
        this.vista = vista;
        this.semaforoVehicular = semaforoVehicular;
        this.semaforoPeatonal = semaforoPeatonal;
        cambioAccion = Boolean.TRUE;
    }

    public void ejecutarAccionSemaforo(String mensaje) {
        String binario = UtilSemaforo.convertirBinario(Integer.parseInt(mensaje));
        binario = UtilSemaforo.completarOchoCaractertes(binario);
        semaforoUnoBinary = binario.substring(0, 4);
        semaforoDosBinary = binario.substring(4, 8);
        System.out.println("binario: " + binario);

        accionSemaforoUno = interpretarValores(semaforoUnoBinary);
        accionSemaforoDos = interpretarValores(semaforoDosBinary);
        cambioAccion = Boolean.TRUE;
    }

    public AccionSemaforoDto interpretarValores(String valor) {
        AccionSemaforoDto accion = new AccionSemaforoDto();
        String item = "";
        for (int i = 0; i < valor.length(); i++) {
            if (i == 0) {
                item = valor.substring(i, i + 1);
                accion.setIntermitencia("0".equalsIgnoreCase(item) ? Boolean.FALSE : Boolean.TRUE);
            }
            if (i == 1) {
                item = valor.substring(i, i + 1);
                accion.setRojo("0".equalsIgnoreCase(item) ? EstadoEnum.APAGADO : EstadoEnum.ENCENDIDO);
            }
            if (i == 2) {
                item = valor.substring(i, i + 1);
                accion.setNaranja("0".equalsIgnoreCase(item) ? EstadoEnum.APAGADO : EstadoEnum.ENCENDIDO);
            }
            if (i == 3) {
                item = valor.substring(i, i + 1);
                accion.setVerde("0".equalsIgnoreCase(item) ? EstadoEnum.APAGADO : EstadoEnum.ENCENDIDO);
            }
        }
        return accion;
    }

    @Override
    public void run() {
        Boolean intermitencia = Boolean.FALSE;
        while (true) {
            intermitencia = this.cambiaSemaforos(intermitencia);
            this.vista.setSemaforoPeatonal(semaforoPeatonal);
            this.vista.setSemaforoVehicular(semaforoVehicular);
            this.vista.repintarSemaforos();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecutaAccionLogica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Boolean cambiaSemaforos(Boolean intermitencia) {
        //Interpretamos los cambios que se deben realizar
        if (Objects.nonNull(getSemaforoVehicular()) && Objects.nonNull(accionSemaforoUno) &&  accionSemaforoUno.getIntermitencia()) {
            if (intermitencia) {
                this.cambiaLuces(accionSemaforoUno, getSemaforoVehicular());
            } else {
                this.apagaSemaforo(getSemaforoVehicular());
            }

        }else if(Objects.nonNull(getSemaforoVehicular()) && Objects.nonNull(accionSemaforoUno) && cambioAccion){
            this.cambiaLuces(accionSemaforoUno, getSemaforoVehicular());
        }
        
        
        if (Objects.nonNull(getSemaforoPeatonal()) && Objects.nonNull(accionSemaforoDos) && accionSemaforoDos.getIntermitencia()) {
            if (intermitencia) {
                this.cambiaLuces(accionSemaforoDos, getSemaforoPeatonal());
            } else {
                this.apagaSemaforo(getSemaforoPeatonal());
            }

        }else if(Objects.nonNull(getSemaforoPeatonal()) && Objects.nonNull(accionSemaforoDos) && cambioAccion){
             this.cambiaLuces(accionSemaforoDos, getSemaforoPeatonal());
        }
        cambioAccion = Boolean.FALSE;
        return !intermitencia;
    }

    public void cambiaLuces(AccionSemaforoDto accionSemaforoDto, SemaforoDto semaforoDto) {
        if (Objects.nonNull(accionSemaforoDto)) {
            if(Objects.isNull(semaforoDto)  ){
                System.out.println("Este es el error");
            }

            semaforoDto.getLuces().stream().parallel().forEach(item -> {
                if (ColorEnum.RED.equals(item.getColor())) {
                    item.setEstado(accionSemaforoDto.getRojo());
                }
                if (ColorEnum.ORANGE.equals(item.getColor())) {
                    item.setEstado(accionSemaforoDto.getNaranja());
                }
                if (ColorEnum.GREEN.equals(item.getColor())) {
                    item.setEstado(accionSemaforoDto.getVerde());
                }
            });

        }
    }

    public void apagaSemaforo(SemaforoDto semaforoDto) {
        semaforoDto.getLuces().stream().parallel().forEach(item -> {
            item.setEstado(EstadoEnum.APAGADO);
        });
    }

}
