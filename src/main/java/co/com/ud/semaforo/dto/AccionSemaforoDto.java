package co.com.ud.semaforo.dto;

import co.com.ud.semaforo.enumeration.EstadoEnum;
import lombok.Data;

/**
 *
 * @author sierraj
 */
@Data
public class AccionSemaforoDto {
    
    private Boolean intermitencia;
    private EstadoEnum rojo;
    private EstadoEnum naranja;
    private EstadoEnum verde;
    
}
