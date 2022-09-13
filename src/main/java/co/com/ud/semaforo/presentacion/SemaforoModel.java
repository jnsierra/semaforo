/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.presentacion;

import co.com.ud.semaforo.dto.LuzSemaforoDto;
import co.com.ud.semaforo.dto.SemaforoDto;
import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import co.com.ud.semaforo.enumeration.TipoSemaforo;
import co.com.ud.semaforo.logica.SemaforoSistema;
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

    public SemaforoModel() {
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
        this.semaforoVehicular = SemaforoDto.builder()
                .numCopias(2)
                .titulo("Semaforo de Vehicular")
                .x(30)
                .y(100)
                .luces(luces)
                .tipoSemaforo(TipoSemaforo.VEHICULAR)
                .build();
        
        List<LuzSemaforoDto> lucesPeatonal = new ArrayList<>();
        lucesPeatonal.add(LuzSemaforoDto.builder()
                .color(ColorEnum.RED)
                .estado(EstadoEnum.APAGADO)
                .build());
        lucesPeatonal.add(LuzSemaforoDto.builder()
                .color(ColorEnum.GREEN)
                .estado(EstadoEnum.APAGADO)
                .build());
        semaforoPeatonal = SemaforoDto.builder()
                .numCopias(2)
                .titulo("Semaforo Peatonal")
                .x(30)
                .y(330)
                .luces(lucesPeatonal)
                .tipoSemaforo(TipoSemaforo.PEATONAL)
                .build();
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
        vista.setSemaforoVehicular(semaforoVehicular);
        vista.setSemaforoPeatonal(semaforoPeatonal);
        vista.repintarSemaforos();

    }
    
    private ColorEnum validarEncendido() {
        if (vista.getOpcRojo().isSelected()) {
            return ColorEnum.RED;
        } else if (vista.getOpcAmarillo().isSelected()) {
            return ColorEnum.ORANGE;
        }
        return ColorEnum.GREEN;
    }

    private EstadoEnum validarEstado() {
        if (getVista().getOpcEncender().isSelected()) {
            return EstadoEnum.ENCENDIDO;
        } else if (getVista().getOpcApagar().isSelected()) {
            return EstadoEnum.APAGADO;
        }
        return EstadoEnum.ROTO;
    }
    
    public void ejecutarAccion(){
        Boolean tipoSemaforoVehicular = vista.getCheckBoxVehicular().isSelected();
        if(tipoSemaforoVehicular){
            vista.setSemaforoVehicular(this.accionSemaforoSistema.ejecutarAccionSemaforo(vista.getSemaforoVehicular(), validarEncendido(), validarEstado()));
        }
        
        Boolean tipoSemaforoPeatonal = vista.getCheckBoxPeatonal().isSelected();
        if(tipoSemaforoPeatonal){ //El caso que sea falso es por que fue seleccionado peatonal
            vista.setSemaforoPeatonal(this.accionSemaforoSistema.ejecutarAccionSemaforo(vista.getSemaforoPeatonal(), validarEncendido(), validarEstado()));
        }
        this.vista.repintarSemaforos();
    
    }
}
