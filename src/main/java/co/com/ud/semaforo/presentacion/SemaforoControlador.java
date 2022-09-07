/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.presentacion;

import co.com.ud.semaforo.enumeration.ColorEnum;
import co.com.ud.semaforo.enumeration.EstadoEnum;
import co.com.ud.semaforo.enumeration.TipoSemaforo;
import co.com.ud.semaforo.logica.AccionSemaforoLogica;
import co.com.ud.semaforo.dto.LuzSemaforoDto;
import co.com.ud.semaforo.dto.SemaforoDto;
import co.com.ud.semaforo.presentacion.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
public class SemaforoControlador implements ActionListener {
    @Getter
    private Vista vista;
    
    public SemaforoControlador(Vista ventana) {
        this.vista = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       getVista().getSemaforoModel().ejecutarAccion();
    }
}
