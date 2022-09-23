/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.presentacion;

import co.com.ud.semaforo.dto.LuzSemaforoDto;
import co.com.ud.semaforo.dto.SemaforoDto;
import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import co.com.ud.semaforo.enumeration.TipoSemaforoEnum;
import co.com.ud.semaforo.logica.EjecutaAccionLogica;
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
    private EjecutaAccionLogica ejecutaAccionLogica;

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
                .tipoSemaforo(TipoSemaforoEnum.VEHICULAR)
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
                .tipoSemaforo(TipoSemaforoEnum.PEATONAL)
                .build();
        if (Objects.isNull(vista)) {
            this.vista = new Vista(this);
        }
        if (Objects.isNull(accionSemaforoSistema)) {
            this.accionSemaforoSistema = new SemaforoSistema();
        }
        if (Objects.isNull(ejecutaAccionLogica)){
            this.ejecutaAccionLogica = new EjecutaAccionLogica(vista);
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
    
    public void ejecutarAccion(String mensaje){
        this.ejecutaAccionLogica.ejecutarAccionSemaforo(mensaje);
        
    }
}
