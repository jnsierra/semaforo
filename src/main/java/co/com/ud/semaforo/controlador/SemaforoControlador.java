/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.controlador;

import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import co.com.ud.semaforo.logica.AccionSemaforoLogica;
import co.com.ud.semaforo.modelo.LuzSemaforoModel;
import co.com.ud.semaforo.modelo.SemaforoVehicularModel;
import co.com.ud.semaforo.vista.Lienzo;
import co.com.ud.semaforo.vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
public class SemaforoControlador implements ActionListener{
    @Setter @Getter
    private Vista vista;
    
    private AccionSemaforoLogica accionSemaforoLogica;

    
    public SemaforoControlador() {
        if(Objects.isNull(vista)){
            this.vista = new Vista(this);
        }
        if(Objects.isNull(accionSemaforoLogica)){
            this.accionSemaforoLogica = new AccionSemaforoLogica();
        }
        getVista().setTitle("Vista Semaforo");
        getVista().setSize(800, 400);
        getVista().setVisible(true);
    }
    
    public void iniciar(){
        //Creamos los semaforos necesarios
        //Semaforo 1 con 2 copias
        SemaforoVehicularModel semaforoUno = SemaforoVehicularModel.builder()
                .rojo(LuzSemaforoModel.builder().color(ColorEnum.RED).estado(EstadoEnum.ENCENDIDO).build())
                .amarillo(LuzSemaforoModel.builder().color(ColorEnum.ORANGE).estado(EstadoEnum.ENCENDIDO).build())
                .verde(LuzSemaforoModel.builder().color(ColorEnum.GREEN).estado(EstadoEnum.ENCENDIDO).build())
                .build();
        semaforoUno.setNumCopias(2);
        semaforoUno.setTitulo("Semaforo de pruebas");
        semaforoUno.setX(30);
        semaforoUno.setY(100);
        vista.setSemaforo(semaforoUno);
        vista.repintarSemaforos();
    }  
    
    public ColorEnum validarEncendido() {
        if (vista.getOpcRojo().isSelected()) {
            return ColorEnum.RED;
        } else if (vista.getOpcAmarillo().isSelected()) {
            return ColorEnum.ORANGE;
        }
        return ColorEnum.GREEN;
    }
    
    public EstadoEnum validarEstado(){
        if(getVista().getOpcEncender().isSelected()){
            return EstadoEnum.ENCENDIDO;
        }else if(getVista().getOpcApagar().isSelected()){
            return EstadoEnum.APAGADO;
        }
        return EstadoEnum.ROTO;
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        vista.setSemaforo(this.accionSemaforoLogica.ejecutarAccionSemaforo(vista.getSemaforo(), validarEncendido(), validarEstado()));
        this.vista.repintarSemaforos();
        System.out.println("co.com.ud.semaforo.controlador.SemaforoControlador.actionPerformed()");
    }
}
