/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.presentacion;

import co.com.ud.semaforo.dto.SemaforoDto;
import co.com.ud.semaforo.logica.EjecutaAccionLogica;
import co.com.ud.semaforo.logica.SemaforoSistema;
import co.com.ud.semaforo.util.UtilSemaforo;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sierraj
 */
public class SemaforoModel {

    private SemaforoDto semaforoVehicular;
    private SemaforoDto semaforoPeatonal;
    @Setter
    @Getter
    private Vista vista;
    private SemaforoSistema accionSemaforoSistema;
    private EjecutaAccionLogica ejecutaAccionLogica;
    @Setter
    @Getter
    private Integer id; 
    @Setter
    @Getter
    private String nombre;

    public SemaforoModel() {
        if (Objects.isNull(vista)) {
            this.vista = new Vista(this);
        }
        if (Objects.isNull(accionSemaforoSistema)) {
            this.accionSemaforoSistema = new SemaforoSistema();
        }
    }

    public void iniciar() {
        getVista().setTitle("Vista Semaforo");
        getVista().setSize(800, 650);
        getVista().setVisible(true);
    }

    public void ejecutarAccion(String mensaje) {
        this.ejecutaAccionLogica.ejecutarAccionSemaforo(mensaje); 
    }
    
    public void mensajeInicial(String mensaje){
        String[] valores = mensaje.split("\\|");
        this.setId(Integer.parseInt(valores[1]));
        this.setNombre(valores[2]);
        this.vista.getLabelId().setText(this.getId().toString());
        this.vista.getLabelNombre().setText(this.getNombre());
    }
    
    public void incializarSemaforo(String mensaje){
        String[] valores = mensaje.split("\\|");
        //Inicializamos el primer semaforo
        if("vehicular".equalsIgnoreCase(valores[1])){
            semaforoVehicular = UtilSemaforo.inicializarSemaforoVehicular(20, 20);
        }else{
            semaforoVehicular = UtilSemaforo.inicializarSemaforoPeatonal(20,20);
        }
        
        if("vehicular".equalsIgnoreCase(valores[2])){
            semaforoPeatonal = UtilSemaforo.inicializarSemaforoVehicular(20, 200);
        }else{
            semaforoPeatonal = UtilSemaforo.inicializarSemaforoPeatonal(20,220);
        }
        vista.setSemaforoVehicular(semaforoVehicular);
        vista.setSemaforoPeatonal(semaforoPeatonal);
        vista.repintarSemaforos();
        UtilSemaforo.esperarHilo(1000L);
        if (Objects.isNull(ejecutaAccionLogica)) {
            this.ejecutaAccionLogica = new EjecutaAccionLogica(vista,semaforoVehicular, semaforoPeatonal);
        }
        this.ejecutaAccionLogica.start();
    }
    
    
}
