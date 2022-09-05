/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.modelo;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
@Builder
public class SemaforoVehicularModel extends SemaforoModel{
    
    private LuzSemaforoModel rojo;
    private LuzSemaforoModel amarillo;
    private LuzSemaforoModel verde;
    
}
