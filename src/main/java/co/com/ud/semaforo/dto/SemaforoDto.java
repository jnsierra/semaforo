/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.dto;

import co.com.ud.semaforo.enumeration.TipoSemaforoEnum;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
@Builder
public class SemaforoDto {
    
    private String titulo;
    private int x;
    private int y;
    private int numCopias;
    private TipoSemaforoEnum tipoSemaforo;
    private List<LuzSemaforoDto> luces;
    
}
