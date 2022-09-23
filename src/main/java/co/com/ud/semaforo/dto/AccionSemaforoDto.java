package co.com.ud.semaforo.dto;

import lombok.Data;

/**
 *
 * @author sierraj
 */
@Data
public class AccionSemaforoDto {
    
    private Boolean intermitencia;
    private Boolean rojo;
    private Boolean naranja;
    private Boolean verde;
    
}
