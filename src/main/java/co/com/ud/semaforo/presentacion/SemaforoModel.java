/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.presentacion;

import co.com.ud.semaforo.dto.SemaforoDto;
import co.com.ud.semaforo.dto.SemaforoMsnDto;
import co.com.ud.semaforo.logica.EjecutaAccionLogica;
import co.com.ud.semaforo.logica.SemaforoSistema;
import co.com.ud.semaforo.util.UtilSemaforo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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
        //Iniciamos la conversion de los semaforos
        Gson gson = new Gson();
        Type semaforoListType = new TypeToken<ArrayList<SemaforoMsnDto>>(){}.getType();
        ArrayList<SemaforoMsnDto> semaforoArray = gson.fromJson(valores[1], semaforoListType);  
        instanceSemaforo(semaforoArray);
        
        vista.setSemaforoVehicular(semaforoVehicular);
        vista.setSemaforoPeatonal(semaforoPeatonal);
        vista.repintarSemaforos();
        UtilSemaforo.esperarHilo(1000L);
        if (Objects.isNull(ejecutaAccionLogica)) {
            this.ejecutaAccionLogica = new EjecutaAccionLogica(vista,semaforoVehicular, semaforoPeatonal);
        }
        this.ejecutaAccionLogica.start();
    }
    
    public void instanceSemaforo(List<SemaforoMsnDto> semaforos){
        if(Objects.nonNull(semaforos) && !semaforos.isEmpty()){
            if(semaforos.size() > 0){
                this.semaforoVehicular = UtilSemaforo.inicializarSemaforo(20, 20, semaforos.get(0).getTipo(), semaforos.get(0).getCantidad());
            }
            if(semaforos.size() > 1){
                this.semaforoPeatonal = UtilSemaforo.inicializarSemaforo(20, 220, semaforos.get(1).getTipo(), semaforos.get(0).getCantidad());
            }
        }
    }
    
    
}
