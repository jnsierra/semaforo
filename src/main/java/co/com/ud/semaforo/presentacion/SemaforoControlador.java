/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lombok.Getter;

/**
 *
 * @author Usuario
 */
public class SemaforoControlador implements ActionListener {
    @Getter
    private final Vista vista;
    
    public SemaforoControlador(Vista ventana) {
        this.vista = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       getVista().getSemaforoModel().ejecutarAccion();
    }
}
