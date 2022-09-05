/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.modelo;

import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
@Builder
public class LuzSemaforoModel {
    
    private ColorEnum color;
    private EstadoEnum estado;
    
}
