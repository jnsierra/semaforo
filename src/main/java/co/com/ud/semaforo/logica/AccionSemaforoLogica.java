/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.logica;

import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import co.com.ud.semaforo.modelo.LuzSemaforoModel;
import co.com.ud.semaforo.modelo.SemaforoModel;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Usuario
 */
public class AccionSemaforoLogica {

    public SemaforoModel ejecutarAccionSemaforo(SemaforoModel semaforoVehicularModel, ColorEnum colorEnum, EstadoEnum estadoEnum) {        
        List<LuzSemaforoModel> luces = semaforoVehicularModel.getLuces().stream().map(item -> {
            if (colorEnum.equals(item.getColor())) {
                item.setEstado(estadoEnum);
            }
            if (colorEnum.equals(item.getColor())) {
                item.setEstado(estadoEnum);
            }
            if (colorEnum.equals(item.getColor())) {
                item.setEstado(estadoEnum);
            }
            return item;
        }).collect(Collectors.toList());
        semaforoVehicularModel.setLuces(luces);
        return semaforoVehicularModel;
    }

}
