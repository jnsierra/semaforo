/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.presentacion;

import co.com.ud.semaforo.logica.ConexionServerLogica;
import co.com.ud.semaforo.logica.EscucharServerLogica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import lombok.Getter;

/**
 *
 * @author Usuario
 */
public class SemaforoControlador implements ActionListener {
    @Getter
    private final Vista vista;
    private ConexionServerLogica cliente;
    private EscucharServerLogica escucha;
    
    public SemaforoControlador(Vista ventana) {
        this.vista = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ip = vista.getIpTextField().getText();
        try {
            Integer puerto = Integer.parseInt(vista.getPortTextField().getText());
            cliente = new ConexionServerLogica(ip, puerto);
            Boolean conecto = cliente.conectarServer();
            if(!conecto){
                JOptionPane.showMessageDialog(null, "Error al conectarse al servidor");
                vista.getEstadoLabel().setText("DESCONECTADO");
            }else{
                vista.getEstadoLabel().setText("CONECTADO");
                vista.getEjecutorBoton().setEnabled(false);
                this.escucha = new EscucharServerLogica(cliente.getSocket(), getVista());
                this.escucha.start();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El puerto debe ser numerico");
        }
       //getVista().getSemaforoModel().ejecutarAccion();
       //getVista().getSemaforoModel().ejecutarAccion();
    }
}
