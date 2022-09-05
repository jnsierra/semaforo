/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.logica;

import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import co.com.ud.semaforo.modelo.SemaforoVehicularModel;

/**
 *
 * @author Usuario
 */
public class AccionSemaforoLogica {
    
    public SemaforoVehicularModel ejecutarAccionSemaforo(SemaforoVehicularModel semaforoVehicularModel, ColorEnum colorEnum, EstadoEnum estadoEnum){
        if(ColorEnum.GREEN.equals(colorEnum)){
            semaforoVehicularModel.getVerde().setEstado(estadoEnum);
        }
        if(ColorEnum.ORANGE.equals(colorEnum)){
            semaforoVehicularModel.getAmarillo().setEstado(estadoEnum);
        }
        if(ColorEnum.RED.equals(colorEnum)){
            semaforoVehicularModel.getRojo().setEstado(estadoEnum);
        }
        return semaforoVehicularModel;
    }
    
    
    
}
