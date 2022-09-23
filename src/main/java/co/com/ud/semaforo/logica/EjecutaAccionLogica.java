/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.logica;

import co.com.ud.semaforo.dto.AccionSemaforoDto;
import co.com.ud.semaforo.presentacion.Vista;
import co.com.ud.semaforo.util.UtilSemaforo;

/**
 *
 * @author sierraj
 */
public class EjecutaAccionLogica extends Thread{
    
    private Vista vista;
    private String semaforoUnoBinary;
    private String semaforoDosBinary;
    private AccionSemaforoDto accionSemaforoUno;
    private AccionSemaforoDto accionSemaforoDos;

    public EjecutaAccionLogica(Vista vista) {
        this.vista = vista;
    }
    
    public void ejecutarAccionSemaforo(String mensaje){
        String binario = UtilSemaforo.convertirBinario( Integer.parseInt(mensaje) );
        binario = UtilSemaforo.completarOchoCaractertes(binario);
        semaforoUnoBinary = binario.substring(0,4);
        semaforoDosBinary = binario.substring(4,8);
        System.out.println("binario: " + binario);
        
        accionSemaforoUno = interpretarValores(semaforoUnoBinary);
        accionSemaforoDos = interpretarValores(semaforoDosBinary);
    }
    
    public AccionSemaforoDto interpretarValores(String valor){
        AccionSemaforoDto accion = new AccionSemaforoDto();
        String item = "";
        for(int i = 0 ; i < valor.length() ; i++){
            if(i == 0 ){
                item = valor.substring(i,i+1);
                accion.setIntermitencia( "0".equalsIgnoreCase(item) ? Boolean.FALSE : Boolean.TRUE );
            }
            if(i == 2 ){
                item = valor.substring(i,i+1);
                accion.setRojo("0".equalsIgnoreCase(item) ? Boolean.FALSE : Boolean.TRUE );
            }
            if(i == 3 ){
                item = valor.substring(i,i+1);
                accion.setNaranja("0".equalsIgnoreCase(item) ? Boolean.FALSE : Boolean.TRUE );
            }
            if(i == 4 ){
                item = valor.substring(i,i+1);
                accion.setVerde("0".equalsIgnoreCase(item) ? Boolean.FALSE : Boolean.TRUE );
            }
        }
        return accion;
    }
    
}